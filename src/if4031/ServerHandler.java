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

public class ServerHandler implements ServerService.Iface {

    /* Db Config */
    MongoClient mongoClient = new MongoClient("localhost");
    MongoDatabase database = mongoClient.getDatabase("chatRPC");
    
    @Override
    public String regNick(String token, String nick) throws TException {
        if (token == null && nick != null) {
            if (1 == 1) {
                //if nick doesn't exist
                //save
                return nick;
            }
            else {
                //nick exists
                return "Nick exists!";
            }
        }
        else if (token == null && nick == null) {
            //random a nick
            //find nick
            //save nick
            return nick;
        }
        else {
            //already registered
            return "Cannot register your nick.";
        }
    }

    @Override
    public String joinChannel(String token, String channel) throws TException {
        MongoCollection<Document> channelCollection = database.getCollection("Channel");
        MongoCollection<Document> userCollection = database.getCollection("User");
        
        System.out.println(channelCollection.find(eq("name", channel)).first());
        
        /* cek channel exist */
        if(channelCollection.find(eq("name", channel)).first() == null)
        {
            /* channel not exist */
            Document doc = new Document("name", channel);
        
            channelCollection.insertOne(doc);
            
            /* subscribe */
            userCollection.updateOne(eq("nick", token), new Document("$set",new Document("channel", channel)));
            
            return "Channel created and subscribed.";
        }
        else
        {
            userCollection.updateOne(eq("nick", token), new Document("$set",new Document("channel", channel)));
            return "Channel subscribed.";
        }
    }

    @Override
    public String leaveChannel(String token, String channel) throws TException {
        if (1 == 1) {
            //if channel is subscribed
            //leave channel
            return "Channel unsubscribed.";
        }
        else {
            //if channel isn't subcribed
            return "You aren't subscribed to that channel.";
        }
    }

    @Override
    public boolean saveMessage(String token, String channel, String message) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String iSend(String token, String message) throws TException {
        String[] command = message.split(" ", 2);
        String response = "";
        switch (command[0]) {
            case "/nick": 
                response = regNick(token, command[1]);
                break;
            case "/join": 
                response = joinChannel(token, command[1]);
                break;
            case "/leave": 
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
        return response;
    }

    @Override
    public boolean isNickExist(String nick) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isChannelExist(String channel) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isChannelSubscribed(String channel) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String saveNick(String nick) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String randomNick() throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String createChannel(String channel) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteMember(String token, String channel) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}