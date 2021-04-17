package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
    }
    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;
        PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner=fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] person = this.fileScanner.nextLine().split(" ",4);
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date date = null;
            try {
                date = format.parse(person[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(person[1],person[2],person[0],date);
        }
        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
