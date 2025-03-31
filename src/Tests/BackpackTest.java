package Tests;
import World.Item;
import command.Backpack;

import static World.ItemType.HEAL;
import static World.ItemType.WEAPON;
import static org.junit.jupiter.api.Assertions.*;
public class BackpackTest {
    @org.junit.jupiter.api.Test
    void getBackpack(){

        Backpack backpack = new Backpack();
        backpack.addItemToBackpack(( new Item("Pistol", "Increases your damage when used", WEAPON,false)));
        backpack.addItemToBackpack((new Item("MedKit", "Increases your health when used", HEAL,false)));
        assertEquals("Pistol",Backpack.getBackpack().get(0).getName());



    }

}
