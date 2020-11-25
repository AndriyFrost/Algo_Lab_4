package ua.lviv.iot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class ReaderAndWriter {

    public static void writeToFile(int minNumberOfSplits) {
        try (FileWriter fileWriter = new FileWriter(new File("src/main/java/ua/lviv/iot/test/test.out"))) {
            fileWriter.write("" + minNumberOfSplits);
            fileWriter.flush();
        } catch (Exception ignored) {
        }
    }

    public static String[] readFromFile(String pathToFile) {
        try (Scanner scanner = new Scanner(new File(pathToFile))) {
            String lineFromFile = scanner.nextLine();
            return lineFromFile.split(" ");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return new String[]{"", "0"};
    }
}
