package com.javarush.task.task17.task1707;


public class IMF {
    private static IMF imf;
    public static IMF getFund() {
        if(imf==null) {
            synchronized (IMF.class) {
                imf = new IMF();
            }
            return imf;
        }
        else return imf;
    }
    private IMF() {
    }
   // нужно проверить, не ссылается ли уже imf  на объект, если да, то вернуть эту ссылку, если нет, то создать объект, инициализировать им ссылку и вернуть. Погугли паттерн  singleton.
}
