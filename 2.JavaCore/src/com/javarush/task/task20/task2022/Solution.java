package com.javarush.task.task20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("C:\\Users\\Иван\\Desktop\\lul.txt");
        solution.writeObject("хуй саси");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Иван\\Desktop\\lol.txt"));
        outputStream.writeObject(solution);
        solution.close();
        outputStream.close();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Иван\\Desktop\\lol.txt"));
        Solution solution1 = (Solution) inputStream.readObject();
        solution1.close();
        inputStream.close();
    }
}
/*    Solution sol = new Solution("C:/1/1.txt");
       sol.writeObject("Записываем данные");
               sol.writeObject("Дозапишем данные - у нас же метод flush а не close в writeObject");


               String filePath = "C:/1/save.bin";
               ObjectOutputStream streamOut = new ObjectOutputStream(new FileOutputStream(filePath));
               //если попытаться тут у объекта запустить метод writeObject(ObjectOutputStream out) и
               //передать туда наш стрим - получим ошибку NotActiveException - это не правильно.
               streamOut.writeObject(sol);
               //закрываем поток вывода в файл
               sol.close();
               //закрываем поток сериализации
               streamOut.close();

               ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream(filePath));
               Solution sol2 = (Solution) streamIn.readObject();
               sol2.writeObject("Данные нового потока.");
               //закрываем поток вывода в файл
               sol2.close();
               //закрываем поток десериализации
               streamIn.close();
 */