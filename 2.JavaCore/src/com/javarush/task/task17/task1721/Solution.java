package com.javarush.task.task17.task1721;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.
Требования:
1. Класс Solution должен содержать public static поле allLines типа List<String>.
2. Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
3. Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
4. Программа должна считывать c консоли имена двух файлов.
5. Программа должна считывать построчно данные из первого файла в список allLines.
6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.
*/
public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name1 = reader.readLine();
            String name2 = reader.readLine();
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(name1)));
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(name2)));
            while (true) {
                String s = reader1.readLine();
                if (s==null) break;
                else allLines.add(s);
            }
            while (true) {
                String s = reader2.readLine();
                if (s==null) break;
                else forRemoveLines.add(s);
            }
            reader.close();
            Solution solution = new Solution();
            solution.joinData();
            System.out.println(allLines);
            System.out.println(forRemoveLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void joinData() throws CorruptedDataException {
        int n = 0;
        for (int i = 0; i < forRemoveLines.size(); i++) {
            if (allLines.contains(forRemoveLines.get(i)))
                n++;
        }
        if (n == forRemoveLines.size()) {
            for (int i = 0; i < forRemoveLines.size(); i++) {
                allLines.remove(forRemoveLines.get(i));
            }
        } else {
            allLines.removeAll(allLines);
            throw new CorruptedDataException();
        }
    }
}
