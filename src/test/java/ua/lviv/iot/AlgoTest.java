package ua.lviv.iot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoTest {

    private Scanner scanner;

    @BeforeEach
    public void initializeScanner() {
        try {
            scanner = new Scanner(new File("src/main/java/ua/lviv/iot/test/test.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    void test1() {
        testResult("src/main/java/ua/lviv/iot/test/test1.in", "3");
    }

    @Test
    void test2() {
        testResult("src/main/java/ua/lviv/iot/test/test2.in", "1");
    }

    @Test
    void test3() {
        testResult("src/main/java/ua/lviv/iot/test/test3.in", "3");
    }
    @Test
    void test4() {
        testResult("src/main/java/ua/lviv/iot/test/test4.in", "7");
    }

    private void testResult(String pathToFile, String expected) {
        Algo count = new Algo();
        count.evaluate(pathToFile);
        assertEquals(expected, scanner.nextLine());
    }
}
