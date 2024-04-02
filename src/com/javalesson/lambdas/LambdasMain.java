package com.javalesson.lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class LambdasMain {
    public static void main(String[] args) {
        String[] colours = {"green", "brown", "black", "blue", "pink", "grey"};
        Player player1 = new Player("Alex", 100);
        Player player2 = new Player("Pavel", 80);
        Player player3 = new Player("Vadim", 80);
        Player player4 = new Player("Viktor", 91);

        Player[] players = {player1,player2,player3,player4};
        Arrays.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o2.score - o1.score;
            }
        });
        for (Player c:players){
            System.out.println(c);
        }

        Arrays.sort(colours, (String o1, String o2) -> o1.charAt(o1.length()-1)-o2.charAt(o2.length()-1));
        System.out.println(Arrays.toString(colours));
    }
    private static class Player{
        private String name;
        private int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
