package com.javarush.task.task08.task0829;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/* 
Модернизация ПО
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи
Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать значения с клавиатуры.
3. Класс Solution должен содержать один метод.
4. Программа должна вывести фамилию семьи по введенному городу.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        while (true) {
            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }
            list.add(family);
        }
        int i=0;
        String city = reader.readLine();
        if(list.contains(city)) i=list.indexOf(city);
        System.out.println(list.get(i+1));
    }
}
