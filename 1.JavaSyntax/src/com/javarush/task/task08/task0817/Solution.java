package com.javarush.task.task08.task0817;
import java.util.HashMap;
import java.util.Map;
/*
Нам повторы не нужны
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.
Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, String состоящих из 10 записей.
4. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
5. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().
*/
public class Solution {
    public static Map<String, String> createMap() {
        Map<String,String> map = new HashMap<>();
        for(int i=0;i<10;i++)
            map.put("Кузнецов"+i,"Петр");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> Copymap = new HashMap<>();
        Copymap.putAll(map);
        for (Map.Entry<String, String> pair : Copymap.entrySet()) {
            removeItemFromMapByValue(map, pair.getValue());
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
    }
}
