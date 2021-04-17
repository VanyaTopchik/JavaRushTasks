package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
Требования:
1. Программа должна считывать с клавиатуры 2 строки.
2. В случае если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
3. Программа должна выводить данные на экран.
4. Программа должна выводить на экран наибольший общий делитель(НОД) чисел считанных с клавиатуры и успешно завершаться.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = 0, num2 = 0;
        num1 = Integer.parseInt(reader.readLine());
        num2 = Integer.parseInt(reader.readLine());
        if (num1 > 0 && num2 > 0) System.out.println(NOD(num1, num2));
        else throw new Exception();
    }
    public static int NOD (int a, int b){ //метод вычисление наибольшего общего делителя двух чисел
        int count = 0; //счетчик для отлова первого делителя
        int endForCycle = minOfTwo(a,b); //началу цикла присваиваем значение минимального из двух чисел
        int result = 0; //пойманный результат (для возвращения из метода)
        while (count == 0){
            if ((a % endForCycle == 0) && (b % endForCycle == 0)) { //если оба числа делятся без остатка, то ловим этот делитель и увеличиваем счетчик (чтобы завершить цикл)
                result = endForCycle;
                count++;
            } else endForCycle--;
        }
        return result;
    }

    public static int minOfTwo (int a, int b) {
        return (a <= b ? a : b);
    }

}
