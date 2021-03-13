package com.company;

public class Main {

    public static void main(String[] args) {
        int score = 7;
        int bonus = 50;

	    int finalScore = calculation( score , bonus);
        System.out.println("Your final score is: " + finalScore);

        int highScorePosition = calculateHighScorePosition(1500);
        displayHighScorePosition("Fabian", highScorePosition);
        highScorePosition = calculateHighScorePosition(900);
        displayHighScorePosition("Fabian", highScorePosition);
        highScorePosition = calculateHighScorePosition(400);
        displayHighScorePosition("Fabian", highScorePosition);
        highScorePosition = calculateHighScorePosition(50);
        displayHighScorePosition("Fabian", highScorePosition);

        highScorePosition = calculateHighScorePosition(1000);
        displayHighScorePosition("Bob", highScorePosition);

    }

    //void means don't send any value back
    // public static int means the method returns an integer
    public static int calculation (int score, int bonus) {


        if(score == 7) {
            score += 1000;
            System.out.println("Your score is " + score);
            return score;
        }

        return -1;
    }

    public static void displayHighScorePosition (String playerName, int scorePosition ){
        System.out.println(playerName + " managed to get into position " + scorePosition + " on the high score table");
    }

    public static int calculateHighScorePosition (int playerScore) {
        if(playerScore >= 1000){
            return 1;
        }

        if(playerScore >= 500 ){
            return 2;
        }

        if(playerScore >= 100 ){
            return 3;
        }
        return 4;
    }
}
