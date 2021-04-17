package com.javarush.task.task19.task1916;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/* 
Отслеживаем изменения
*/
public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(file2));
        ArrayList<String> str1 = new ArrayList<>();
        ArrayList<String> str2 = new ArrayList<>();
        do {
            if (fileReader1.ready()) str1.add(fileReader1.readLine());
            if (fileReader2.ready()) str2.add(fileReader2.readLine());
        } while (fileReader1.ready() || fileReader2.ready());
        System.out.println(str1);
        System.out.println(str2);
        int j=0,i=0;
        while(i<str1.size()&&j<str2.size()){
            System.out.println(i+" "+j);
            if(str1.get(i).equals(str2.get(j))){
                lines.add(new LineItem(Type.SAME,str1.get(i)));
                i++;
                j++;
                System.out.println("11");
            }
            else if(i!=str1.size()-1 && str1.get(i+1).equals(str2.get(j))){
                lines.add(new LineItem(Type.REMOVED,str1.get(i)));
                i++;
                System.out.println("22");
            }
            else if(j!=str2.size()-1 && str1.get(i).equals(str2.get(j+1))){
                lines.add(new LineItem(Type.ADDED,str2.get(j)));
                j++;
                System.out.println("33");
            }
            if(j==str2.size()&&i==str1.size()) break;
            else if(i==str1.size()){
                lines.add(new LineItem(Type.ADDED,str2.get(j)));
                j++;
                System.out.println("44");
            }
            else if(j==str2.size()){
                lines.add(new LineItem(Type.REMOVED,str1.get(i)));
                i++;
                System.out.println("55");
            }
        }
        System.out.println("результат:");
        for (LineItem line : lines) {
            System.out.println(line.type +" "+ line.line);
        }
        fileReader1.close();
        fileReader2.close();
    }
    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }
    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
/*
C:\Users\Иван\Desktop\lul.txt
C:\Users\Иван\Desktop\lul2.txt
 */