package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        Zerg zerg1 = new Zerg();
        zerg1.name = "vasya";
        Zerg zerg2 = new Zerg();
        zerg2.name = "vasy";
        Zerg zerg3 = new Zerg();
        zerg3.name = "vas";
        Zerg zerg4 = new Zerg();
        zerg4.name = "va";
        Zerg zerg5 = new Zerg();
        zerg5.name = "v";
        Protoss protoss1 = new Protoss();
        protoss1.name = "kolya";
        Protoss protoss2 = new Protoss();
        protoss2.name = "kol";
        Protoss protoss3 = new Protoss();
        protoss3.name = "k";
        Terran terran1 = new Terran();
        terran1.name = "pisya";
        Terran terran2 = new Terran();
        terran2.name = "pisy";
        Terran terran3 = new Terran();
        terran3.name = "pis";
        Terran terran4 = new Terran();
        terran4.name = "pi";
        //напишите тут ваш код

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
