package com.sriashi.fundamentals;

public class TestGameEntry {

    public static void main(String[] args) {
        Scoreboard scoreBoard = new Scoreboard(5);
        scoreBoard.add(new GameEntry("Ashimita", 49));
        scoreBoard.add(new GameEntry("Sri", 80));
        scoreBoard.add(new GameEntry("Riju", 100));
        scoreBoard.add(new GameEntry("Maya", 60));
        scoreBoard.add(new GameEntry("Dilip", 79));
        scoreBoard.add(new GameEntry("Sag", 120));
        scoreBoard.add(new GameEntry("Sag", 65));

        System.out.println(scoreBoard.toString());

        // scoreBoard.remove(2);
    }

}
