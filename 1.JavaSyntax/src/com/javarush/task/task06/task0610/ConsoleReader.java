package com.javarush.task.task06.task0610;

/* 
Класс ConsoleReader
*/
import java.io.*;
public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        return s;//напишите тут ваш код

    }

    public static int readInt() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        return n;//напишите тут ваш код

    }

    public static double readDouble() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(reader.readLine());
        return n;//напишите тут ваш код

    }

    public static boolean readBoolean() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean n = Boolean.parseBoolean(reader.readLine());
        return n;//напишите тут ваш код

    }

    public static void main(String[] args) throws Exception {

    }
}
