package com.in28minutes.learn_spring_framework.learnsprfrwk01;

import com.in28minutes.learn_spring_framework.learnsprfrwk01.game.GameRunner;
import com.in28minutes.learn_spring_framework.learnsprfrwk01.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }

    }
}
