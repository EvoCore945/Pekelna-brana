package Tests;
import static org.junit.jupiter.api.Assertions.*;
import command.Talk;
import org.junit.jupiter.api.Test;
public class TalkTest {
    @org.junit.jupiter.api.Test
    void execute(){
        Talk t = new Talk();
        assertEquals("There's no one here to talk to.",t.execute());
    }
}
