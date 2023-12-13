package DayOne;

import java.io.FileNotFoundException;

public class DayOneMain {
    public void run() throws FileNotFoundException {
        Day1Part1 day1 = new Day1Part1();
        Day1Part2 day1part2 = new Day1Part2();
        day1.run();
        day1part2.run();
    }
}
