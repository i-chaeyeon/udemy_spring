package com.in28minutes.learn_spring_framework.learnsprfrwk02;

import com.in28minutes.learn_spring_framework.learnsprfrwk02.game.GameRunner;
import com.in28minutes.learn_spring_framework.learnsprfrwk02.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class App03GamingSpringBeans {

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        System.out.println("Parameter: " + game); // >> Parameter: com.in28minutes.learn_spring_framework.learnsprfrwk02.game.PacmanGame@6a370f4
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class)){
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }

    }
}
