package com.twschool.practice.Service;

import com.twschool.practice.domain.GameAnswer;
import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.User;
import com.twschool.practice.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GameService {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String guess(String userAnswerString){
        /*GuessNumberGame guessNumberGame = user.getGuessNumberGame();
        System.out.println(guessNumberGame);
        return guessNumberGame.guess(userAnswerString);*/
        if(userAnswerString==null){
            return "输入答案不能为空";
        }
        List<String> userAnswerNumbers = Arrays.asList(userAnswerString.split(" "));
        GameAnswer userAnswer = new GameAnswer(userAnswerString);
        if (!userAnswer.isValidFormat()) {
            return "Wrong Input，Input again";
        }
        if(user.getGuessNumberGame()==null){
            throw new RuntimeException("游戏设置不能为空");
        }
        return user.getGuessNumberGame().guess(userAnswerString);
    }

    public int countScore(){
        GameStatus status=user.getGuessNumberGame().getStatus();
        if (GameStatus.SUCCEED==status) {
            user.addwinInARowCount();
            System.out.println(user.getWinInARowCount());
            user.addScore(3);
            System.out.println(user.getScore());
            if (0 == user.getWinInARowCount() % 3) {
                user.addScore(2);
            }
            if (0 == user.getWinInARowCount() % 5) {
                user.addScore(3);
            }
        }
        if (GameStatus.FAILED==status) {
            user.setWinInARowCount(0);
            user.addScore(-3);
        }
        return user.getScore();
    }

}
