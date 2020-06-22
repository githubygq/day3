package com.twschool.practice.api;

import com.twschool.practice.Service.GameService;
import com.twschool.practice.Service.UserService;
import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    int i = 0;


    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    /*@PostMapping("/games/guess-numbers")
    public Map<String,String> guess(@RequestBody Map<String,String> requestBody){
        Map<String,String> responseBody = new HashMap<>();
        responseBody.put("input",requestBody.get("number"));
        responseBody.put("result",gameService.guess(requestBody.get("number")));

        return responseBody;
    }*/

    @PostMapping("/games/guess-numbers")
    public Map<String,String> guess(@RequestBody Map<String,String> requestBody){
        String userId = requestBody.get("userId");
        String guessNo = requestBody.get("guessNo");
        if(StringUtils.isEmpty(userId)||StringUtils.isEmpty(guessNo)){
            return null;
        }
        User user = userService.getUserInfoById(userId);
        if (user == null) {
            GuessNumberGame guessNumberGame = new GuessNumberGame(new AnswerGenerator());

            //System.out.println(guessNumberGame.getGameAnswer().getAnswerNumbers().toString());

            user = new User(userId, guessNumberGame, 0, 0);
            userService.setUserInfo(userId, user);
        }

        //胜利或失败后的用户可继续玩，重置该用户GuessNumberGame
        if (user.getGuessNumberGame().getStatus() != GameStatus.CONTINUED) {
            user.setGuessNumberGame(new GuessNumberGame(new AnswerGenerator()));
        }
        gameService.setUser(user);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("input", guessNo);
        responseBody.put("output", gameService.guess(guessNo));
        responseBody.put("score", gameService.countScore() + "");
        return responseBody;
    }

    @PostMapping("/games/test")
    public Map<String,String> guess1(@RequestBody Map<String,String> requestBody){
        i++;
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("score", i+"");
        return responseBody;
    }
}
