package com.in28minutes.learn_spring_framework.game;

public class GameRunner {
    MarioGame game;

    public GameRunner(MarioGame game){
        this.game = game;
    }

    public void run() {
        System.out.println("Running Game" + game); // typically recommended to use logging framework but for now ..
        // >> Running Gamecom.in28minutes.learn_spring_framework.game.MarioGame@4c873330

        game.up();
        game.down();
        game.left();
        game.right();
        // >> Jump \n Go into a hole \n Go back \n Accelerate

    }
}
