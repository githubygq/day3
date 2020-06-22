package com.twschool.practice.api;

import com.twschool.practice.Service.GameService;
import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GuessNumberGame;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {

    @PostMapping("/games/guess-numbers")
    public Map<String,String> guess(@RequestBody Map<String,String> requestBody){
        Map<String,String> responseBody = new HashMap<>();

        GameService gameService = new GameService(new GuessNumberGame(new AnswerGenerator()));
        responseBody.put("input",requestBody.get("number"));
        responseBody.put("result",gameService.guess(requestBody.get("number")));

        return responseBody;
    }
}
