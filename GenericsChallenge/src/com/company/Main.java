package com.company;

public class Main {

    public static void main(String[] args) {
	    League<SoccerPlayer, Team<SoccerPlayer>> soccerLeague = new League<>("UEFA");
        Team<SoccerPlayer> realMadrid = new Team<>("Real Madrid");
        Team<SoccerPlayer> bayerMunich = new Team<>("Bayer Munich");
        Team<SoccerPlayer> parisSaintGermain = new Team<>("Paris Saint Germain");
        Team<SoccerPlayer> liverpool = new Team<>("Liverpool");
        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago cubs");

        realMadrid.matchResult(bayerMunich, 5, 3);
        parisSaintGermain.matchResult(liverpool, 6, 3);
        bayerMunich.matchResult(liverpool, 3, 2);
        realMadrid.matchResult(parisSaintGermain, 4 , 2);

        soccerLeague.add(realMadrid);
        soccerLeague.add(bayerMunich);
        soccerLeague.add(parisSaintGermain);
        soccerLeague.add(liverpool);

        //soccerLeague.add(baseballTeam)

        soccerLeague.showLeagueTable();

        BaseballPlayer ruth = new BaseballPlayer("Babe Ruth");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team rawTeam = new Team("Raw team");
        rawTeam.addPlayer(beckham); //unchecked warning
        rawTeam.addPlayer(ruth); //unchecked warning

        soccerLeague.add(rawTeam); //unchecked warning

        League<SoccerPlayer, Team<SoccerPlayer>> rawLeague = new League<>("Raw League");
        rawLeague.add(rawTeam);// no warning
        rawLeague.add(realMadrid);// no warning
        rawLeague.add(baseballTeam);

        League reallyRawLeague = new League("Really Raw League");
        reallyRawLeague.add(rawTeam);//unchecked warning
        reallyRawLeague.add(realMadrid);//unchecked warning
    }
}
