package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration){
        return this.songs.add(new Song(title, duration));
    };


    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        Song checkedSong = this.songs.findSong(trackNumber);
        if(checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("This album doesn't have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        Song checkedSong = this.songs.findSong(title);
        if(checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public boolean add(Song song){
            if(this.songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }

        public Song findSong(String title){
            for(Song checkedSong: this.songs){
                if(checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        }

        public Song findSong(int trackNumber){
            int index = trackNumber - 1;
            if(index >= 0 && index < this.songs.size()){
                return this.songs.get(index);
            }
            return null;
        }

    }
}

