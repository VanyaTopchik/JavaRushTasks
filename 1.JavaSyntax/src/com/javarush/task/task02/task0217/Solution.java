package com.javarush.task.task02.task0217;

/* 
Минимум четырех чисел
*/
public class Solution {
    public static int min(int a, int b, int c, int d) {
        int s,x,z;
        s = min(a,b);
        x = min(c,d);
        z = min(s,x);
        return z;
    //напишите тут ваш код

    }

    public static int min(int a, int b) {
        int q;
        if (a < b)
        q=a;
        else
        q=b;
        return q;//напишите тут ваш код

    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-40, -10, -30, 40));
        System.out.println(min(-20, -40, -30, 40));
        System.out.println(min(-20, -10, -40, 40));
        System.out.println(min(-20, -10, -30, -40));
    }
}