package klausur_19_20_1;

public class Main {

    public static void main(String[] args) {

        try {
            Calculator calculator = new Calculator();
            System.out.println(calculator.getResult());
            calculator.redoLastOperation();
            System.out.println(calculator.getResult());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
