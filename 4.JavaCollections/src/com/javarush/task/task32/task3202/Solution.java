package com.javarush.task.task32.task3202;

import java.io.*;
import java.nio.Buffer;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if(is!=null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuffer stringBuffer = new StringBuffer();
            while (reader.ready()) {
                stringBuffer.append(reader.readLine());
            }
            writer.write(stringBuffer.toString());
        }
        return writer;
    }
}
