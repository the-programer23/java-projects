package com.company;

public class Main {

    public static void main(String[] args) {
	/*   int playerFinalScore =  highScore("Fabian", 100);
        System.out.println(playerFinalScore);
        highScore(10005);
        highScore();*/
     /*   System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(3945L));*/
        System.out.println(area(5.0));
        System.out.println(area(-1));
        System.out.println(area(5.0, 4.0));
    }

    public static int highScore(String playerName, int score) {
        System.out.println(playerName + " has a score of " + score);
        return score * 100;
    }

    public static int highScore(int score) {
        System.out.println("Unnamed player " + " has a score of " + score);
        return score * 100;
    }

    public static int highScore() {
        System.out.println("No player, no score");
        return 0;
    }

    private static String getDurationString(long minutes, long seconds) {
        if ((minutes < 0) || (seconds < 0) || (seconds > 59)) {
            return "Invalid Value";
        }

        long hours = minutes / 60;
        long remainingMinutes = minutes % 60;
        return hours + "h " + remainingMinutes + "m " + seconds + "s";
    }

    private static String getDurationString(long seconds){
        if(seconds < 0){
            return "Invalid Value";
        }

        long minutes = seconds / 60;
        long remainingSeconds = seconds % 60;

        return  getDurationString(minutes, remainingSeconds);
    }

    public static double area(double radius){
        if(radius < 0){
            return -1.0;
        }
        return radius * radius  * Math.PI;

    }

    public static double area(double x, double y){
        if(x < 0 || y < 0){
            return -1.0;
        }
        return  x * y;


    }


}
