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
import org.apache.thrift.TException;
import java.util.List;

public class ServerHandler implements ServerService.Iface {

    @Override
    public String regNick(String token, String nick) throws TException {
        if (token == null && nick != null) {
            if (1 == 1) {
                //save
                return nick;
            }
            else {
                return "Nick exists!";
            }
        }
        else if (token == null && nick == null) {
            //find nick
            //save nick
            return nick;
        }
        else {
            return "Cannot register your nick.";
        }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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