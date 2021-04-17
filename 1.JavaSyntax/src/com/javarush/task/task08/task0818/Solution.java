package com.javarush.task.task08.task0818;
import java.util.HashMap;
import java.util.Map;
/*
Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: "фамилия" - "зарплата".
Удалить из словаря всех людей, у которых зарплата ниже 500.
Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, Integer состоящих из 10 записей по принципу «фамилия» - «зарплата».
4. Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.
*/
public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<10;i++){
            map.put("Вася"+i,1000 - i*100);
        }
        return map;
    }
    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String,Integer> Copymap = new HashMap<>();
        Copymap.putAll(map);
        for(Map.Entry<String,Integer> pair: Copymap.entrySet()){
            if(pair.getValue()<500) map.remove(pair.getKey());
        }
    }
    public static void main(String[] args) {
    }
}