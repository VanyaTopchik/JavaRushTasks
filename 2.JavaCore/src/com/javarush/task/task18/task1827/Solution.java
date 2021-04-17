package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        int id;
        int max = 0;
        if (args.length > 0 && args[0].equals("-c")){
            try (BufferedReader reader1 = new BufferedReader(new FileReader(filename))) {
                while (reader1.ready()) {
                    id = Integer.parseInt(reader1.readLine().substring(0,8).trim());
                    if (id > max) max = id;
                }
                reader1.close();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true))){
                writer.newLine();
                writer.write(String.format("%-8d%-30.30s%-8.8s%-4.4s",max+1,args[1],args[2],args[3]));
                writer.close();
                //     System.out.println(String.format("%-8d%-30.30s%-8.8s%-4.4s",max+1,args[1],args[2],args[3]));
            }
        }
    }
}

