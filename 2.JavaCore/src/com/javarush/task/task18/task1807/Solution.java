package com.javarush.task.task18.task1807;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Подсчет запятых
С консоли считать имя файла.
Посчитать в файле количество символов ',', количество вывести на консоль.
Закрыть потоки.
Подсказка:
нужно сравнивать с ascii-кодом символа ','.
Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должно выводится число запятых в считанном файле.
4. Поток чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileInputStream inputStream = new FileInputStream(reader.readLine());
            while(inputStream.available()>0){
                byte[] buf = new byte[inputStream.available()];
                int n = inputStream.available();
                int sum = 0;
                inputStream.read(buf,0, n);
                for(int i=0;i<buf.length;i++){
                    if(buf[i]==44) sum++;
                }
                System.out.println(sum);
            }
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
