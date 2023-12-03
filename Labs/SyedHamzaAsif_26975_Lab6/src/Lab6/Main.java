package Lab6;

import Lab6.Game;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        game.insert("hazma");
        game.insert("soomra");
        game.insert("suckina");
        game.insert("suck");

        System.out.println(game);
        System.out.println(game.playGame());


    }
}