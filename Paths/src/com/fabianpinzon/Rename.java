package com.fabianpinzon;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Rename {
    public static void main(String[] args) {
        try{
            Path fileToRename = FileSystems.getDefault().getPath("Examples", "file1.txt");
            Path destination = FileSystems.getDefault().getPath("Examples", "file2.txt");
            Files.move(fileToRename, destination);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
