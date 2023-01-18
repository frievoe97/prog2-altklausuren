package klausur_21_22_2;

import java.util.Scanner;

public class UI {

    public static void main(String[] args) {

        CalculatorImplementation calculator = new CalculatorImplementation();
        String lastResult = null;
        boolean exitCalculator = false;

        Scanner scanner = new Scanner(System.in);

        while (!exitCalculator) {
            try {
                String input = scanner.nextLine();

                if (input.equals("exit")) {
                    exitCalculator = true;
                    break;
                }

                String[] inputArray = input.split(" ");

                if (inputArray.length == 3) {
                    lastResult = String.valueOf(calculator.calculate(inputArray[0], inputArray[1], inputArray[2]));
                    System.out.println(lastResult);
                } else if (inputArray.length == 2) {
                    lastResult = String.valueOf(calculator.calculate(inputArray[0], inputArray[1], lastResult));
                    System.out.println(lastResult);
                }
            } catch (CalculatorException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
}
