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
import java.util.Random;
import org.apache.thrift.transport.TTransportException;

public class ServerHandler implements ServerService.Iface {

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
            return newNick;
        }
        else {
            //already registered
            return "Cannot register your nick.";
        }
    }

    @Override
    public String joinChannel(String token, String channel) throws TException {
        if (isChannelExist(channel)) {
            //if channel exists
            //join channel
            return "Channel subscribed.";
        }
        else {
            //if channel doesn't exist
            //create AND join channel
            return "Channel created and subscribed.";
        }
    }

    @Override
    public String leaveChannel(String token, String channel) throws TException {
        if (isChannelSubscribed(channel)) {
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
    public String iSend(String token, String message) throws TTransportException, TException {
        String response = "";
        try {
            String[] command = message.split(" ", 2);
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
        } catch (Exception e) {
            if (message.compareTo("/nick") == 0) {
                //random nick
                response = regNick(token, null);
            }
            else if ((message.compareTo("/join") == 0) || (message.compareTo("/leave") == 0)) {
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
        return true;
    }

    @Override
    public boolean isChannelExist(String channel) throws TException {
        return true;
    }

    @Override
    public boolean isChannelSubscribed(String channel) throws TException {
        return true;
    }

    @Override
    public String saveNick(String nick) throws TException {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteMember(String token, String channel) throws TException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}