package org.nsd;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedServer {
    public static void main(String[] args) {
        int serverPort = 1235;
        int num = 0;
        Socket s;
        ServerSocket server;

        try
        {
            server = new ServerSocket(serverPort);
            System.out.println("Server started...waiting for clients.");
            while(true)
            {
                s = server.accept();
                num++;
                System.out.println("Connection accepted from client :" +num);
                ServerThread ser = new ServerThread(s);
                ser.start();
            }
        }catch(IOException ie)
        {
            System.out.println(ie.getMessage());
        }
    }
}
