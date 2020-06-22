package com.twschool.practice.Service;

import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.repository.GameRepository;

public class GameService {

    private GameRepository gameRepository;


    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public String guess(String userAnswerString){
        GuessNumberGame guessNumberGame = gameRepository.find();
        return guessNumberGame.guess(userAnswerString);
    }
}
