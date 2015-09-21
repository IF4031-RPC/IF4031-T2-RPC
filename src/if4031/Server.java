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
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;

import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class Server {
    public static ServerHandler handler;
    public static ServerService.Processor processor;
    
    public static void main(String [] args) {
        try {
            handler = new ServerHandler();
            processor = new ServerService.Processor(handler);
            
            Runnable simple = new Runnable() {
                public void run() {
                    simple(processor);
                }
            };
//            Runnable simple2 = new Runnable() {
//                public void run() {
//                    simple2(processor);
//                }
//            };
//            
//            new Thread(simple).start();
//            new Thread(simple2).start();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
    
    public static void simple(ServerService.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
    
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void simple2(ServerService.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
    
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("Starting the pull threading...");
            server.serve();
            
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
