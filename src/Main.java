import DayOne.*;
import DayTwo.*;
import DayThree.*;

import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DayOneMain dayOne = new DayOneMain();
        dayOne.run();

        DayTwoMain dayTwo = new DayTwoMain();
        dayTwo.run();

        DayThreeMain dayThree = new DayThreeMain();
        dayThree.run();

    }
}