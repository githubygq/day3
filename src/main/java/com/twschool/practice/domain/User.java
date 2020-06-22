package com.twschool.practice.domain;

public class User {
    private String id;
    private GuessNumberGame guessNumberGame;
    private int winInARowCount;
    private int score;

    public User(String id, GuessNumberGame guessNumberGame, int winInARowCount,int score) {
        this.id = id;
        this.guessNumberGame = guessNumberGame;
        this.winInARowCount = winInARowCount;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GuessNumberGame getGuessNumberGame() {
        return guessNumberGame;
    }

    public void setGuessNumberGame(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }

    public int getWinInARowCount() {
        return winInARowCount;
    }

    public void setWinInARowCount(int winInARowCount) {
        this.winInARowCount = winInARowCount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void addwinInARowCount() {
        this.winInARowCount++;
    }
}
