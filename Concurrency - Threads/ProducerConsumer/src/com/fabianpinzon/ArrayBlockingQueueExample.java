package com.fabianpinzon;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.fabianpinzon.ArrayBlockingQueueExample.EOF;

public class ArrayBlockingQueueExample {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer2 producer = new MyProducer2(buffer, ThreadColor.ANSI_BLUE);
        MyConsumer2 consumer1 = new MyConsumer2(buffer, ThreadColor.ANSI_CYAN);
        MyConsumer2 consumer2 = new MyConsumer2(buffer, ThreadColor.ANSI_GREEN);

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

    }

}

class MyProducer2 implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer2(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        System.out.println("run() Producer");
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for(String num : nums){
            System.out.println(num);
            try{
                System.out.println(color + "Adding... " + num);
                buffer.put(num);
                Thread.sleep(random.nextInt(1000));
            }catch (InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        try{
            buffer.put("EOF");
        }catch (InterruptedException e){

        }
    }
}


class MyConsumer2 implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer2(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run(){
        System.out.println("run() from MyConsumer");
        while(true){
            synchronized(buffer){
                try{
                    if (buffer.isEmpty()){
                        continue;
                    }
                    System.out.println("buffer.peek(): " + buffer.peek());
                    if(buffer.peek().equals(EOF)){
                        System.out.println(color + "Exiting");
                        break;
                    }else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                }catch (InterruptedException e){
                }
            }
        }
    }
}
