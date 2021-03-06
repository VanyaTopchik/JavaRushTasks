package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static{
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        while(fileReader.ready()){
            String str[] = fileReader.readLine().split(" ");
            for(int i =0; i<str.length;i++){
                for ( Map.Entry<Integer,String> pair: map.entrySet()) {
                    if(str[i].matches("\\d+")) {
                        if (pair.getKey().equals(Integer.parseInt(str[i]))) str[i] = pair.getValue();
                    }
                }
                list.add(str[i]+" ");
            }
            list.add("\n");
        }
        for(String s : list){
            System.out.print(s);
        }
        fileReader.close();
        reader.close();
    }
}
//C:\Users\Иван\Desktop\lol.txt