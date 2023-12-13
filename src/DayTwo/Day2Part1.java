package DayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2Part1 {

    private static final Pattern notAllowed = Pattern.compile("1[^0-4] blue|1[^0-3] green|1[^0-2] red");
    private static final Pattern gameId = Pattern.compile("Game (\\d+)");

    protected boolean checkIfGameWasPossible(String data) {
        Matcher matcher = notAllowed.matcher(data);
        return !matcher.find();
    }

    protected int getValidGameId(String data) {
        if (checkIfGameWasPossible(data)) {
            Matcher matcher = gameId.matcher(data);
            matcher.find();
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

    protected void run() throws FileNotFoundException {
        int sum = 0;
        File inputDay2 = new File("C:\\Users\\lkohlfuerst\\IntelliJProjects\\advent1\\src\\DayTwo\\advent2.txt");
        Scanner scannerInput = new Scanner(inputDay2);
        while (scannerInput.hasNextLine()) {
            String data = scannerInput.nextLine();
            int number = getValidGameId(data);
            sum += number;
        }
        System.out.println("day two solution: " + sum);
    }
}
