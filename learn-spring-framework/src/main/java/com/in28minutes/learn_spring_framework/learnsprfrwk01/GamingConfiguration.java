package com.in28minutes.learn_spring_framework.learnsprfrwk01;

import com.in28minutes.learn_spring_framework.learnsprfrwk01.game.GameRunner;
import com.in28minutes.learn_spring_framework.learnsprfrwk01.game.GamingConsole;
import com.in28minutes.learn_spring_framework.learnsprfrwk01.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        return new PacmanGame();
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }
}
