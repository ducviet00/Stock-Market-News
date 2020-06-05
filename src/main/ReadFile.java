package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFile implements IReadData {

    @Override
    public List<String> readData(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        ReadFile rf = new ReadFile();
        List<String> example = rf.readData("Data\\sentences_data\\Sentence1_decrease.txt");
        for (String s : example) {
            System.out.println(s);
        }
    }
}

