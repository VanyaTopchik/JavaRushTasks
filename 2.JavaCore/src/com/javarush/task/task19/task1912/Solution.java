package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();
    public static void main(String[] args) {
        PrintStream oldOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(outputStream);
        System.setOut(newOut);
        testString.printSomething();
        String result = outputStream.toString().replaceAll("te","??");
        System.setOut(oldOut);
        System.out.println(result);
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
