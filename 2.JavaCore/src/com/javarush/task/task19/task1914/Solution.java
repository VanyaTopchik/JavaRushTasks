package com.javarush.task.task19.task1914;
/* 
Решаем пример
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
        String num[] = outputStream.toString().split(" ");
        int result = 0;
        if(num[1].equals("+")) {
            result = Integer.parseInt(num[0]) + Integer.parseInt(num[2]);
        }
        if(num[1].equals("-")) {
            result = Integer.parseInt(num[0]) - Integer.parseInt(num[2]);
        }
        if(num[1].equals("*")) {
            result = Integer.parseInt(num[0]) * Integer.parseInt(num[2]);
        }
        String result2 = outputStream.toString()+result;
        System.setOut(oldOut);
        System.out.println(result2);
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

