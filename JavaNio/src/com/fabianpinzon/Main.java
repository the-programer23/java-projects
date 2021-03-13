package com.fabianpinzon;

import jdk.dynalink.StandardOperation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    try(FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel()){

	        //Writing to data.dat
            ByteBuffer buffer = ByteBuffer.allocate(100);

            //Short way
           /* byte[] outputBytes = "Hello world".getBytes();
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes).putInt(245).putInt(-9122).put(outputBytes2).putInt(1000);
            buffer.flip();*/


            //Long way
	        byte[] outputBytes = "Hello world".getBytes();
	        buffer.put(outputBytes);
	        long int1Pos = outputBytes.length;
	        buffer.putInt(245);
	        long int2Pos = int1Pos + Integer.BYTES;
	        buffer.putInt(-9122);
	        byte[] outputBytes2 = "Nice to meet you".getBytes();
	        buffer.put(outputBytes2);
	        long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
	        buffer.putInt(1000);
	        buffer.flip();

            binChannel.write(buffer);

	        //Reading data.dat
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);

            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int3Pos: " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int2Pos: " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int1Pos: " + readBuffer.getInt());

            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
            channel.position(0);
            //long numTransfered = copyChannel.transferFrom(channel, 0, channel.size());
            long numTransfered = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Num transfered: " + numTransfered);

            channel.close();
            ra.close();
            copyChannel.close();

            //Calculate start position
    /*        byte[] outputString = "Hello world".getBytes();
            long str1Pos = 0;                                               // |"Hello world" 245 -9122 "Nice to meet you" 1000
            long newInt1Pos = outputString.length;                          //  "Hello world"|245 -9122 "Nice to meet you" 1000
            long newInt2Pos = newInt1Pos + Integer.BYTES;                   //  "Hello world" 245|-9122 "Nice to meet you" 1000
            byte[] outputString2 = "Nice to meet you".getBytes();
            long str2Pos = newInt2Pos + Integer.BYTES;                      //  "Hello world" 245 -9122|"Nice to meet you" 1000
            long newInt3Pos = str2Pos + outputString2.length;  */             //  "Hello world" 245 -9122 "Nice to meet you"|1000

            //Writing
         /*   ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel.position(newInt1Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(-9122);
            intBuffer.flip();
            binChannel.position(newInt2Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(1000);
            intBuffer.flip();
            binChannel.position(newInt3Pos);
            binChannel.write(intBuffer);

            binChannel.position(str1Pos);
            binChannel.write(ByteBuffer.wrap(outputString));
            binChannel.position(str2Pos);
            binChannel.write(ByteBuffer.wrap(outputString2));*/

           /* ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();

            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("inputString: " + new String(inputString));
            System.out.println("int1: " + readBuffer.getInt());
            System.out.println("int2: " + readBuffer.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString2: " + new String(inputString2));
            System.out.println("int3: " + readBuffer.getInt());*/


	       /* ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);

	        buffer.put(outputBytes);

	        buffer.flip();
	        int numBytes = binChanel.write(buffer);
            System.out.println("numBytes written was " + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            numBytes = binChanel.write(intBuffer);
            System.out.println("numBytes written was " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-9875);
            intBuffer.flip();
            numBytes = binChanel.write(intBuffer);
            System.out.println("numBytes written was " + numBytes);

            //To read data.dat

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            outputBytes[0] = 'z';
            outputBytes[1] = 'h';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            if(buffer.hasArray()){
                System.out.println("byte buffer " + new String(buffer.array()));
                //System.out.println("byte buffer " + new String(outputBytes));
            }

            //Absolute read
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt(0));
            System.out.println(intBuffer.getInt());*/

            //Relative read
            /*intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());
            channel.close();
            ra.close();*/

            //System.out.println("outputBytes " + new String(outputBytes));

           /* RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");

            byte[] b = new byte[outputBytes.length];
            ra.read(b);
            System.out.println(new String(b));

            long int1 = ra.readInt();
            long int2 = ra.readInt();
            System.out.println(int1);
            System.out.println(int2);*/


	        /*Path dataPath = FileSystems.getDefault().getPath("data.txt");
            Files.write(dataPath, "\nLine 4".getBytes("UTF-8"), StandardOpenOption.APPEND);
            List<String> lines = Files.readAllLines(dataPath);
            for(String line : lines){
                System.out.println(line);
            }*/
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
