package Tests;
import World.Item;

import java.util.Random;

import static World.ItemType.WEAPON;
import static org.junit.Assert.assertEquals;

 class ItemTest {
     @org.junit.jupiter.api.Test
    void getName(){
        Item item = new Item("Shotgun", "Increases your damage when used", WEAPON,false);
        assertEquals("Shotgun", item.getName());
    }
     @org.junit.jupiter.api.Test
    void getType(){
        Item item = new Item("Shotgun", "Increases your damage when used", WEAPON,false);
        assertEquals(WEAPON, item.getType());
    }
     @org.junit.jupiter.api.Test
    void getDescription(){
        Item item = new Item("Shotgun", "Increases your damage when used", WEAPON,false);
        assertEquals(WEAPON, item.getDescription());
    }
     @org.junit.jupiter.api.Test
    void getBonusHealth(){
        Random rd = new Random();
        Item item = new Item("Shotgun", "Increases your damage when used", WEAPON,false);
        assertEquals(rd.nextInt(10, 20), item.getBonusHealth());
    }
     @org.junit.jupiter.api.Test
    void getBonusDamage(){
        Random rd = new Random();
        Item item = new Item("Shotgun", "Increases your damage when used", WEAPON,false);
        assertEquals(rd.nextInt(5, 10), item.getBonusDamage());
    }


}
