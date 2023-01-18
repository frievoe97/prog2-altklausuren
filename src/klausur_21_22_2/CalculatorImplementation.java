package klausur_21_22_2;

public final class CalculatorImplementation implements Calculator {

    private CalculatorOperations calculatorOperations;

    public int calculate(String s, String s1, String s2) throws CalculatorException {

        if (operationIsNotValid(s)) throw new CalculatorException("Operation not valid");

        try {
            int value1 = Integer.parseInt(s1);

            if (s2 == null) throw new CalculatorException("No last Value");

            int value2 = Integer.parseInt(s2);

            if (numberIsNegative(value1)) throw new CalculatorException("Number is negativ");
            if (numberIsNegative(value2)) throw new CalculatorException("Number is negativ");

            if (!calculationIsValid(value1, value2)) throw new CalculatorException("Not valid");

            switch (calculatorOperations) {
                case PLUS -> {
                    return value1 + value2;
                }
                case MINUS -> {
                    return value1 - value2;
                }
                default -> {throw new CalculatorException("Error");}
            }

        } catch (NumberFormatException e) {
            throw new CalculatorException("Wrong number");
        }
    }

    private boolean numberIsNegative(int value1) {
        return value1 < 0;
    }

    private boolean operationIsNotValid(String s) {
        switch (s) {
            case "+" -> {
                this.calculatorOperations = CalculatorOperations.PLUS;
                return false;
            }
            case "-" -> {
                this.calculatorOperations = CalculatorOperations.MINUS;
                return false;
            }
            default -> {
                return true;
            }
        }
    }

    private boolean calculationIsValid(int number1, int number2) {
        int maxValueNumber2 = Integer.MAX_VALUE - number1;
        return number2 <= maxValueNumber2;
    }
}
