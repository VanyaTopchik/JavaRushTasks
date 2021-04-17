package com.javarush.task.task24.task2409;

public interface Jeans extends Item {
    @Override
    int getId();

    @Override
    double getPrice();

    @Override
    String getTM();

    int getLength();

    int getSize();

}
