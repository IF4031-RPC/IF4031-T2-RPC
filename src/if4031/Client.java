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
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import if4031.ServerService;

public class Client {
    public static void main(String [] args) {
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
        String a = client.regNick("abc", "qwe");
        System.out.println(a);
    }
}
