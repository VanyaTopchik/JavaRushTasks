package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile file = new RandomAccessFile(fileName,"rw");
        file.seek(number);
        byte[] buff = new byte[text.length()];
        file.read(buff,0,text.length());
        String str = new String(buff);
        file.seek(file.length());
        if(str.equals(text)){
            file.write("true".getBytes());
        }
        else file.write("false".getBytes());
    }
}
