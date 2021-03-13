package com.fabianpinzon;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class MoveFilesAndFolders {
    public static void main(String[] args) {
        try{
            Path fileToMove = FileSystems.getDefault().getPath("Examples", "copyFile.txt");
            Path destination = FileSystems.getDefault().getPath("Examples", "Dir1", "copyFile.txt");
            Files.move(fileToMove, destination);

        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
