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
            
            String a = client.iSend(null, command);
            System.out.println(a);
        }
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
            String a = client.getMessage(null, null); //getMessage
            System.out.println(a);
            Thread.sleep(500);
        }
    }
}
