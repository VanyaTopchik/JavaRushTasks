package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();
    public static void main(String[] args) {
        PrintStream oldConsole = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newConsole = new PrintStream(outputStream);
        System.setOut(newConsole);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(oldConsole);
        String str = result.toUpperCase();
        System.out.println(str);
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
