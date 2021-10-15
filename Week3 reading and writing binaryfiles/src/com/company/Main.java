package com.company;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Main {

    public static void main(String[] args)
    {
        File file = new File("rose-blue.jpg"); // create a new file that we are going to write to and pass it the file we want to readfrom.

        FileInputStream in; // we are going to usr the FileInputStream to read from the binary file
        FileOutputStream out; // we are going to use the FileOutputStream to write the binary file

        // The reason we use these is for efficiency when reading and writing media files (binary files)
        BufferedInputStream bif;
        BufferedOutputStream bof;

        try
        {
            in = new FileInputStream(file); // use the file input stream for reading from the file and wrap the file in it
            out = new FileOutputStream(file); // samething for output

            bif = new BufferedInputStream(in); // use the more effieicent buffered input
            bof = new BufferedOutputStream(out); // user the more effieicent buffered output

            // this is a bit confusing but this is reading and writing from the binary file
            int j;

            while((j=bif.read())!=-1)
            {
                bof.write(j);
            }

            System.out.println("The has been sucesfully read and written"); // prompt the user

        }
        catch (FileNotFoundException fnfe) // these are just in case there are some error exceptions and then we also promtpt the user that there was an issue.
        {
            System.out.println("The file cannot be found");
            fnfe.printStackTrace();
        }
        catch (IOException io)
        {
            System.out.println("Something went wrong :(");
        }

        // this is how to read and write from binary files
    }
}
