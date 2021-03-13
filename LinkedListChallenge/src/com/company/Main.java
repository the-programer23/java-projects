package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
	    Album album = new Album("Issues", "KoRn");
	    album.addSong("Trash", 4.5);
	    album.addSong("Falling Away From Me", 5.5);
	    album.addSong("Blind", 6.5);
	    album.addSong("Shoots and Ladders", 6.5);
	    album.addSong("Clown", 3.1);
	    album.addSong("Master of Puppets", 4.5);
	    album.addSong("Umbrella", 4.5);
	    album.addSong("Here to Stay", 4.5);
	    albums.add(album);

	    album = new Album("Yellow Submarine", "The Beatles");
	    album.addSong("Lucy in the sky with diamonds", 4.3);
	    album.addSong("Leave and Let Die", 5.3);
	    album.addSong("I put the finger on you", 6.4);
	    album.addSong("Flying Butterflies", 3.4);
	    album.addSong("Crazy Doggy", 3.9);
	    albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Trash", playList);
        System.out.println(playList);
        albums.get(0).addToPlayList("Blind", playList);
        albums.get(0).addToPlayList("Cold day", playList); // this song does not exist
        albums.get(0).addToPlayList(8, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(23, playList);// this trackNumber does not exist

        play(playList);
    }

    private static void play( LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size() == 0){
            System.out.println("No songs in the playlist");
            return;
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward= true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous());
                            forward = false;
                        }else {
                            System.out.println("We are at the start of the list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next());
                            forward = true;
                        }else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size() > 0){
                        listIterator.remove();
                    }
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - To quit\n" +
                "1 - To play next song\n" +
                "2 - To play previous song\n" +
                "3 - To replay the current song\n" +
                "4 - To list songs in the playlist\n" +
                "5 - Print available actions\n" +
                "6 - Delete current song from the playlist");
    }

    private static void printList(LinkedList<Song> playList){
        //Iterator is perfect to loping through an LinkedList just once
        Iterator<Song> iterator = playList.iterator();
        System.out.println("========================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("========================");
    }

}
