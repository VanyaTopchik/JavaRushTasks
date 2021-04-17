package com.javarush.task.task06.task0612;
public class Calculator {
    public static int plus(int a, int b) {
        return a+b; }
    public static int minus(int a, int b) {
        return a-b; }
    public static int multiply(int a, int b) {
        return a*b; }
    public static double division(int a, int b) {
        double z = a;
        return z/b; }
    public static double percent(int a, int b) {
        double z = a, x = b;
        return z*(x/100); }
    public static void main(String[] args) { }
}