package klausur_22_1;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        try {
            System.out.println(calculator.substraction(Integer.MAX_VALUE, Integer.MAX_VALUE));

            System.out.println(calculator.substraction(Integer.MAX_VALUE, 0));
            System.out.println(calculator.substraction(Integer.MAX_VALUE, -1));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
