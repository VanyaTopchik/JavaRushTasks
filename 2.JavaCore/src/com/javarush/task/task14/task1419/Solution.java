package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* 
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.
Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.
*/
public class Solution{
    public static List<Exception> exceptions = new ArrayList<Exception>();
    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions(){   //it's first exception
        Object srt[] = new String[10];
        int[] nNullArr = new int[5];
        nNullArr = null;
        String str1 = "aaaaa";
        String site = "";
        URL url;
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        //2
        try{
            String[] str = {"1", "2", "3"};
            str[3] = "4";
        } catch (Exception e) {
            exceptions.add(e);
        }
        //3
        try{
            List list = new ArrayList();
            list.add("one");
            list.add("two");
            Iterator it = list.iterator();
            while (it.hasNext()){
                Integer i = (Integer) it.next();
            }
        } catch (Exception e) {
            exceptions.add(e);
        }
        //4
        try{
            srt[0] = new Character('*');
        } catch (Exception e) {
            exceptions.add(e);
        }
        //5
        try{
            int[] ints = new int[-5];
        } catch (Exception e) {
            exceptions.add(e);
        }
        //6
       try{
            int i = nNullArr.length;
        } catch (Exception e) {
            exceptions.add(e);
        }
        //7
        try{
            char myCh = str1.charAt(10);
        } catch (Exception e) {
            exceptions.add(e);
        }
        //8
        try{
            Integer myInt = Integer.parseInt(String.valueOf(str1.charAt(1)));
        } catch (Exception e) {
            exceptions.add(e);
        }
        //9
        try{
            FileInputStream fl = new FileInputStream("C:\\1233344.txt");
            System.out.println(fl.toString());
        } catch (Exception e) {
            exceptions.add(e);
        }
        //10
        try{
            
        } catch (Exception e) {
            exceptions.add(e);
        }
        try{
            url = new URL(site);
        }catch (Exception e){
            exceptions.add(e);
        }
    }
}
