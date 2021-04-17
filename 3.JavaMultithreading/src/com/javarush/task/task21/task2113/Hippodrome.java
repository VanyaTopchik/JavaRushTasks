package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;
    public List<Horse> getHorses(){
        return horses;
    }
    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }
    public void move(){
        for(Horse horse: horses){
            horse.move();
        }
    }
    public void print(){
        for(Horse horse: horses){
            horse.print();
        }
        for(int i=0;i<10;i++){
            System.out.println("");
        }
    }
    public void run() throws InterruptedException {
        for(int i=0;i<100;i++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public Horse getWinner(){
        double max=0;
        for(Horse horse:horses){
            if(horse.getDistance()>max){
                max=horse.getDistance();
            }
        }
        for(Horse horse:horses){
            if(horse.getDistance()==max){
                return horse;
            }
        }
        return null;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
    public static void main(String[] args) throws InterruptedException {
        Horse horse1 = new Horse("horse1",3,0);
        Horse horse2 = new Horse("horse2",3,0);
        Horse horse3 = new Horse("horse3",3,0);
        List<Horse> horses = new ArrayList<>();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        Hippodrome hippodrome = new Hippodrome(horses);
        Hippodrome.game = hippodrome;
        game.run();
        game.printWinner();
    }
}
