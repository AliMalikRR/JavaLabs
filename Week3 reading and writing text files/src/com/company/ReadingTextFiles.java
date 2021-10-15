package com.company;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadingTextFiles
{
    // This is how to read from the text file

    // we need to create a new file object to represent the file that we want to read from
    File file = new File("score.txt"); // WE ARE PASSING IN score.TXT AS THIS IS THE TEXT FILE WE WANT TO READ FROM
    try
    {
        Scanner read = new Scanner(file); // we wrap the file we want to read from inside the scanner
        System.out.println("Reading from the text file"); // giving the user a prompt
        while(read.hasNextLine()) // create a while loop to go over the file to read everyline
        {
            // we need to create some varibles to store all the data we are reading from the file
            String name = read.nextLine(); // we put a name in the text file so we are storing it to this varible when reading it
            Integer score = read.nextInt(); // we also put a score in the text file so we are storing it to this varible when reading it

            System.out.println();

            System.out.println("Name: " + name + "Score: " + score);
        }
        read.close(); // close the scanner to prevent data leaks
    }
    catch(IOException ioe){
        System.out.println("Oh no something went wrong :(");
}

}
