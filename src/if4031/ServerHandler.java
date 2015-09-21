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
            //if nick exists
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
        if (1 == 1) {
            //if channel doesn't exist
            //create AND join channel
            return "Channel created and subscribed.";
        }
        else {
            //if channel exists
            //join channel
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}