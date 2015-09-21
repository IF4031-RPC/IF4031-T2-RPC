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

public class ServerHandler implements ServerService.Iface {

    /* Db Config */
    MongoClient mongoClient = new MongoClient("localhost");
    MongoDatabase database = mongoClient.getDatabase("chatRPC");
    
    @Override
    public String regNick(String token, String nick) throws TException {
        return nick;
    }

    @Override
    public String joinChannel(String token, String channel) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String leaveChannel(String token, String channel) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}