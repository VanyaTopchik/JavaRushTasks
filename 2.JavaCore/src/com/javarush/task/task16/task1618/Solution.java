package com.javarush.task.task16.task1618;
/* 
Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().
Требования:
1. Класс TestThread должен быть унаследован от Thread.
2. Класс TestThread должен иметь public void метод run.
3. Метод main должен создавать объект типа TestThread.
4. Метод main должен вызывать метод start у объекта типа TestThread.
5. Метод main должен вызывать метод interrupt у объекта типа TestThread.
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread thread1 = new TestThread();
        thread1.start();
        thread1.interrupt();
    }
    public static class TestThread extends Thread{
        @Override
        public void run() {
        }
    }
}