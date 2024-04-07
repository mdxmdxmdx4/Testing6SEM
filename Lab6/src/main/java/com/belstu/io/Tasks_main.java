package com.belstu.io;

import java.io.*;
import java.nio.file.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;
import java.util.List;
import java.io.IOException;

public class Tasks_main {
    public void processInput(String input) throws IOException {
        File file = new File(input);
        if (file.isDirectory()) {
            writeStructureToFile(file);
        } else if (file.isFile()) {
            readAndPrintFileData(file);
        } else {
            System.out.println("Введенный путь не является директорией или файлом.");
        }
    }

    private void writeStructureToFile(File directory) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("structure.txt"))) {
            writeDirectoryStructure(directory, writer, 0);
            System.out.println("Directory structure has been written to structure.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeDirectoryStructure(File directory, BufferedWriter writer, int depth) throws IOException {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        String indent = "    ".repeat(depth);
        for (File file : files) {
            if (file.isDirectory()) {
                writer.write(indent + "|-----" + file.getName() + "\n");
                writeDirectoryStructure(file, writer, depth + 1);
            } else {
                writer.write(indent + "-----" + file.getName() + "\n");
            }
        }
    }

    private void readAndPrintFileData(File file) throws IOException {
        int folders = 0;
        int filesCount = 0;
        int totalFileNameLength = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    if (line.trim().startsWith("|")) {
                        folders++;
                    } else if (line.trim().startsWith("-")) {
                        filesCount++;
                        Matcher matcher = Pattern.compile("-(.*?)[.]").matcher(line);
                        if (matcher.find()) {
                            totalFileNameLength += matcher.group(1).length();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        double averageFilesPerFolder = (double) filesCount / folders;
        double averageFileNameLength = (double) totalFileNameLength / filesCount;

        System.out.println("Количество папок: " + folders);
        System.out.println("Количество файлов: " + filesCount);
        System.out.println("Среднее количество файлов в папке: " + averageFilesPerFolder);
        System.out.println("Средняя длина названия файла: " + averageFileNameLength);
    }
}