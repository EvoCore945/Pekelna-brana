package Tests;
import static org.junit.jupiter.api.Assertions.*;

import characters.Player;
import command.PlayerDescription;

public class PlayerDescriptionTest {
    @org.junit.jupiter.api.Test
    void execute(){
        Player player = Player.getInstance();
        PlayerDescription pl = new PlayerDescription();
        assertEquals(player.toString(), pl.execute());
    }
}
