package DayFour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4Part1 {
    Pattern numberPattern = Pattern.compile("\\d+");

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

    protected int getCardValue(String data) {
        int value = 0;
        String winningNumbersString = data.substring(data.indexOf(':') + 1, data.indexOf('|'));
        String numbersPresentString = data.substring(data.indexOf('|') + 1) + " ";
        Matcher winningNumberMatcher = numberPattern.matcher(winningNumbersString);
        while (winningNumberMatcher.find()) {
            Pattern winNumberPattern = Pattern.compile("\\D" + winningNumberMatcher.group() + "\\D");
            Matcher winNumberMatcher = winNumberPattern.matcher(numbersPresentString);
            if (winNumberMatcher.find()) {
                value = (value < 1) ? 1 : value * 2;
            }
        }
        return value;
    }

    public void run() throws FileNotFoundException {
        int sum = getResult();
        System.out.println("day four solution: " + sum);
    }
}