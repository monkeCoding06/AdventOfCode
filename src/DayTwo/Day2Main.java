package DayTwo;

import java.io.FileNotFoundException;

public class Day2Main {
    public void run() throws FileNotFoundException {
        Day2Part1 day2 = new Day2Part1();
        Day2Part2 day2Part2 = new Day2Part2();
        day2.run();
        day2Part2.run();
    }
}
