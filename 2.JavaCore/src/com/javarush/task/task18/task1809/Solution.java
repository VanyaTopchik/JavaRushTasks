package com.javarush.task.task18.task1809;
import java.io.*;
/*
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.
Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/
public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String name1 = reader.readLine();
            String name2 = reader.readLine();
            FileInputStream inputStream = new FileInputStream(name1);
            FileOutputStream outputStream = new FileOutputStream(name2);
            while (inputStream.available()>0){
                byte[] buf = new byte[inputStream.available()];
                byte[] buf2 = new byte[inputStream.available()];
                inputStream.read(buf);
                for(int i=0; i<buf.length;i++){
                    buf2[i]=buf[buf.length-1-i];
                }
                outputStream.write(buf2);
            }
            reader.close();
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}