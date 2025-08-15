package com.lab15;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAccessLabSynchronized
{
    private static final String FILE_NAME = "shared_file.txt";

    public static void main(String[] args)
    {
        FileAccessLabSynchronized fileAccessLab = new FileAccessLabSynchronized();

        // Create worker threads
        Thread t1 = new Thread(new WorkerThread(FILE_NAME, "Thread 1's message"));
        Thread t2 = new Thread(new WorkerThread(FILE_NAME, "Thread 2's message"));
        Thread t3 = new Thread(new WorkerThread(FILE_NAME, "Thread 3's message"));

        // Start worker threads
        t1.start();
        t2.start();
        t3.start();
    }
}

class WorkerThread implements Runnable
{
    private final String fileName;
    private final String message;

    // Constructor to initialize the file name and the message
    public WorkerThread(String fileName, String message)
    {
        this.fileName = fileName;
        this.message = message;
    }

    @Override
    public void run()
    {
        // Simulate work before writing to the file
        System.out.println(Thread.currentThread().getName() + " is writing!");
        writeToFile(message);
    }

    // Synchronized method to ensure thread-safe file writing
    private synchronized void writeToFile(String message)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, 
                                                                           true))) {
            writer.write(message);
            writer.newLine();
            System.out.println(Thread.currentThread().getName() + " is writing");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
