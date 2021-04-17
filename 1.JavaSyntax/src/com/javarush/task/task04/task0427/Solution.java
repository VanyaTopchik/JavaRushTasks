package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());;
        if(i > 0 && i < 1000) {
			System.out.println(
					i % 2 == 0 && i < 10 ? "четное однозначное число" :
					i % 2 != 0 && i < 10 ? "нечетное однозначное число" :
					i % 2 == 0 && i < 100 ? "четное двузначное число" :
					i % 2 != 0 && i < 100 ? "нечетное двузначное число" :
					i % 2 == 0 ? "четное трехзначное число" : "нечетное трехзначное число");

    }}
}