package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BaseballPlayer ruth = new BaseballPlayer("Babe Ruth");
        FootballPlayer clark = new FootballPlayer("Clark Kent");
        SoccerPlayer ronaldo = new SoccerPlayer("Ronaldo");






        Team<BaseballPlayer> boston_red_sox = new Team<>("Boston Red Sox");
        boston_red_sox.addPlayer(ruth);
        Team<BaseballPlayer> melbourne = new Team<>("Melbourne");
        BaseballPlayer banks = new BaseballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<SoccerPlayer> brazil = new Team<>("Brazil");
        brazil.addPlayer(ronaldo);
        Team<SoccerPlayer> argentina = new Team<>("Argentina");
        Team<SoccerPlayer> colombia = new Team<>("Colombia");


        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");
        Team<FootballPlayer> baltimore_ravens = new Team<>("Baltimore Ravens");
        baltimore_ravens.addPlayer(clark);
        System.out.println(baltimore_ravens.numPlayers());

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(baltimore_ravens, 3, 8);
        baltimore_ravens.matchResult(fremantle, 4, 2);

        brazil.matchResult(argentina, 5, 4);
        argentina.matchResult(colombia, 5, 5);

        boston_red_sox.matchResult(melbourne, 5, 4);


        System.out.println("Rankings");
        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());
        System.out.println(baltimore_ravens.getName() + ": " + baltimore_ravens.ranking());
        System.out.println(boston_red_sox.getName() + ": " + boston_red_sox.ranking());
        System.out.println(brazil.getName() + ": " + brazil.ranking());
        System.out.println(fremantle.getName() + ": " + fremantle.ranking());


        System.out.println(brazil.compareTo(argentina));
        System.out.println(hawthorn.compareTo(fremantle));

    }

}
