package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        StringBuilder result = new StringBuilder(Integer.toString(number)+" = ");
        int n=1;
        while(number>0) {
            int ost = number % 3;
            number = number / 3;
            if(ost==2){
                result.append(" - ");
                number = number+1;
                result.append(n);
                n=n*3;
            }
            if(ost==1){
                result.append(" + ");
                result.append(n);
                n=n*3;
            }
            if(ost==0){
                n=n*3;
            }
        }
        System.out.println(result);
    }
}