package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new HashMap<>();
        while (fileReader.ready()) {
            String[] str = fileReader.readLine().split(" ");
            if (map.containsKey(str[0])) {
                double n = map.get(str[0]);
                map.remove(str[0]);
                map.put(str[0], n + Double.parseDouble(str[1]));
            } else map.put(str[0], Double.parseDouble(str[1]));
        }
        ArrayList<Double> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            list.add(pair.getValue());
        }
        Collections.sort(list);
        Collections.reverse(list);
        for (Map.Entry<String,Double> pair : map.entrySet()){
            if(pair.getValue().equals(list.get(0))){
                list2.add(pair.getKey());
            }
        }
        Collections.sort(list2);
        for (String s : list2) {
            System.out.println(s);
        }
        fileReader.close();
    }
}
