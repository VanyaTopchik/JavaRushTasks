package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<10; i++)
            list.add(Integer.parseInt(reader.readLine()));
        int count=1;
        int max=1;
        for(int i=0; i<list.size()-1; i++) {
            if (list.get(i).equals(list.get(i+1))){ 
                count++;
                if(count>max) max = count;
            }
            else count=1;
        }
        System.out.println(max);
    }
}