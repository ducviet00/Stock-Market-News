package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Patterns {

    static List<String> readFile(String fileName) {
        double a = 9.0;
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        List<String> example = readFile("Data\\sentences_data\\Sentence1.txt");
        for (String s : example) {
            System.out.println(s);
        }
    }
}

