package com.javarush.task.task08.task0823;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 
Омовение Рамы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.
Пример ввода:
мама мыла раму.
Пример вывода:
Мама Мыла Раму.
Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать строку с клавиатуры.
3. Класс Solution должен содержать один метод.
4. Программа должна заменять в тексте первые буквы всех слов на заглавные.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int i = 1;
        while (s.charAt(i - 1) == ' ') i++;
        s = s.substring(0, i).toUpperCase() + s.substring(i);
        while (true) {
            i = s.indexOf(" ", i);
            if (i != -1) {
                if (s.charAt(i) == ' ') i++;
                s = s.substring(0, i) + s.substring(i, i + 1).toUpperCase() + s.substring(i + 1);
            } else break;
        }
        System.out.println(s);
    }
}

