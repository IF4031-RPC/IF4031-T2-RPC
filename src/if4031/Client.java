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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static String token = "";
    public static ArrayList<ChannelLastMsg> list = new ArrayList<>();
    
    public static void main(String [] args) {
        new Thread(new ReadRunnable()).start();
        new Thread(new PrintRunnable()).start();
    }
}

 class ReadRunnable implements Runnable {
    @Override
    public void run() {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            ServerService.Client client = new ServerService.Client(protocol);
            perform(client);
            
            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }
    
    private static void perform(ServerService.Client client) throws TException
    {
        String uuid = null;
        while (true) {
            Scanner in = new Scanner(System.in);
            
            System.out.print("Please enter your command: ");
            String command = in.nextLine();
            
            String[] com = command.split(" ", 2);
            switch (com[0]) {
                case "/NICK": 
                    Client.token = client.iSend(Client.token, command);
                    System.out.println(Client.token);
                    break;
                case "/JOIN": 
                    System.out.println(client.iSend(Client.token, command));
                    if (Client.list.add(new ChannelLastMsg(0, com[1]))) {
                        System.out.println("Sukses nambahin channel ke client");
                        System.out.println(Client.list.get(0).channel);
                    }
                    
                    break;
                case "/LEAVE": 
                    System.out.println(client.iSend(Client.token, command));
                    delElement(Client.list, com[1]);
                    break;
                default:
                    //send message to a channel
                    System.out.println(client.iSend(Client.token, command));
                    break;
            }
        }
    }
    
    private static void delElement(List<ChannelLastMsg> clms, String channel)
    {
        System.out.println("di dalam delete" + clms.get(0).channel);
        Iterator<ChannelLastMsg> itr = clms.iterator();
        while(itr.hasNext())
        {
            ChannelLastMsg clm = (ChannelLastMsg)itr.next();
            if(clm.channel.equals(channel))
            {
                itr.remove();
                break;
            }
        }
//        for(ChannelLastMsg clm : clms)
//        {
//            if(clm.channel.equals(channel))
//            {
//                clms.
//            }
//        }
    }
}

class PrintRunnable implements Runnable {
    @Override
    public void run() {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            ServerService.Client client = new ServerService.Client(protocol);
            perform(client);
            
            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(PrintRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void perform(ServerService.Client client) throws TException, InterruptedException
    {
        while (true) {
            try{
                String a = client.getMessage(Client.list, Client.token); //getMessage
                if(!a.equals(""))
                    System.out.println(a);
            }
            catch(Exception e)
            {
                
            }
            Thread.sleep(500);
        }
    }
}
