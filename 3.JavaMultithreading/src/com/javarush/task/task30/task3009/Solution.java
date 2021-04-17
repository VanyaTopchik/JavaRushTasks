package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }
    private static  Set<Integer> getRadix(String number){
        Set<Integer> set = new HashSet<>();
        String result;
            e: for (int i = 2; i < 37; i++) {
                boolean bool = true;
                try {
                result = "" + Integer.toString(Integer.parseInt(number), i);
                char[] chars;
                chars = result.toCharArray();
                for (int j = 0; j < chars.length / 2; j++) {
                    if (chars[j] != chars[chars.length - j - 1]) {
                        bool = false;
                    }
                }
                if (bool == true) {
                    set.add(i);
                }
                }catch (NumberFormatException e){
                }
            }
        return set;
    }
}