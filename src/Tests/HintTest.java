package Tests;
import command.Hint;

import static org.junit.jupiter.api.Assertions.*;
public class HintTest {

    @org.junit.jupiter.api.Test
    void excecute(){
        Hint hint = new Hint();
        assertEquals("Commands you can type:\n" +
                "- go [direction] --> move to the location\n" +
                "- backpack --> show or use your items in backpack\n" +
                "- hint --> all commands\n" +
                "- help --> if you are lost\n" +
                "- player --> your stats\n" +
                "- examine [room] --> search the room for items\n" +
                "- pickUp [item] --> pick up a item\n" +
                "- talk [NPC] --> talk with NPC\n" +
                "- shoot [Enemy] --> Start the fight with a monster\n" +
                "- end [PekelnaBrana] --> Close the game\n",hint.execute());



    }
}
