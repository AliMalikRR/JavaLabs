package org.nsd;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient
{
    public static void main(String[] args)
    {
        Socket client = null;
        int serverPort = 1235;
        String hostName = "localhost";
        String message;

        try
        {
            client = new Socket(hostName, serverPort);
            BufferedReader reader;
            InputStreamReader in;
            OutputStreamWriter out;
            PrintWriter writer;

            OutputStream ot = client.getOutputStream();
            out = new OutputStreamWriter(ot);
            writer = new PrintWriter(out, true);

            InputStream  ir = client.getInputStream();
            in = new InputStreamReader(ir);
            reader = new BufferedReader(in);

            Scanner input = new Scanner(System.in);
            System.out.println("Enter a message to send to the server.");
            while(input.hasNextLine())
            {
                message = input.nextLine();
                writer.println(message);
                String data = reader.readLine();
                System.out.println("Message from the server : " + data);
            }

            writer.close();
            reader.close();
            client.close();
        }
        catch(IOException ie)
        {
            System.out.println(ie.getMessage());
        }
    }
}