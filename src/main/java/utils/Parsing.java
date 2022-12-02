package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parsing {

    public static List<String> parseTextFile(String filename) {
        List<String> list = new ArrayList<>();

        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<String> parseInlineTextFile(String filename, String separator) {
        List<String> list = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                String[] stringArray = line.split(separator);
                list = Arrays.asList(stringArray);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
