package klausur_22_1;

public final class Calculator {

    private int lastValue = 0;
    private long lastTime = System.currentTimeMillis();

    public int substraction(int minuend, int subtrahend) throws Exception {
        if (checkIfLastOperationIsMoreThanFiveSecondsAgo())
            throw new CalculatorException("Last calculation is more than five seconds ago");

        if (calculationIsNotValid(minuend, subtrahend))
            throw new CalculatorException("The datatype Integer can't calculate these numbers. (" + minuend + " - " + subtrahend + ")");

        lastValue = minuend - subtrahend;
        lastTime = System.currentTimeMillis();

        return lastValue;
    }

    public int substraction(int subtrahend) throws Exception {
        if (checkIfLastOperationIsMoreThanFiveSecondsAgo())
            throw new CalculatorException("Last calculation is more than five seconds ago");

        if (calculationIsNotValid(this.lastValue, subtrahend))
            throw new CalculatorException("The datatype Integer can't calculate these numbers. (" + this.lastValue + " - " + subtrahend + ")");

        this.lastValue -= subtrahend;
        this.lastTime = System.currentTimeMillis();

        return lastValue;
    }

    private boolean checkIfLastOperationIsMoreThanFiveSecondsAgo() {
        return (lastTime + 5000) <= System.currentTimeMillis();
    }

    private boolean calculationIsNotValid(int minuend, int subtrahend) {

        if (minuend < 0 && subtrahend > 0) {
            int maxValueSubtrahend = Integer.MIN_VALUE - minuend;
            return subtrahend > Math.abs(maxValueSubtrahend);
        } else if (minuend > 0 && subtrahend < 0) {
            int maxValueSubtrahend = Integer.MAX_VALUE - minuend;
            return maxValueSubtrahend < Math.abs(subtrahend);
        }

        return false;
    }
}
