package com.twschool.practice.Service;

import com.twschool.practice.domain.GuessNumberGame;

public class GameService {
    private GuessNumberGame guessNumberGame;

    public GameService(GuessNumberGame guessNumberGame){
        this.guessNumberGame = guessNumberGame;
    }

    public String guess(String userAnswerString){
        return guessNumberGame.guess(userAnswerString);
    }
}
