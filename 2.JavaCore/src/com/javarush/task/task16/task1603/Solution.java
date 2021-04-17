package com.javarush.task.task16.task1603;
import java.util.ArrayList;
import java.util.List;
/* 
Список и нити
В методе main добавить в статический объект list 5 нитей. Каждая нить должна быть новым объектом класса Thread, работающим со своим объектом класса SpecialThread.
Требования:
1. В методе main создай 5 объектов типа SpecialThread.
2. В методе main создай 5 объектов типа Thread.
3. Добавь 5 разных нитей в список list.
4. Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
5. Метод run класса SpecialThread должен выводить "it's a run method inside SpecialThread".
*/
public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);
    public static void main(String[] args) {
        SpecialThread thread11 = new SpecialThread();
        SpecialThread thread22 = new SpecialThread();
        SpecialThread thread33 = new SpecialThread();
        SpecialThread thread44 = new SpecialThread();
        SpecialThread thread55 = new SpecialThread();
        Thread thread1 = new Thread(thread11);
        Thread thread2 = new Thread(thread22);
        Thread thread3 = new Thread(thread33);
        Thread thread4 = new Thread(thread44);
        Thread thread5 = new Thread(thread55);
        list.add(thread1);
        list.add(thread2);
        list.add(thread3);
        list.add(thread4);
        list.add(thread5);
    }
    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
