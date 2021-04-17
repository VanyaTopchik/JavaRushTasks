package com.javarush.task.task08.task0816;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/*
Добрая Зинаида и летние каникулы
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.
Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        for(int i=0;i<10;i++){
        map.put("Сталлоне"+i, dateFormat.parse("MAY 1 2012"));}
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Map<String, Date> Copymap = new HashMap<>();
        Copymap.putAll(map);
        for(Map.Entry<String,Date> pair: Copymap.entrySet()){
            if(pair.getValue().getMonth()>4&&pair.getValue().getMonth()<8) map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
    }
}
