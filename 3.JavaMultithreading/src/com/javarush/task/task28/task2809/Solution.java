package com.javarush.task.task28.task2809;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/* 
Plants vs Zombies
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = new ArrayList<>();
        characters.add(new Plant());
        characters.add(new Plant());
        characters.add(new Zombie());
        characters.add(new Zombie());
        characters.add(new Zombie());
        start(characters);
    }

    private static boolean isEveryoneReady = false;

    private static void start(List<Character> characters) throws InterruptedException {
        final Phaser phaser = new Phaser(1 + characters.size());

        for (final Character character : characters) {
            final String member = character.toString();
            System.out.println(member + " присоединился к игре");
            new Thread() {
                @Override
                public void run() {
                    System.out.println(member + " готовится играть");
                    phaser.arriveAndAwaitAdvance();
                    if (!isEveryoneReady) {
                        isEveryoneReady = true;
                        System.out.println("Игра началась!");
                    }
                    character.run();
                }
            }.start();
        } phaser.arriveAndDeregister();
    }
}
//Plant #1 присоединился к игре
//Plant #2 присоединился к игре
//Plant #1 готовится играть
//Zombie #1 присоединился к игре
//Zombie #2 присоединился к игре
//Zombie #3 присоединился к игре
//Plant #2 готовится играть
//Zombie #2 готовится играть
//Zombie #1 готовится играть
//Zombie #3 готовится играть
//Игра началась!
//Zombie #1 вступил в игру
//Zombie #3 вступил в игру
//Plant #1 вступил в игру
//Zombie #2 вступил в игру
//Plant #2 вступил в игру
//Zombie #2 умер
//Plant #2 умер
//Plant #1 умер
//Zombie #3 умер
//Zombie #1 умер
