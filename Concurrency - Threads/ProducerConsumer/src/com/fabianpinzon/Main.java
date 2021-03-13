package com.fabianpinzon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.fabianpinzon.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
	 List<String> buffer = new ArrayList<>();
	 ReentrantLock bufferLock = new ReentrantLock();

	 ExecutorService executorService = Executors.newFixedThreadPool(5);

	 MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_BLUE, bufferLock);
	 MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);
	 MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN, bufferLock);

	 executorService.execute(producer);
	 executorService.execute(consumer1);
	 executorService.execute(consumer2);

	 Future<String> future = executorService.submit(new Callable<String>() {
         @Override
         public String call() throws Exception {
             System.out.println(ThreadColor.ANSI_RED + "I'm being printed from the callable class");
             return "This is the callable result";
         }
     });

	 try{
         System.out.println(future.get());
     }catch (ExecutionException e){
         System.out.println("Something went wrong");
     }catch (InterruptedException e){
         System.out.println("Thread running the task was interrupted");
     }

	 executorService.shutdown();

	 /*new Thread(producer).start();
	 new Thread(consumer1).start();
	 new Thread(consumer2).start();*/
    }
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        System.out.println("run() Producer");
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for(String num : nums){
            System.out.println(num);
            try{
                System.out.println(color + "Adding... " + num);
                //synchronized was added to adding to the buffer because ArrayList is not thread safe
               /* synchronized(buffer){
                    buffer.add(num);
                }*/
                bufferLock.lock();
                try{
                    buffer.add(num);
                }finally{
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            }catch (InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        /*synchronized(buffer){
            buffer.add("EOF");
        }*/
        bufferLock.lock();
        try{
            buffer.add("EOF");
        }finally{
            bufferLock.unlock();
        }
    }
}


class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run(){
        System.out.println("run() from MyConsumer");
        int counter = 0;
        while(true){
            if(bufferLock.tryLock()){
                try{
                    if (buffer.isEmpty()){
                        continue;
                    }
                    System.out.println(color + "The counter = " + counter);
                    counter = 0;
                    if(buffer.get(0).equals(EOF)){
                        System.out.println(color + "Exiting");
                        break;
                    }else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                }finally{
                    bufferLock.unlock();
                }
            }else {
                counter++;
            }

        }
    }
}