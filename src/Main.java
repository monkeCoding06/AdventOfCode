import DayOne.*;
import DayTwo.*;

import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DayOneMain dayOne = new DayOneMain();
        dayOne.run();

        DayTwoMain dayTwo = new DayTwoMain();
        dayTwo.run();
    }
}