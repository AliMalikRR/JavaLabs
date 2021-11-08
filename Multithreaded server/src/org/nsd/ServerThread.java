package org.nsd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread // create the thread class
{
    private Socket client;
    private PrintWriter toClient;
    private BufferedReader fromClient;

    public ServerThread(Socket socket)
    {
        try
        {
            this.client = socket;
            toClient = new PrintWriter(client.getOutputStream(), true);
            fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));

        }
        catch(IOException ie)
        {
            System.out.println(ie.getMessage());
        }
    }

    @Override
    public void run() // this is the code we want to run for each client trying to connect to the server
    {

        try
        {
            String message;
            while((message= fromClient.readLine())!=null)
            {
                System.out.println("Message from client: " + message);
                toClient.println("Hello client, I received this from you: " + message);
                System.out.println("Message has been echoed back to the client");
            }
        }
        catch(IOException ie) // IO exception
        {
            System.out.println(ie.getMessage());
        }

    }
}
