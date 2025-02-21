package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.PacmanGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {

        //var game = new MarioGame();
        //var game = new SuperContraGame();
        var game = new PacmanGame(); // 1: Object Creation

        var gameRunner = new GameRunner(game);
            // 2: Object Creation + Wiring(Injection) of Dependencies (의존성 연결)
            // Game = Dependency of GameRunner

        gameRunner.run();

    }
}
