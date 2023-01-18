package klausur_21_22_1;

import java.io.*;

public class Speicher implements SpeicherInterface{

    private static final int KAPAZITAET = 5;
    private static final String FILE_PATH = "src/klausur_21_22_1/output/output.txt";

    private final String[] allMessages = new String[KAPAZITAET];
    private SpeicherListener speicherListener = null;
    private int nextIndex = 0;

    public Speicher(SpeicherListener speicherListener) {
        this.speicherListener = speicherListener;
    }

    public Speicher() {
    }

    @Override
    public void addMessage(String message) {
        if (speicherListener != null && allMessages[this.nextIndex] != null)
            speicherListener.notifyOverWrite(allMessages[this.nextIndex]);
        this.allMessages[this.nextIndex] = message;
        this.updateIndex();
    }

    @Override
    public void deleteAllMessages() {
        for (int i = 0; i < KAPAZITAET; i++) {
            allMessages[i] = null;
        }
    }

    private void updateIndex() {
        if (this.nextIndex == KAPAZITAET - 1) this.nextIndex = 0;
        else this.nextIndex++;
    }

    @Override
    public void persist() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH));

            for (int i = 0; i < KAPAZITAET; i++) {
                if (allMessages[i] != null) {
                    bufferedWriter.write(allMessages[i]);
                    bufferedWriter.newLine();
                } else break;
            }

            bufferedWriter.close();
        } catch (IOException ignored) {
        }
    }

    @Override
    public void reload() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
            for (int i = 0; i < KAPAZITAET; i++) {
                allMessages[i] = bufferedReader.readLine();
                System.out.println(allMessages[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getMessageAtIndex(int i) throws Exception {
        if (i < 0 || i > KAPAZITAET - 1) throw new Exception("Invalid index");
        return this.allMessages[i];
    }

}
