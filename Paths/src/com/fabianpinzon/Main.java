package com.fabianpinzon;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
         Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
         printFile(path);
         //Path filePath = FileSystems.getDefault().getPath("files", "SubdirectoryFile.txt");
           Path filePath = Paths.get(".", "files", "SubdirectoryFile.txt");
         printFile(filePath);

         filePath = Paths.get("C:\\Users\\FabianCreadorApps\\googleDrive\\Projects\\Java\\OutThere.txt");
         printFile(filePath);

         filePath = Paths.get(".");
         System.out.println(filePath.toAbsolutePath());

         //D:\Examples\.\subfolfer\..\directory == D:\Examples\directory. .. means go up one level
         Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubdirectoryFile.txt");
        System.out.println("path2: " + path2.normalize().toAbsolutePath());
        printFile(path2);

        Path path3 = FileSystems.getDefault().getPath("thisfiledoesnttexists.txt");
        System.out.println(path3.toAbsolutePath());

        Path path4 = Paths.get("C:\\Users\\FabianCreadorApps", "\\fakeFolder", "fakeFile.txt");
        System.out.println(path4.toAbsolutePath());

        filePath = FileSystems.getDefault().getPath("files");
        System.out.println("Exits = " + Files.exists(filePath));

        System.out.println("Exits = " + Files.exists(path4));
    }

    private static void printFile(Path path){
        try(BufferedReader fileReader = Files.newBufferedReader(path)){
            String line;
            while((line = fileReader.readLine()) != null){
                System.out.println(line);
            }

        } catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
