package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
 //      Integer[] q = sort(new Integer[]{13,8,15,5,17,10});
 //     for(Integer w: q){
 //          System.out.print(" "+w+" ");
 //     }
    }

    public static Integer[] sort(Integer[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer n: array){
            list.add(n);
        }
        Collections.sort(list);
        Integer mediana;
        if(list.size()%2!=0){
            mediana = list.get((list.size()+1)/2-1);
        }
        else{
            mediana = (list.get(list.size()/2-1)+list.get(list.size()/2))/2;
        }
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Integer.compare(Math.abs(mediana-o1),Math.abs(mediana-o2));
                if(a==0){
                    return Integer.compare(o1,o2);
                }
                else return a;
            }
        };
        Collections.sort(list,comparator);
        list.toArray(array);
        return array;
    }
}
