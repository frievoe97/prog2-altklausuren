package klausur_21_22_1;

public class Main {

    public static void main(String[] args) {

        SpeicherListener speicherListener = new SpeicherListener();

        Speicher speicher = new Speicher(speicherListener);

        speicher.addMessage("1");
        speicher.addMessage("2");
        speicher.addMessage("3");
        speicher.addMessage("4");
        speicher.addMessage("5");
        speicher.addMessage("6");
        speicher.addMessage("7");
        speicher.addMessage("8");





    }

}
