package com.lab15;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAccessLabSynchronized2 {
    private static final String FILE_NAME = "shared_file_sync.txt";
    private static final Object FILE_LOCK = new Object(); // Shared lock object
    
    public static void main(String[] args) throws InterruptedException {
        // Clear the file first
        clearFile(FILE_NAME);
        
        System.out.println("=== DEMONSTRATING SYNCHRONIZED FILE ACCESS ===");
        System.out.println("Multiple threads will write to the same file WITH synchronization");
        System.out.println("All writes should be complete and properly ordered!\n");
        
        FileAccessLabSynchronized fileAccessLab = new FileAccessLabSynchronized();
        
        // Create the same number of threads as the unsafe version
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            final int threadNum = i + 1;
            threads[i] = new Thread(new SafeWorkerThread(FILE_NAME, FILE_LOCK,
                "Thread-" + threadNum + " message"), "Worker-" + threadNum);
        }
        
        // Start all threads simultaneously
        long startTime = System.currentTimeMillis();
        for (Thread t : threads) {
            t.start();
        }
        
        // Wait for all threads to complete
        for (Thread t : threads) {
            t.join();
        }
        long endTime = System.currentTimeMillis();
        
        System.out.println("\n=== All threads completed successfully! ===");
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
        System.out.println("Check " + FILE_NAME + " - all lines should be complete and properly formatted!");
    }
    
    private static void clearFile(String fileName) {
        try {
            new File(fileName).delete();
        } catch (Exception e) {
            // Ignore
        }
    }
}

class SafeWorkerThread implements Runnable {
    private final String fileName;
    private final String message;
    private final Object fileLock; // Shared lock for file access
    
    public SafeWorkerThread(String fileName, Object fileLock, String message) {
        this.fileName = fileName;
        this.fileLock = fileLock;
        this.message = message;
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started writing");
        
        // Write multiple times, same as unsafe version
        for (int i = 0; i < 10; i++) {
            writeToFile(message + " - Write #" + (i + 1));
            
            // Small delay to simulate processing time
            try {
                Thread.sleep(10); // 10ms delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        
        System.out.println(Thread.currentThread().getName() + " finished writing");
    }
    
    // SYNCHRONIZED method - prevents race conditions!
    private void writeToFile(String message) {
        // Synchronize on the shared lock object
        synchronized (fileLock) {
            System.out.println("  → " + Thread.currentThread().getName() + " acquired file lock");
            
            try {
                FileWriter fileWriter = new FileWriter(fileName, true);
                BufferedWriter writer = new BufferedWriter(fileWriter);
                
                // Even with delays, synchronization ensures atomic write operations
                Thread.sleep(1);
                
                writer.write("[" + Thread.currentThread().getName() + "] ");
                
                Thread.sleep(1);
                
                writer.write(message);
                writer.newLine();
                
                writer.close();
                fileWriter.close();
                
                System.out.println("  ✓ " + Thread.currentThread().getName() + " completed write");
                
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("  ← " + Thread.currentThread().getName() + " released file lock");
            }
        } // Lock is automatically released here
    }
}