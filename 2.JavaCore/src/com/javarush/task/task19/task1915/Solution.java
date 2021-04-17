package com.javarush.task.task19.task1915;
/* 
Дублируем текст
*/
import java.io.*;

public class Solution {
    public static TestString testString = new TestString();
    public static void main(String[] args) throws IOException {
        PrintStream oldOut = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(arrayOutputStream);
        System.setOut(newOut);
        testString.printSomething();
        arrayOutputStream.writeTo(outputStream);
        System.setOut(oldOut);
        System.out.println(arrayOutputStream.toString());
        reader.close();
        outputStream.close();
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}