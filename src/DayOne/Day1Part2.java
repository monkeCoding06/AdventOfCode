package DayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1Part2 {
    private static final String regex = "one|two|three|four|five|six|seven|eight|nine";
    private static final String regexToReplace = "on|tw|thre|fou|fiv|si|seve|eigh|nin";

    @SuppressWarnings("DuplicatedCode")
    protected int extractNumber(String data) {
        String firstNumber = String.valueOf(data.charAt(0));
        String secondNumber = String.valueOf(data.charAt(data.length() - 1));
        if (data.length() < 2) {
            secondNumber = firstNumber;
        }
        String fullNumber = firstNumber + secondNumber;
        return Integer.parseInt(fullNumber);
    }

    protected String convertNumberNamesToNumbers(String data) {
        Pattern regexPattern = Pattern.compile(regex);
        Matcher matcher = regexPattern.matcher(data);
        while (matcher.find()) {
            String name = matcher.group();
            switch (name) {
                case "one": data = data.replaceFirst(regexToReplace, "1");break;
                case "two": data = data.replaceFirst(regexToReplace, "2");break;
                case "three": data = data.replaceFirst(regexToReplace, "3");break;
                case "four": data = data.replaceFirst(regexToReplace, "4");break;
                case "five": data = data.replaceFirst(regexToReplace, "5");break;
                case "six": data = data.replaceFirst(regexToReplace, "6");break;
                case "seven": data = data.replaceFirst(regexToReplace, "7");break;
                case "eight": data = data.replaceFirst(regexToReplace, "8");break;
                case "nine": data = data.replaceFirst(regexToReplace, "9");break;
            }
        }
        return data;
    }

    @SuppressWarnings("DuplicatedCode")
    protected int getResult() throws FileNotFoundException {
        int sum = 0;
        File inputDay1 = new File("src\\DayOne\\advent1.txt");
        Scanner scannerInput = new Scanner(inputDay1);
        while (scannerInput.hasNextLine()) {
            String data = scannerInput.nextLine();
            for (int i = 0; i < data.length() - 1; i++) {
                data = convertNumberNamesToNumbers(data);
            }
            data = data.replaceAll("\\D", "");
            int number = extractNumber(data);
            sum += number;
        }
        return sum;
    }

    protected void run() throws FileNotFoundException {
        int sum = getResult();
        System.out.println("day one part two solution: " + sum);
    }
}