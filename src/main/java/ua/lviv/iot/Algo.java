package ua.lviv.iot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Algo {
    private List<String> possibleStrings;

    public void evaluate(String pathToFile) {
        String[] values = ReaderAndWriter.readFromFile(pathToFile);
        String binaryStringFromFile = values[0];
        int numberFromFile = Integer.parseInt(values[1]);
        possibleStrings = getSubstringsFromNumber(numberFromFile, binaryStringFromFile.length());
        int result = doAllEvaluations(binaryStringFromFile);
        ReaderAndWriter.writeToFile(result);
    }

    private int doAllEvaluations(String binaryNumber) {
        int length = binaryNumber.length() + 1;
        Integer[] lol = new Integer[length];
        Arrays.fill(lol, Integer.MAX_VALUE);
        lol[0] = 0;
        List<Integer> lengthsOfElement = Arrays.asList(lol);
        for (int i = 0; i < length; i++) {
            for (String string : possibleStrings) {
                int lengthOfSubstring = string.length();
                if (i - lengthOfSubstring < 0) break;
                if (Objects.equals(lengthsOfElement.get(i - lengthOfSubstring), Integer.MAX_VALUE)) continue;
                if (binaryNumber.startsWith(string, i - lengthOfSubstring)) {
                    lengthsOfElement.set(i,
                            Integer.min(lengthsOfElement.get(i), lengthsOfElement.get(i - lengthOfSubstring) + 1));
                }
            }
        }
        return lengthsOfElement.get(length - 1);
    }

    private List<String> getSubstringsFromNumber(int number, int length) {
        List<String> result = new ArrayList<>();
        int curr = 1;
        while (true) {
            String binaryNumb = convertNumberToBinary(curr);
            if (binaryNumb.length() > length) break;
            result.add(binaryNumb);
            curr *= number;
        }
        return result;
    }

    public String convertNumberToBinary(int number) {
        return Integer.toBinaryString(number);
    }
}
