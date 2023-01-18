package klausur_21_22_1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpeicherTest {

    @Test
    public void addMessage() throws Exception {
        Speicher speicher = new Speicher();
        speicher.addMessage("1");
        speicher.addMessage("2");
        speicher.addMessage("3");
        speicher.addMessage("4");
        speicher.addMessage("5");

        Assert.assertEquals("1", speicher.getMessageAtIndex(0));
        Assert.assertEquals("2", speicher.getMessageAtIndex(1));
        Assert.assertEquals("3", speicher.getMessageAtIndex(2));
        Assert.assertEquals("4", speicher.getMessageAtIndex(3));
        Assert.assertEquals("5", speicher.getMessageAtIndex(4));

        speicher.addMessage("5");

        Assert.assertEquals("5", speicher.getMessageAtIndex(0));
        Assert.assertEquals("2", speicher.getMessageAtIndex(1));
        Assert.assertEquals("3", speicher.getMessageAtIndex(2));
        Assert.assertEquals("4", speicher.getMessageAtIndex(3));
        Assert.assertEquals("5", speicher.getMessageAtIndex(4));
    }

    @Test
    public void deleteAllMessages() {
    }

    @Test
    public void persist() {
    }

    @Test
    public void reload() {
    }
}