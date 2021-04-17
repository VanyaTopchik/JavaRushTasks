package com.javarush.task.task18.task1808;

import java.io.*;

/*
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.
Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/
public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String name1 = reader.readLine();
            String name2 = reader.readLine();
            String name3 = reader.readLine();
            FileInputStream inputStream = new FileInputStream(name1);
            FileOutputStream outputStream1 = new FileOutputStream(name2);
            FileOutputStream outputStream2 = new FileOutputStream(name3);
            while (inputStream.available()>0){
                byte[] buf = new byte[inputStream.available()];
                inputStream.read(buf);
                if(buf.length%2==0){
                    outputStream1.write(buf,0,buf.length/2);
                    outputStream2.write(buf,buf.length/2,buf.length/2);
                }
                else {
                    outputStream1.write(buf,0,buf.length/2+1);
                    outputStream2.write(buf,buf.length/2+1,buf.length/2);
                }
            }
            reader.close();
            inputStream.close();
            outputStream1.close();
            outputStream2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}