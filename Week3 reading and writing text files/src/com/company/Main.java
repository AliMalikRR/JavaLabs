package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main
{

    public static void main(String[] args)
    {
        // how to read and write from text files

        File file = new File("score.txt"); // firstly we create a new text file and we called it score and the varible name was file.

        try
        {
            PrintWriter writer = new PrintWriter(file); // now we create a print writer to write to the new text file we made thats why we passed in the file we just made in the brackets. Also we wrap it in a try catch because otherwise we get an error the ide does this for us.

            writer.println("ALi Malik"); // writing some students to the file
            writer.println(90);

            writer.println("Jon Jones"); // writing some students to the file
            writer.println(70);

            writer.println("Big Man"); // writing some students to the file
            writer.println(90);

            writer.close(); // we close the writer to prevent data leaks
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Oh no something went wrong :("); // make an error message in case something does go wrong the user will know
            e.printStackTrace();
        }
        System.out.println("The file has been written successfully :)");

        // So this is how to create a text file on your disk and then write to that file using the printwriter method
    }

}
