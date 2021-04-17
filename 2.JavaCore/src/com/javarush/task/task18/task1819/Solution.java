package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Не используй в программе статические переменные.
3. Для первого файла создай поток для чтения и считай его содержимое.
4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
5. Содержимое первого и второго файла нужно объединить в первом файле.
6. Сначала должно идти содержимое второго файла, затем содержимое первого.
7. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            reader.close();
            FileInputStream inputStream1 = new FileInputStream(file1);
            FileInputStream inputStream2 = new FileInputStream(file2);
            byte[] buffer = new byte[inputStream1.available()+inputStream2.available()];
            while (inputStream1.available()>0){
                inputStream1.read(buffer,inputStream2.available(),inputStream1.available());
            }
            while (inputStream2.available()>0){
                inputStream2.read(buffer,0,inputStream2.available());
            }
            inputStream1.close();
            inputStream2.close();
            FileOutputStream outputStream = new FileOutputStream(file1);
            outputStream.write(buffer,0,buffer.length);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
