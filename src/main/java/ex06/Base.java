package ex06;

/*
Exercise 6 - Retirement Calculator
Your computer knows what the current year is, which means you can incorporate that into your programs. You just have to figure out how your programming language can provide you with that information.

Create a program that determines how many years you have left until retirement and the year you can retire. It should prompt for your current age and the age you want to retire and display the output as shown in the example that follows.

Example Output

What is your current age? 25
At what age would you like to retire? 65
You have 40 years left until you can retire.
It's 2015, so you can retire in 2055.

Constraints

Again, be sure to convert the input to numerical data before doing any math.
Don’t hard-code the current year into your program. Get it from the system time via your programming language.

 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Base {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Base myBase = new Base();

        String inputAge = myBase.inputAge();
        String inputRetire = myBase.inputRetirementAge();

        int convertAge = Integer.parseInt(inputAge);
        int convertRetire = Integer.parseInt(inputRetire);

        int resultAge = myBase.calculateRetirementAge(convertAge, convertRetire);
        myBase.printRetirementAge(resultAge);
        myBase.printActualRetirementDate(resultAge);
    }

    private void printActualRetirementDate(int resultAge) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        int dateActual = Integer.parseInt(formatter.format(date));

        System.out.print("It's ");
        System.out.print(formatter.format(date));
        System.out.print(", so you can retire in ");

        int i = (int) new Date().getTime();
        int resYear = dateActual + resultAge;
        System.out.println(resYear);
    }

    private void printRetirementAge(int resultAge) {
        System.out.println("You have " + resultAge + " years left until you can retire.");
    }

    private int calculateRetirementAge(int convertAge, int convertRetire) {
        int res = convertRetire - convertAge;
        return res;
    }


    private String inputRetirementAge() {
        System.out.print("At what age would you like to retire? ");
        String retire = input.nextLine();

        return retire;
    }

    private String inputAge() {
        System.out.print("What is your current age? ");
        String age = input.nextLine();

        return age;

    }

}
