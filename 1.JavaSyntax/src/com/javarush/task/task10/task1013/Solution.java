package com.javarush.task.task10.task1013;
/* 
Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.
Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/
public class Solution {
    public static void main(String[] args) {
    }
    public static class Human {
        private int  n1;
        private boolean n2;
        private char n3;
        private String n4;
        private double n5;
        private byte n6;
        public Human(int n1){}
        public Human(boolean n2){}
        public Human(char n3){}
        public Human(String n4){}
        public Human(double n5){}
        public Human(byte n6){}
        public Human(int n1,double n5){}
        public Human(int n1,byte n6){}
        public Human(int n1,String n4){}
        public Human(int n1,boolean n2){}
    }
}
