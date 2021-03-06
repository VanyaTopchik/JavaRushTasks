package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        for(String token: getTokens("level22.lesson13.task01", ".")) {
            System.out.println(token);
        }
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        ArrayList<String> list = new ArrayList<>();
        while(tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }
        String[] str = new String[list.size()];
        return list.toArray(str);
    }
}
