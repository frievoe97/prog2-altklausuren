package klausur_22_1;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private Calculator createNewCalculator() {
        return new Calculator();
    }

    @Test(expected = CalculatorException.class)
    public void testSubstraction1() throws Exception {
        Calculator calculator = createNewCalculator();
        calculator.substraction(Integer.MIN_VALUE, 1);
    }

    @Test
    public void testSubstraction2() throws Exception {
        Calculator calculator = createNewCalculator();
        calculator.substraction(Integer.MIN_VALUE, 0);
    }

    @Test(expected = CalculatorException.class)
    public void testSubstraction3() throws Exception {
        Calculator calculator = createNewCalculator();
        calculator.substraction(Integer.MAX_VALUE, -1);
    }

    @Test
    public void testSubstraction4() throws Exception {
        Calculator calculator = createNewCalculator();
        calculator.substraction(Integer.MAX_VALUE, 0);
    }

    @Test
    public void testSubstraction5() throws Exception {
        Calculator calculator = createNewCalculator();
        calculator.substraction(100, 50);
        Assert.assertEquals(50, calculator.substraction(0));
    }

    @Test
    public void testSubstraction6() throws Exception {
        Calculator calculator = createNewCalculator();
        for (int i = 0; i < 10; i++) {
            calculator.substraction(100, 50);
            Thread.sleep(4900);
        }
    }

    @Test(expected = CalculatorException.class)
    public void testSubstraction7() throws Exception {
        Calculator calculator = createNewCalculator();
        for (int i = 0; i < 10; i++) {
            calculator.substraction(100, 50);
            Thread.sleep(5000);
        }
    }
}