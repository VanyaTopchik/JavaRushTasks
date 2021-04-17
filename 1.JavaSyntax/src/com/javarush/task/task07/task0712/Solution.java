package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3. Должна быть выведена одна строка.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
3. Программа должна выводить на экран самую короткую строку, если она была раньше самой длинной.
4. Программа должна выводить на экран самую длинную строку, если она была раньше самой короткой.
5. Должна быть выведена только одна строка.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> s = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<10; i++)
            s.add(reader.readLine());
        String min = s.get(0);
        String max = s.get(0);
        for(int i=0; i<10; i++){
            if(s.get(i).length()>max.length()) max = s.get(i);
            if(s.get(i).length()<min.length()) min = s.get(i);
        }
        for(int i=0; i<10; i++){
            if(max.length()==s.get(i).length()){
                System.out.println(s.get(i));
                break;
            }
            if(min.length()==s.get(i).length()){
                System.out.println(s.get(i));
                break;
            }
        }
    }
}
