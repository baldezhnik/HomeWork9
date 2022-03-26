package com.dsd;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // String filePath = "src/com/dsd/test1.txt";
        String outFilePath = "src/Valid.txt"; // Заметил особенность что даже при отсутвии файла, он его создаст.
        String errorPath = "src/Invalid.txt";

        System.out.println("\tHomeWork");
        System.out.println("Введите путь к файлу");

        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter outFileWriter = new FileWriter(outFilePath);
            BufferedWriter outBufferedWriter = new BufferedWriter(outFileWriter);

            FileWriter outError = new FileWriter(errorPath);
            BufferedWriter outBufferedError = new BufferedWriter(outError);

            String line = bufferedReader.readLine();
            while (line != null) {
                if (checkDocNum(line).equals("")) {
                    outBufferedWriter.write(line);
                    outBufferedWriter.append('\n');
                } else {
                    outBufferedError.write(line + ":" + checkDocNum(line));
                    outBufferedError.append('\n');
                }
                line = bufferedReader.readLine();
            }
            outBufferedWriter.close();
            outBufferedError.close();
            bufferedReader.close();

        } catch (FileNotFoundException ex1) {
            System.out.println("Файл не найден");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            System.out.println("\n\tMade by Dmitry Drako (─‿‿─)");
        }

    }

    static String checkDocNum(String docNum) {
        String res = (docNum.length() != 15) ? " Не соответствует количество символов." : "";
        return res + ((docNum.startsWith("docnum") || docNum.startsWith("contract")) ?
                "" : " Отсутсвует docnum или contract в начале.");
    }
}


