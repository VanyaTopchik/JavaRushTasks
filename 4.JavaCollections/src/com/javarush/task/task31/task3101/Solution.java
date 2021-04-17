package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        File resultFile = new File(args[1]);
        File dest = new File(resultFile.getParentFile() + "/allFilesContent.txt");
        if (FileUtils.isExist(dest)) {
            FileUtils.deleteFile(dest);
        }
        FileUtils.renameFile(resultFile, dest);

        Map<String, byte[]> fileTree = getFileTree(path);
        try (FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
            for (byte[] bytes : fileTree.values()) {
                fileOutputStream.write(bytes);
                fileOutputStream.write("\n".getBytes());
            }
        }
    }

    public static Map<String, byte[]> getFileTree(String root) throws IOException {
        Map<String, byte[]> result = new TreeMap<>();

        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));

        return result;
    }

private static class GetFiles extends SimpleFileVisitor<Path> {
    private Map<String, byte[]> result;

    public GetFiles(Map<String, byte[]> result) {
        this.result = result;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        File file = path.toFile();
        if (file.isFile()) {
            if (file.length() <= 50) {
                result.put(path.getFileName().toString(), Files.readAllBytes(path));
            }
        }
        return super.visitFile(path, basicFileAttributes);
        }
    }
}