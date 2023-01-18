package klausur_19_20_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Calculator {

    private static final String FILE_PATH = "src/klausur_19_20_1/output/output.txt";

    private final ArrayList<Integer> allInputs = new ArrayList<>();
    private int result = 0;

    public Calculator() {
        this.reloadAllInputs();
    }

    public void add(int number) {
        this.allInputs.add(number);
        this.result += number;
        this.saveAllInputs();

    }

    public void sub(int number) {
        this.add(-number);
    }

    public void resetResult() {
        this.result = 0;
        this.allInputs.clear();
    }

    public int getResult() {
        return this.result;
    }

    public void redoLastOperation() throws Exception {
        if (allInputs.size() == 0) throw new Exception("No last result");
        result -= allInputs.get(allInputs.size() - 1);
        allInputs.remove(allInputs.size() - 1);
    }

    private void saveAllInputs() {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH));

            for (Integer allInput : allInputs) {
                bufferedWriter.write(String.valueOf(allInput));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    public void reloadAllInputs() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
            String line;


            line = bufferedReader.readLine();

            while (line != null) {
                allInputs.add(Integer.parseInt(line));
                line = bufferedReader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Integer allInput : allInputs) {
            this.result += allInput;
        }



    }



}
