package com.fabianpinzon;

import com.fabianpinzon.model.Artist;
import com.fabianpinzon.model.Datasource;
import com.fabianpinzon.model.SongArtist;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if (!datasource.open()){
            System.out.println("Can't open data source");
            return;
        }

        List<Artist> artists = datasource.queryArtists(5);
        if (artists == null){
            System.out.println("No artists found");
            return;
        }

        for (Artist artist : artists){
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        List<String> albumsForArtist = datasource.queryAlbumsForArtist("Pink Floyd", Datasource.ORDER_BY_DESC);
        for (String album : albumsForArtist){
            System.out.println(album);
        }

        List<SongArtist> songArtists = datasource.queryArtistsForSong("Heartless", Datasource.ORDER_BY_DESC);
        if(songArtists == null){
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for (SongArtist artist : songArtists){
            System.out.println("Artist name: " + artist.getArtistName() + " Album name: " + artist.getArtistName() +
                    " Track: " + artist.getTrack());
        }

        datasource.querySongsMetadata();

        int count = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("The number of songs is " + count);

        datasource.createViewForSongArtist();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: ");
        String title = scanner.nextLine();
        songArtists = datasource.querySongInfoView(title);

        if (songArtists.isEmpty()){
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for (SongArtist songArtist : songArtists){
            System.out.println("Band: " + songArtist.getArtistName() + " Album: " + songArtist.getAlbumName() +
                " Track: " + songArtist.getTrack());
        }

        datasource.insertSong("Clown", "Korn", "Korn", 2);

        datasource.close();
    }
}
