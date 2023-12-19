package DayFour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4Part1 {
    protected int getResult() throws FileNotFoundException {
        int sum = 0;
        File input = new File("src\\DayFour\\advent4.txt");
        Scanner scannerInput = new Scanner(input);
        while (scannerInput.hasNextLine()) {
            String data = scannerInput.nextLine();
            int cardValue = getCardValue(data);
            sum += cardValue;
        }
        return sum;
    }

    public void run() throws FileNotFoundException {
        int sum = getResult();
        System.out.println("day four solution: " + sum);
    }

    protected int getCardValue(String data) {
        int value = 0;
        Pattern pattern = Pattern.compile("\\d+");
        String winningNumbersString = data.substring(data.indexOf(':') + 1, data.indexOf('|'));
        String numbersPresentString = data.substring(data.indexOf('|') + 1) + " ";
        Matcher matcher = pattern.matcher(winningNumbersString);
        while (matcher.find()) {
            String winningNumber = matcher.group();
            Pattern winNumberPattern = Pattern.compile("\\D" + winningNumber + "\\D");
            Matcher winNumberMatcher = winNumberPattern.matcher(numbersPresentString);
            if (winNumberMatcher.find()) {
                if (value < 1) {
                    value++;
                } else {
                    value = value * 2;
                }
            }
        }
        return value;
    }
}
