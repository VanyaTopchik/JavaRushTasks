package com.javarush.task.task24.task2407;

import java.util.ArrayList;
import java.util.List;

/* 
Реализация интерфейса используя локальный класс
*/
public class Solution {
    ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}
