package com.javarush.task.task10.task1011;
/* 
Большая зарплата
Вывести на экран надпись "Я не хочу изучать Java, я хочу большую зарплату" 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
...
зарплату

Требования:
1. Программа должна выводить текст на экран.
2. Программа должна выводить 40 строк.
3. В программе должен использоваться цикл for или while.
4. Выведенный текст должен соответствовать примеру из условия.
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        char[] array = s.toCharArray();
        for (int j=0;j<40;j++) {
            for(int i=j;i<s.length();i++){
                System.out.print(array[i]);
            }
            System.out.println(" ");
        }
    }

}

