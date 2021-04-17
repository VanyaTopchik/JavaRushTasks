package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> list = new ArrayList<>();
        while (fileReader.ready()){
            String str[] = fileReader.readLine().split(" ");
            for(int i=0;i<str.length;i++){
                if(str[i].length()>6){
                    list.add(str[i]);
                }
            }
        }
        for (int i=0;i<list.size()-1;i++) {
            fileWriter.write(list.get(i)+",");
        }
        fileWriter.write(list.get(list.size()-1));
        fileReader.close();
        fileWriter.close();
    }
}
