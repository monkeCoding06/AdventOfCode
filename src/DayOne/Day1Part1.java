package DayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Part1 {
    @SuppressWarnings("DuplicatedCode")
    private int extractNumber(String data) {
        String firstNumber = String.valueOf(data.charAt(0));
        String secondNumber = String.valueOf(data.charAt(data.length() - 1));
        if (data.length() < 2) {
            secondNumber = firstNumber;
        }
        String fullNumber = firstNumber + secondNumber;
        return Integer.parseInt(fullNumber);
    }

    protected int getResult() throws FileNotFoundException {
        int sum = 0;
        File inputDay1 = new File("src\\DayOne\\advent1.txt");
        Scanner scannerInput = new Scanner(inputDay1);
        while (scannerInput.hasNextLine()) {
            String data = scannerInput.nextLine();
            data = data.replaceAll("\\D", "");
            int number = extractNumber(data);
            sum += number;
        }
        return sum;
    }

    public void run() throws FileNotFoundException {
        int sum = getResult();
        System.out.println("day one solution: " + sum);
    }
}