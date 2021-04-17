package com.javarush.task.task09.task0930;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s==null||s.isEmpty()) {
                break;
            }
            list.add(s);
        }
        String[] array = list.toArray(new String[0]);
        sort(array);
        for (String x : array) {
            System.out.println(x);
        }
    }
    public static void sort(String[] array) {
        int indexOfNumbers[] = new int[array.length];
        int j=0;
        int indexOfWords[] = new int[array.length];
        int k=0;
        for(int i=0;i<array.length;i++)// создал массив с индексами чисел и массив с индексами слов
            if(isNumber(array[i])){
                indexOfNumbers[j] = i;
                j++;
            } else {
                indexOfWords[k] = i;
                k++;
            }
        for (int w=0;w<j;w++) { //пытаюсь отсортировать числа
            for(int i=0;i<j-1;i++){
                if(Integer.parseInt(array[indexOfNumbers[i]])<Integer.parseInt(array[indexOfNumbers[i+1]])){
                    String q = array[indexOfNumbers[i]];
                    array[indexOfNumbers[i]] = array[indexOfNumbers[i+1]];
                    array[indexOfNumbers[i+1]] = q;
                }
            }
        }
        for (int w=0;w<k;w++) {//пытаюсь отсортировать слова
            for(int i=0;i<k-1;i++){
                if(isGreaterThan(array[indexOfWords[i]],array[indexOfWords[i+1]])){
                    String q = array[indexOfWords[i]];
                    array[indexOfWords[i]] = array[indexOfWords[i+1]];
                    array[indexOfWords[i+1]] = q;
                }
            }
        }
    }
    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
