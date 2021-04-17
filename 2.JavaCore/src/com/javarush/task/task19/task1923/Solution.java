package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        while(fileReader.ready()){
            String str[] = fileReader.readLine().split(" ");
            for(int i=0;i<str.length;i++){
                if(str[i].matches("(.*)(\\d+)(.*)")){
                    fileWriter.write(str[i]+" ");
                }
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
