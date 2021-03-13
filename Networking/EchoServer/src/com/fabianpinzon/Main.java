package com.fabianpinzon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    // the int pass to ServerSocket can be a number between 0 and 65535
    public static void main(String[] args) {
	    try(ServerSocket serverSocket = new ServerSocket(5000)){
            //infinite loop
            //the start method executes the run method
            while(true){
                new Echoer(serverSocket.accept()).start();
            }
        }catch (IOException e){
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
