package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.
Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream = new FileInputStream(reader.readLine());
        long[] bytes = new long[256];
        while(stream.available()>0){
            bytes[stream.read()]++;
        }
        int max = 0;
        for(int i=0;i<256;i++){
            if(bytes[i]>max) max = (int) bytes[i];
        }
        for(int i=0;i<256;i++){
            if(max==bytes[i]) System.out.print(i+" ");
        }
        reader.close();
        stream.close();
    }
}
