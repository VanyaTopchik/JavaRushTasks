package com.javarush.task.task08.task0814;
import java.util.HashSet;
import java.util.Set;
/* 
Больше 10? Вы нам не подходите
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.

Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод createSet() должен создавать и возвращать множество Set состоящих из 20 различных чисел.
5. Метод removeAllNumbersGreaterThan10() должен удалять из множества все числа больше 10.
*/
public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<20; i++)
            set.add(i);
        return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Set<Integer> copy = new HashSet<>();
        copy.addAll(set);
        for(int i: copy)
            if(i>10) set.remove(i);
        return set;
    }

    public static void main(String[] args) {
    }
}
