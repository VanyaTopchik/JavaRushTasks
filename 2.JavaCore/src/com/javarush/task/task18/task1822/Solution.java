package com.javarush.task.task18.task1822;

import java.io.*;

/*
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.
В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.
Информация по каждому товару хранится в отдельной строке.
Требования:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));
            while(true) {
                String s = fileReader.readLine();
                if(s==null) break;
                String[] str = s.split(" ");
                if(Integer.parseInt(args[0]) == (Integer.parseInt(str[0]))){
                    System.out.println(s);
                }
            }
            consoleReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
