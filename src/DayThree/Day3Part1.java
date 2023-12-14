package DayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3Part1 {

    protected int getResult() throws FileNotFoundException {
        int sum = 0;
        File inputDay2 = new File("src\\DayTwo\\advent3.txt");
        Scanner scannerInput = new Scanner(inputDay2);
        while (scannerInput.hasNextLine()) {
            String data = scannerInput.nextLine();
            System.out.println(data);
        }
        return sum;
    }

    protected void run() throws FileNotFoundException {
        int sum = getResult();
        System.out.println("day two solution: " + sum);
    }
}