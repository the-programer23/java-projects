package com.fabianpinzon;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        //Regular expression filter to get directories from dir1
        DirectoryStream.Filter<Path> filter1 = p -> Files.isDirectory(p);
        Path dir1 = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir1");
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(dir1, filter1)){
            for (Path folder : contents){
                System.out.println(folder.getFileName());
            }
            System.out.println("===================");
        }catch (IOException | DirectoryIteratorException e){
            System.out.println(e.getMessage());
        }

        //Filter to get only regular files from Dir4
        DirectoryStream.Filter<Path> filter2 = new DirectoryStream.Filter<>(){
            public boolean accept(Path path) throws IOException{
                return (Files.isRegularFile(path));
            }
        };
        Path dir4 = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4");
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(dir4, filter2)){
            for (Path file : contents){
                System.out.println(file.getFileName());
            }
            System.out.println("===================");

        }catch(IOException | DirectoryIteratorException e){
            System.out.println(e.getMessage());
        }

        //get .dat files from Dir2
	    Path dir2 = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
	    try (DirectoryStream<Path> contents = Files.newDirectoryStream(dir2, "*.dat")) {
            for (Path file : contents){
                System.out.println(file.getFileName());
            }
            System.out.println("===================");

        }catch (IOException | DirectoryIteratorException e){
            System.out.println(e.getMessage());
        }

	    //Get operating system's separator
        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);
        System.out.println("===================");

        //Create temp file
        try{
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());
            System.out.println("===================");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        //Get files stores
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store: stores){
            System.out.println(store);
            System.out.println(store.name());
        }
        System.out.println("*************");

        //Get root directory
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path : rootPaths){
            System.out.println(path);
        }

        System.out.println("--- Walking tree for Dir2---");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree", File.separator, "Dir2");
        try{
            Files.walkFileTree(dir2Path, new PrintNames());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("-- Copy Dir2 to Dir4\\Dir2Copy --");
        Path copyPath = FileSystems.getDefault().getPath("FileTree", File.separator, "Dir4", File.separator, "Dir2Copy");
        try{
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        File file = new File("C:\\Examples\\file.txt");
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File("C:\\Examples");
        File resolvedFile = new File(parent, "dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("C:\\Examples", "dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("C:\\Examples");
        Path childRelativePath = Paths.get("dir\\file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working directory " + workingDirectory.getAbsolutePath());

        System.out.println("-- Print Dir2 contents using list() --");
        File dir2File = new File(workingDirectory, "\\FileTree\\Dir2");
        String[] dir2Contents = dir2File.list();
        for (int i = 0; i<dir2Contents.length; i++){
            System.out.println(dir2Contents[i]);
        }

        System.out.println("-- Print Dir2 contents using listFiles()");
        File[] dir2Files = dir2File.listFiles();
        for (int i = 0; i<dir2Files.length; i++){
            System.out.println(dir2Files[i].getName());
        }
    }
}
