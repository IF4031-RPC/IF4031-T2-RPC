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

public class Client {
    
        public static void main(String [] args) {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            ServerService.Client client = new ServerService.Client(protocol);
            perform(client);
            
            Runnable simple = new Runnable() {
                public void run() {
                    
                        System.out.println("Hello from a thread!");
                }
            };
            new Thread(simple).start();
            
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
