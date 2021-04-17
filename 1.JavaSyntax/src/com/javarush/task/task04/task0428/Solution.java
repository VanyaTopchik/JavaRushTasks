package com.javarush.task.task04.task0428;
import java.io.*;
/* 
Положительное число
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = 0;
        int i[] = new int[3];
         i[0] = Integer.parseInt(reader.readLine());
          i[1] = Integer.parseInt(reader.readLine());
           i[2] = Integer.parseInt(reader.readLine());
          for(int j=0;j<3;j++){
          if (i[j]>0)k++;}
        System.out.println(k);                //напишите тут ваш код
    }
}
