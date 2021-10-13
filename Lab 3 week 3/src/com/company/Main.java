package com.company;
import jdk.dynalink.beans.StaticClass;

import javax.sql.rowset.CachedRowSet;
import java.io.*;
import java.util.*;

public class Main
{
    public static void question1()
    {
        // Q1

        File file = new File("C:\\Users\\Alima\\IdeaProjects\\Lab 3 week 3\\src\\Me(1)(1).mp3"); // Importing file using relative path
        File f = new File("C:\\Users\\Alima\\IdeaProjects\\Lab 3 week 3\\src\\Me(2)(2).mp3"); // creating a new and empty file

        FileInputStream in;
        FileOutputStream out;

        BufferedInputStream bif;
        BufferedOutputStream bof;

        try
        {
            in = new FileInputStream(file);
            out = new FileOutputStream(f);

            bif = new BufferedInputStream(in);
            bof = new BufferedOutputStream(out);

            int j;

            while((j=bif.read())!=-1)
            {
                bof.write(j);
            }

            System.out.println("The Mp3 file was successfully read and written!");
        }catch(FileNotFoundException fi)
        {
            System.out.println("The file cannot be found!");
        }catch(IOException io)
        {
            System.out.println("Something went wrong!");
        }
    }
    public static void question2AddCars()
    {
        // Q2

        List<cars> carsList = new ArrayList<>();

        Scanner readInput = new Scanner(System.in);

        while(true)
        {
            System.out.println("Would you like to add a car? enter y for yes and n for no");
            String answer = readInput.next();

            if(answer.equals("y"))
            {
                System.out.println("Please enter the registration number");
                String registrationNum = readInput.next();
                System.out.println("Please enter the make");
                String make = readInput.next();
                System.out.println("Please enter the price");
                Double price = readInput.nextDouble();
                carsList.add(new cars(registrationNum, make, price));
            }
            else
            {
                System.out.println("Bye");
                break;
            }
        }
        readList("cars.txt", carsList);
    }
    public static void readList(String textFile,List<cars> carsList)
    {
        File filePath = new File(textFile); // creating a new empty file with varible name textFile
        try
        {
            FileOutputStream out = new FileOutputStream(textFile, true); // cretae a file outputstream
            ObjectOutputStream outo = new ObjectOutputStream(out); // create a varible to call for output
            for (cars c : carsList) {outo.writeObject(c);} // for each object in the list write it to the file

            System.out.println("The file was successfully written!");
        }catch(FileNotFoundException fi)
        {
            System.out.println("The file cannot be found!");
        }catch(IOException io)
        {
            System.out.println("Something went wrong!");
        }
    }
    public static List<cars> readList() // List <cars> as we are returning a list
    {
        FileInputStream inputStream; // creating an instance of inputStream
        ObjectInputStream objectInputStream; // creating an instance of an outputStream

        File filePath = new File("cars.txt"); // pass the file we want to read from like this
        List<cars> newCarsList = new ArrayList<>();
        try {
            inputStream = new FileInputStream(filePath); // call the inputstream onto the file
            objectInputStream = new ObjectInputStream(inputStream); // we need to to read the car objects


            while (inputStream.available() > 0) // while there is data in the file add it the new list we made
            {
                cars car = (cars) objectInputStream.readObject(); //
                newCarsList.add(car); // add it to the new list
            }

            System.out.println("The file was successfully read");
        } catch (FileNotFoundException fi) {
            System.out.println("The file cannot be found!");
        } catch (IOException io) {
            System.out.println("Something went wrong!");
        } catch (ClassNotFoundException ci) {
            System.out.println("The class cant be found");
        }
        return newCarsList;
    }
    public static void main(String[] args)
    {
        question2AddCars();
        List<cars> list = readList(); // create another list of what we just got from the readList function
        for (cars c : list) {System.out.println(c);} // then loop over each object and display it
    }

}

