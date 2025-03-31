package Tests;
import command.Help;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelpTest {
    @org.junit.jupiter.api.Test
    void execute(){
        Help help = new Help();
        assertEquals("You need to find Access Cards in the room to open new locations.\nTry to kill every enemy on the map for bonus health and damage.\nYou need a special item to finish the game.",help.execute());
    }
}
