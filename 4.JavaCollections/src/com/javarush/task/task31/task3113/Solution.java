package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Что внутри папки?
*/

public class Solution{

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String str = br.readLine();
            if(!Files.isDirectory(Paths.get(str))){
                System.out.println(str+" - не папка");
            }
            else{
                Path path = Paths.get(str);
                AtomicInteger countFiles = new AtomicInteger(0);
                AtomicInteger countDirectorys = new AtomicInteger(0);
                AtomicInteger sizeFiles = new AtomicInteger(0);
                Files.walkFileTree(path, new FileVisitor<Path>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        if(!dir.equals(path))
                        countDirectorys.incrementAndGet();
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        countFiles.incrementAndGet();
                        if(Files.isRegularFile(file)) {
                            sizeFiles.addAndGet((int) attrs.size());
                        }
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        return FileVisitResult.CONTINUE;
                    }
                });
                System.out.println("Всего папок - "+countDirectorys.get());
                System.out.println("Всего файлов - "+countFiles.get());
                System.out.println("Общий размер - "+sizeFiles);

            }
        }
    }
}
