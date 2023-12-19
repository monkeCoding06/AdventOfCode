package DayThree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part1 {

    private static final List<String> lines = new LinkedList<>();

    public int getResult() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/DayThree//advent3.txt"));

        List<Integer> validNumbers = new ArrayList<>();

        String fileLine;
        int iterator = 0;
        while ((fileLine = reader.readLine()) != null) {
            lines.add(iterator, fileLine);
            iterator++;
        }
        reader.close();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher;
        for (int i = 0; i < lines.size(); i++) {
            matcher = pattern.matcher(lines.get(i));
            while (matcher.find()) {
                if (checkNumberValidity(matcher.group(), i, matcher.start())) {
                    validNumbers.add(Integer.valueOf(matcher.group()));
                }
            }
        }

        return validNumbers.stream().mapToInt(Integer::intValue).sum();
    }

    private static boolean checkNumberValidity(String number, int lineIndex, int matchIndex) {
        String previousLine = lineIndex > 0 ? lines.get(lineIndex - 1) : null;
        String currentLine = lines.get(lineIndex);
        String nextLine = lineIndex < lines.size() - 1 ? lines.get(lineIndex + 1) : null;

        int currIndex;
        for (int i = 0; i < number.length(); i++) {
            currIndex = matchIndex + i;
            if (checkForSymbolOnLine(currentLine, currIndex)) return true;
            if (previousLine != null) {
                if (checkForSymbolOnLine(previousLine, currIndex)) return true;
            }
            if (nextLine != null) {
                if (checkForSymbolOnLine(nextLine, currIndex)) return true;
            }
        }

        return false;
    }

    private static boolean checkForSymbolOnLine(String line, int index) {
        Pattern pattern = Pattern.compile("[^\\d.]");
        Matcher matcher;
        if (index > 0) {
            matcher = pattern.matcher(String.valueOf(line.charAt(index - 1)));
            if (matcher.find()) return true;
        }
        if (index < line.length() - 1) {
            matcher = pattern.matcher(String.valueOf(line.charAt(index + 1)));
            if (matcher.find()) return true;
        }
        matcher = pattern.matcher(String.valueOf(line.charAt(index)));
        return matcher.find();
    }
    public void run() throws IOException {
        int result = getResult();
        System.out.println("Day three solution: " + result);
    }
}