package com.company;
import java.util.GregorianCalendar;

public class Nondeterminism
{
    // we need to do extends thread to make multiple threads in Java. Creating multiple threads allows you to
    // run multiple paths of code at the same time.
        static class Greeter extends Thread
        {
            private String message;

            public Greeter(String message)
            {
                this.message = message;
            }
            public void run() // we are overriding the greeter classes run function and now all the code we want to run in multiple threads here
            {
                for (int i = 0; i < 10; i++)
                {
                    System.out.println(message);
                    //yield();  // Uncomment yield() to see whether it has an effect
                }
            }
        }
        public static void main(String[] args) throws Exception
        {
            Greeter g1 = new Greeter("Hello");
            Thread t1 = new Thread(g1);
            Greeter g2 = new Greeter("Goodbye");
            Thread t2 = new Thread(g2);

            t1.start();
            t2.start();
        }
    }

