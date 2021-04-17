package com.javarush.task.task06.task0606;

/* 
Чётные и нечётные циферки
*/
import java.io.*;
public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int l = s.length();
        for(int i=0;i<l;i++){
            int n[] = new int[l];
            char simvol = s.charAt(i);
            n[i] = Character.getNumericValue(simvol);
            if(n[i]%2==0) even++;
            else odd++;
        }
        System.out.println("Even: "+even+" Odd: "+odd);//напишите тут ваш код
    }
}
