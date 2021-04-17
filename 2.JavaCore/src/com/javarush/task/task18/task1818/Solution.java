package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String name1 = reader.readLine();
            String name2 = reader.readLine();
            String name3 = reader.readLine();
            FileOutputStream fileOutputStream1 = new FileOutputStream(name1,true);
            FileInputStream fileInputStream2 = new FileInputStream(name2);
            FileInputStream fileInputStream3 = new FileInputStream(name3);
            byte[] buffer = new byte[fileInputStream2.available()];
            while (fileInputStream2.available()>0){
                fileInputStream2.read(buffer);
                fileOutputStream1.write(buffer);
            }
            byte[] buffer2 = new byte[fileInputStream3.available()];
            while (fileInputStream3.available()>0){
                fileInputStream3.read(buffer2);
                fileOutputStream1.write(buffer2);
            }
            fileOutputStream1.close();
            fileInputStream2.close();
            fileInputStream3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
