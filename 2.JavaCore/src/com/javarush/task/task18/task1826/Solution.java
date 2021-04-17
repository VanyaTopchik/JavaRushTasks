package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            if(args[0].equals("-e")) {
                byte[] n = new byte[inputStream.available()];
                while (inputStream.available() > 0) {
                    inputStream.read(n);
                }
                for (int i = 0; i < n.length; i++)
                    if(n[i]<256)
                    n[i]++;
                outputStream.write(n);
            }
            if(args[0].equals("-d")) {
                byte[] n = new byte[inputStream.available()];
                while (inputStream.available() > 0) {
                    inputStream.read(n);
                }
                for (int i = 0; i < n.length; i++)
                    n[i]--;
                outputStream.write(n);
            }
            inputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
