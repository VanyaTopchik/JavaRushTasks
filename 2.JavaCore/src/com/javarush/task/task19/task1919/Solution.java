package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
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
        while(fileReader.ready()) {
            String[] str = fileReader.readLine().split(" ");
            if (map.containsKey(str[0])) {
                double n = map.get(str[0]);
                map.remove(str[0]);
                map.put(str[0], n + Double.parseDouble(str[1]));
            }
            else map.put(str[0],Double.parseDouble(str[1]));
        }
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String,Double> pair: map.entrySet()){
            list.add(pair.getKey());
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i) +" "+ map.get(list.get(i)));
        }
        fileReader.close();
    }
}
