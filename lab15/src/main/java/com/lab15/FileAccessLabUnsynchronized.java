package com.lab15;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAccessLabUnsynchronized {
    private static final String FILE_NAME = "shared_file_unsync.txt";
    
    public static void main(String[] args) throws InterruptedException {
        // Clear the file first
        clearFile(FILE_NAME);
        
        System.out.println("=== DEMONSTRATING RACE CONDITIONS (NO SYNCHRONIZATION) ===");
        System.out.println("Multiple threads will write to the same file without synchronization");
        System.out.println("This may cause interleaved writes and data corruption!\n");
        
        FileAccessLabUnsynchronized fileAccessLab = new FileAccessLabUnsynchronized();
        
        // Create MORE worker threads to increase chance of race conditions
        Thread[] threads = new Thread[8];
        for (int i = 0; i < 8; i++) {
            final int threadNum = i + 1;
            threads[i] = new Thread(new UnsafeWorkerThread(FILE_NAME, 
                "Thread-" + threadNum + " message"), "Worker-" + threadNum);
        }
        
        // Start all threads simultaneously
        for (Thread t : threads) {
            t.start();
        }
        
        // Wait for all threads to complete
        for (Thread t : threads) {
            t.join();
        }
        
        System.out.println("\n=== Check " + FILE_NAME + " to see if there are any corrupted lines ===");
        System.out.println("You might see incomplete lines or mixed content from different threads!");
    }
    
    private static void clearFile(String fileName) {
        try {
            new File(fileName).delete();
        } catch (Exception e) {
            // Ignore
        }
    }
}

class UnsafeWorkerThread implements Runnable {
    private final String fileName;
    private final String message;
    
    public UnsafeWorkerThread(String fileName, String message) {
        this.fileName = fileName;
        this.message = message;
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started writing");
        
        // Write multiple times to increase chance of race conditions
        for (int i = 0; i < 15; i++) {
            writeToFile(message + " - Write #" + (i + 1));
            
            // Smaller delay to increase contention
            try {
                Thread.sleep(2); // Reduced from 10ms to 2ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        
        System.out.println(Thread.currentThread().getName() + " finished writing");
    }
    
    // NO SYNCHRONIZATION - This can cause race conditions!
    private void writeToFile(String message) {
        try {
            // Break the write operation into multiple separate file operations
            // This dramatically increases the chance of race conditions
            
            // First operation - write thread name
            FileWriter fw1 = new FileWriter(fileName, true);
            fw1.write("[" + Thread.currentThread().getName() + "] ");
            fw1.flush(); // Force immediate write
            Thread.sleep(5); // Give other threads chance to interfere
            fw1.close();
            
            // Second operation - write message (separate file open/close)
            FileWriter fw2 = new FileWriter(fileName, true);
            Thread.sleep(3); // More interference opportunity
            fw2.write(message);
            fw2.flush();
            Thread.sleep(2);
            fw2.close();
            
            // Third operation - write newline (another separate operation)
            FileWriter fw3 = new FileWriter(fileName, true);
            Thread.sleep(1);
            fw3.write(System.lineSeparator());
            fw3.flush();
            fw3.close();
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}