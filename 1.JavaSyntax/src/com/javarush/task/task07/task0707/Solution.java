package com.javarush.task.task07.task0707;

/* 
Что за список такой?
1. Создай список строк.
2. Добавь в него 5 различных строк.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.


*/

import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> s = new ArrayList<String>();
        for(int i=0;i<5;i++)
            s.add("hello");
        System.out.println(s.size());
        for(int i=0;i<5;i++)
            System.out.println(s.get(i));
    }
}
