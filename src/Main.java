import DayFour.*;
import DayOne.*;
import DayTwo.*;
import DayThree.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Day1Main dayOne = new Day1Main();
        dayOne.run();

        Day2Main dayTwo = new Day2Main();
        dayTwo.run();

        Day3Main dayThree = new Day3Main();
        dayThree.run();

        Day4Main dayFour = new Day4Main();
        dayFour.run();
    }
}