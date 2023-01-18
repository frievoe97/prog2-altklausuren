package klausur_21_22_1;

public interface SpeicherInterface {

    void addMessage(String message);
    void deleteAllMessages();
    void persist();
    void reload();
    String getMessageAtIndex(int i) throws Exception;
}
