package DayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2Part2 {
    protected int extractEachBiggestNumberPerColor(String data, String color) {
        int biggestNumber = 0;
        Pattern colorExtractNumberPattern = Pattern.compile("(\\d+) " + color);
        Matcher colorMatcher = colorExtractNumberPattern.matcher(data);
        while (colorMatcher.find()) {
            int currentNumber = Integer.parseInt(colorMatcher.group(1));
            if (currentNumber > biggestNumber) {
                biggestNumber = currentNumber;
            }
        }
        return biggestNumber;
    }

    public int getResult() throws FileNotFoundException {
        int sum = 0;
        File inputDay2 = new File("src\\DayTwo\\advent2.txt");
        Scanner scannerInput = new Scanner(inputDay2);
        while (scannerInput.hasNextLine()) {
            String data = scannerInput.nextLine();
            int biggestNumberRed = extractEachBiggestNumberPerColor(data, "red");
            int biggestNumberBlue = extractEachBiggestNumberPerColor(data, "blue");
            int biggestNumberGreen = extractEachBiggestNumberPerColor(data, "green");
            int preSum = (biggestNumberRed * biggestNumberBlue * biggestNumberGreen);
            sum += preSum;
        }
        return sum;
    }

    protected void run() throws FileNotFoundException {
        int result = getResult();
        System.out.println("day two part two result: " + result);
    }
}