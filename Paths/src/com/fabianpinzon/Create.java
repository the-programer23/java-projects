package com.fabianpinzon;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Create {
    public static void main(String[] args) {
        try{
            //Create one file
            /*Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
            Files.createFile(fileToCreate);*/

            //Create one directory
            /*Path folderToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
            Files.createDirectory(folderToCreate);*/

            /*Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
            Files.createDirectories(dirToCreate);*/

            Path dirToCreate = FileSystems.getDefault().getPath("Examples\\Dir2\\Dir3\\Dir4\\Dir5\\Dir6\\Dir7");
            Files.createDirectories(dirToCreate);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
