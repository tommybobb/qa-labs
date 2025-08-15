package com.lab15;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demonstrates asynchronous resource access with UI feedback
 * Shows how to keep UI responsive while waiting for resources
 */
public class AsyncResourceDemo {
    
    // Simulated UI callback interface
    public interface UICallback {
        void updateStatus(String message);
        void showResult(String result);
        void showError(String error);
    }
    
    // Shared resource with lock
    private static final ReentrantLock fileLock = new ReentrantLock();
    private static final String FILE_NAME = "async_demo.txt";
    
    // Thread pool for background tasks
    private static final ExecutorService executorService = 
        Executors.newFixedThreadPool(4);
    
    public static void main(String[] args) throws InterruptedException {
        // Simulate UI interactions
        MockUI ui = new MockUI();
        
        System.out.println("=== ASYNCHRONOUS RESOURCE ACCESS DEMO ===");
        System.out.println("Simulating multiple UI requests with resource contention\n");
        
        // Simulate multiple concurrent UI requests
        for (int i = 1; i <= 5; i++) {
            final int requestId = i;
            
            // Simulate user clicking button after small delays
            Thread.sleep(200);
            System.out.println("🖱️  User " + requestId + " clicked 'Write File' button");
            
            // Handle request asynchronously
            handleAsyncFileWrite(
                "User-" + requestId + " data", 
                requestId,
                ui
            );
        }
        
        // Let all operations complete
        Thread.sleep(5000);
        executorService.shutdown();
        
        System.out.println("\n=== Demo Complete ===");
    }
    
    /**
     * Method 1: Using CompletableFuture (Modern Java approach)
     */
    public static void handleAsyncFileWrite(String data, int requestId, UICallback ui) {
        // Immediately show "waiting" status to user
        ui.updateStatus("⏳ Request " + requestId + ": Waiting for file resource...");
        
        CompletableFuture
            .supplyAsync(() -> {
                // Background thread: Try to get the lock
                try {
                    if (fileLock.tryLock(2, TimeUnit.SECONDS)) {
                        try {
                            // Simulate some work while holding the lock
                            Thread.sleep(800);
                            
                            // Write to file
                            FileWriter fw = new FileWriter(FILE_NAME, true);
                            fw.write("[Request-" + requestId + "] " + data + "\n");
                            fw.close();
                            
                            return "✅ Successfully wrote: " + data;
                            
                        } finally {
                            fileLock.unlock();
                        }
                    } else {
                        return "⏰ Timeout: Resource was busy for too long";
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return "🔄 Operation was interrupted";
                } catch (IOException e) {
                    return "❌ File error: " + e.getMessage();
                }
            }, executorService)
            .thenAccept(result -> {
                // Back to UI thread: Show final result
                ui.showResult("Request " + requestId + ": " + result);
            })
            .exceptionally(throwable -> {
                // Handle any unexpected errors
                ui.showError("Request " + requestId + ": Unexpected error - " + throwable.getMessage());
                return null;
            });
    }
    
    /**
     * Method 2: Using traditional ExecutorService with callbacks
     */
    public static void handleAsyncFileWriteTraditional(String data, int requestId, UICallback ui) {
        ui.updateStatus("⏳ Request " + requestId + ": Queued for processing...");
        
        executorService.submit(() -> {
            try {
                ui.updateStatus("🔄 Request " + requestId + ": Attempting to acquire resource...");
                
                if (fileLock.tryLock(3, TimeUnit.SECONDS)) {
                    try {
                        ui.updateStatus("🔒 Request " + requestId + ": Resource acquired, processing...");
                        
                        // Simulate work
                        Thread.sleep(500);
                        
                        FileWriter fw = new FileWriter(FILE_NAME, true);
                        fw.write("[Traditional-" + requestId + "] " + data + "\n");
                        fw.close();
                        
                        ui.showResult("Request " + requestId + ": ✅ Processing complete!");
                        
                    } finally {
                        fileLock.unlock();
                        ui.updateStatus("🔓 Request " + requestId + ": Resource released");
                    }
                } else {
                    ui.showError("Request " + requestId + ": ⏰ Timeout waiting for resource");
                }
                
            } catch (Exception e) {
                ui.showError("Request " + requestId + ": ❌ " + e.getMessage());
            }
        });
    }
    
    /**
     * Method 3: Queue-based approach with status updates
     */
    private static final BlockingQueue<QueuedRequest> requestQueue = new LinkedBlockingQueue<>();
    private static volatile boolean processorRunning = false;
    
    public static class QueuedRequest {
        final String data;
        final int requestId;
        final UICallback ui;
        final long timestamp;
        
        QueuedRequest(String data, int requestId, UICallback ui) {
            this.data = data;
            this.requestId = requestId;
            this.ui = ui;
            this.timestamp = System.currentTimeMillis();
        }
    }
    
    public static void handleAsyncFileWriteQueued(String data, int requestId, UICallback ui) {
        // Add to queue immediately
        QueuedRequest request = new QueuedRequest(data, requestId, ui);
        requestQueue.offer(request);
        
        ui.updateStatus("📝 Request " + requestId + ": Added to queue (position: " + 
                       requestQueue.size() + ")");
        
        // Start processor if not running
        startQueueProcessor();
    }
    
    private static synchronized void startQueueProcessor() {
        if (!processorRunning) {
            processorRunning = true;
            executorService.submit(() -> {
                while (!requestQueue.isEmpty() || processorRunning) {
                    try {
                        QueuedRequest request = requestQueue.poll(1, TimeUnit.SECONDS);
                        if (request != null) {
                            processQueuedRequest(request);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
                processorRunning = false;
            });
        }
    }
    
    private static void processQueuedRequest(QueuedRequest request) {
        try {
            long waitTime = System.currentTimeMillis() - request.timestamp;
            request.ui.updateStatus("🔄 Request " + request.requestId + 
                                   ": Processing (waited " + waitTime + "ms)");
            
            fileLock.lock(); // Blocking wait for demonstration
            try {
                Thread.sleep(300); // Simulate work
                
                FileWriter fw = new FileWriter(FILE_NAME, true);
                fw.write("[Queued-" + request.requestId + "] " + request.data + "\n");
                fw.close();
                
                request.ui.showResult("Request " + request.requestId + ": ✅ Completed from queue!");
                
            } finally {
                fileLock.unlock();
            }
            
        } catch (Exception e) {
            request.ui.showError("Request " + request.requestId + ": ❌ " + e.getMessage());
        }
    }
}

/**
 * Mock UI class to simulate user interface updates
 */
class MockUI implements AsyncResourceDemo.UICallback {
    @Override
    public void updateStatus(String message) {
        System.out.println("📱 UI Status: " + message);
    }
    
    @Override
    public void showResult(String result) {
        System.out.println("📱 UI Result: " + result);
    }
    
    @Override
    public void showError(String error) {
        System.out.println("📱 UI Error: " + error);
    }
}