/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if4031;

/**
 *
 * @author Imballinst
 */
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Sorts.descending;
import org.apache.thrift.TException;
import java.util.List;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import java.util.Collection;
import java.util.Random;
import org.apache.thrift.transport.TTransportException;


public class ServerHandler implements ServerService.Iface {

    /* Db Config */
    MongoClient mongoClient = new MongoClient("localhost");
    MongoDatabase database = mongoClient.getDatabase("chatRPC");
    
    @Override
    public String regNick(String token, String nick) throws TException {
        if (token == null && nick != null) {
            if (isNickExist(nick)) {
                //nick exists
                return "Nick exists!";
            }
            else {
                //if nick doesn't exist
                nick = saveNick(nick);
                return nick;
            }
        }
        else if (token == null && nick == null) {
            String newNick = "";
            do {
                newNick = randomNick();
            } while (isNickExist(newNick));
            //save nick
            saveNick(nick);
            return newNick;
        }
        else {
            //already registered
            return "Nick already registered.";
        }
    }

    @Override
    public String joinChannel(String token, String channel) throws TException {
        
        /* cek channel exist */
        if(this.isChannelExist(channel))
        {
            /* subscribe */
            this.subscribeChannel(token, channel);
            return "Channel subscribed.";
        }
        else
        {
            // create channel 
            this.createChannel(channel);
            
            /* subscribe */
            this.subscribeChannel(token, channel);
            return "Channel created and subscribed.";
        }
    }
    
    private boolean subscribeChannel(String token, String channel)
    {
        MongoCollection<Document> userCollection = database.getCollection("User");
        Document channelDoc = new Document("name", channel);
        Document listChannel = new Document("channels", channel);
        userCollection.updateOne(eq("nick", token), new Document("$push", listChannel));
        //userCollection.updateOne(eq("nick", token), new Document("$set",new Document("channel", channel)));
        return true;
    }

    @Override
    public String leaveChannel(String token, String channel) throws TException {
        if (isChannelSubscribed(channel)) {
            //if channel is subscribed
            //leave channel
            this.leave(token, channel);
            return "Channel unsubscribed.";
        }
        else {
            //if channel isn't subcribed
            return "You aren't subscribed to that channel.";
            
        }
    }
    
    private boolean leave(String token, String channel)
    {
        MongoCollection<Document> userCollection = database.getCollection("User");
        Document match = new Document("nick", token);
        Document remove = new Document("channels", channel);
        userCollection.updateOne(match, new Document("$pull", remove));
//        userCollection.updateOne(eq("nick",token), new Document("$pull", remove));
        return true;
    }

    @Override
    public boolean saveMessage(String token, String channel, String message) throws TException {
        return this.saveToDB(token, channel, message);
    }

    @Override
    public boolean saveToDB(String token, String channel, String message) throws TException {
        MongoCollection<Document> collection = database.getCollection("Message");
        int lastId;
        try
        {
            lastId = this.getLastMessageId();
            lastId++;
        }
        catch(Exception e){
            System.out.println("Masuk exception");
            lastId = 1;
        }
        Document doc = new Document("id", lastId)
                        .append("nick", token)
                        .append("channel", channel)
                        .append("message", message);
        collection.insertOne(doc);
        return true;
    }
    
    private int getLastMessageId()
    {
        MongoCollection<Document> collection = database.getCollection("Message");
        Document myDoc = collection.find().sort(descending("id")).first();
        return myDoc.getInteger("id");
    }

    @Override
    public String getMessage(List<ChannelLastMsg> clm, String token) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String iSend(String token, String message) throws TTransportException, TException {
        String response = "";
        try {
            String[] command = message.split(" ", 2);
            switch (command[0]) {
                case "/NICK": 
                    response = regNick(token, command[1]);
                    break;
                case "/JOIN": 
                    response = joinChannel(token, command[1]);
                    break;
                case "/LEAVE": 
                    response = leaveChannel(token, command[1]);
                    break;
                default:
                    //send message to a channel
                    if (command[0].charAt(0) == '@') {
                        //correct
                        //savemessage
                        response = "Success sending message to the channel!";
                    }
                    else {
                        //false
                        response = "Failed sending message to the channel.";
                    }
                    break;
            }
        } catch (Exception e) {
            if (message.compareTo("/NICK") == 0) {
                //random nick
                response = regNick(token, null);
            }
            else if ((message.compareTo("/JOIN") == 0) || (message.compareTo("/LEAVE") == 0)) {
                //error
                response = "Please enter channel name!";
            }
            else if (message.charAt(0) == '@') {
                response = "Please enter your message for the channel.";
            }
            else {
                response = "Invalid command.";
            }
        }
        return response;
    }

    @Override
    public boolean isNickExist(String nick) throws TException {
        MongoCollection<Document> userCollection = database.getCollection("User");
        return userCollection.find(eq("nick", nick)).first() != null;
    }

    @Override
    public boolean isChannelExist(String channel) throws TException {
        MongoCollection<Document> channelCollection = database.getCollection("Channel");
        return channelCollection.find(eq("name", channel)).first() != null;
    }

    @Override
    public boolean isChannelSubscribed(String channel) throws TException {
        return true;
    }

    @Override
    public String saveNick(String nick) throws TException {
        MongoCollection<Document> userCollection = database.getCollection("User");
        Document doc = new Document("nick", nick);
        userCollection.insertOne(doc);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String randomNick() throws TException {
        String nick = "";
        String[] pool = {"Zacky", "Raddy", "Will", "Ohm", "Ary", "Ardee", "Ilma", "Khidr", "Galang", "Theo", "Tereta", "Rossi", 
            "Ivina", "Nicy", "Kiito"};
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        int randomNick = randomGenerator.nextInt(15);
        
        nick = pool[randomNick].concat(Integer.toString(randomInt));
        return nick;
    }

    @Override
    public String createChannel(String channel) throws TException {
        MongoCollection<Document> channelCollection = database.getCollection("Channel");
            
            /* channel not exist */
            Document doc = new Document("name", channel);
        
            channelCollection.insertOne(doc);
            
            return "Channel berhasil dibuat";
    }

    @Override
    public String deleteMember(String token, String channel) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
