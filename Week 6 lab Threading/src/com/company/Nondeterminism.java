package com.company;
import java.util.GregorianCalendar;

public class Nondeterminism
{
        static class Greeter implements Runnable
        {
            private String message;

            public Greeter(String message)
            {
                this.message = message;
            }
            public void run()
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

