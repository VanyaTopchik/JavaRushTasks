package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Минимальный байт
Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.
Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться минимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream streamReader = new FileInputStream(reader.readLine());
        int min = streamReader.read();
        while (streamReader.available()>0){
            int n = streamReader.read();
            if(min>n) min = n;
        }
        System.out.println(min);
        reader.close();
        streamReader.close();
    }
}
