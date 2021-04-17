package com.javarush.task.task07.task0715;

/* 
Продолжаем мыть раму
1. Создай список из слов "мама", "мыла", "раму".
2. После каждого слова вставь в список строку, содержащую слово "именно".
3. Вывести результат на экран, каждый элемент списка с новой строки.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Объяви переменную типа список строк и сразу проинициализируй ee.
3. Добавь в список слова: «мама», «мыла», «раму».
4. После каждого слова добавь в список строку, содержащую слово «именно».
5. Выведи элементы списка на экран, каждый с новой строки.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<String>();
        s.add(0,"мама");
        s.add(1,"мыла");
        s.add(2,"раму");
        for(int i=1; i<6; i +=2)
            s.add(i,"именно");
        for(int i=0; i<6; i++)
            System.out.println(s.get(i));
    }
}