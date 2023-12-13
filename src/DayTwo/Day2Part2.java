package DayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part2 {
    File inputDay2 = new File("C:\\Users\\lkohlfuerst\\IntelliJProjects\\advent1\\src\\DayTwo\\advent2.txt");

    public void run() throws FileNotFoundException {
        Scanner scannerInput = new Scanner(inputDay2);
        while (scannerInput.hasNextLine()) {
            String data = scannerInput.nextLine();
            System.out.println(data);
        }
    }
}