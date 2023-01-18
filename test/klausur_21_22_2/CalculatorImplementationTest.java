package klausur_21_22_2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorImplementationTest {

    @Test
    public void calculate() throws CalculatorException {
        Calculator calculator = new CalculatorImplementation();

        Assert.assertEquals(3, calculator.calculate("+", "1", "2"));
    }
}