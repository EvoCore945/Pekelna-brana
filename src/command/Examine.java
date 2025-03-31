package command;
import World.Item;
import World.Location;
import World.WorldMap;
import java.util.ArrayList;
import java.util.HashMap;

import static World.ItemType.*;

public class Examine extends Command {

    private Location location;
    private WorldMap world = new WorldMap();;
    private HashMap<Integer,ArrayList<Item>> roomItems = new HashMap<>();


    public Examine(Location location) {
        this.location = location;
    }

    public String execute() {
        System.out.println("You are in: " + world.getCurrentPosition2() + ". ");

        ItemsInRoom();

        if (world.getCurrentPosition2() == null) {
            return "Unknown location.";
        }

        return "";

    }
    /**
 * Manages the items in the current room based on the player's position.
 * This method populates the room with items if it hasn't been visited before,
 * adds the items to the player's backpack, and updates the game state accordingly.
 * It also handles special cases for each room, such as granting permissions or
 * displaying specific logs.
 */
public void ItemsInRoom() {
    int currentPosition = WorldMap.getCurrentPosition();
    if(!roomItems.containsKey(currentPosition)){
        ArrayList<Item> items = new ArrayList<>();

        switch (currentPosition) {
            case 0 :
               break;

            case 1 :
               items.add(new Item("Zbrojnice_Acces_Card1", "Can open Zbrojnice. (Cant be used)", CARD,false));
                WorldMap.permission3 = true;

                break;

            case 2 :
                System.out.println("There could be someone in this room you could talk to...");
                items.add( new Item("Shotgun", "Increases your damage when used", WEAPON,false));

                break;

            case 3 :
                items.add(new Item("Syringe", "Increases your health when used", HEAL,false));
                items.add(new Item("LOG-Entry#1","The experiment was not supposed to go this way...\nWe followed all protocols, but the energy output exceeded our estimates.\nThe portal became unstable within seconds. \nWe lost control...", LOG,true));
                items.add(new Item("Serverovna_Access_Card2", "Can open Labroratoř (Cant be used)",CARD,false));
                WorldMap.permission4 = true;
                break;

            case 4 :
                items.add(new Item("LOG-Entry#2","The first anomaly appeared in Section X-07 - something emerged... something not from our world.\nSecurity forces were overrun in minutes.\nMost of the scientists tried to escape, but the lockdown protocols trapped them inside.", LOG,true));
                items.add( new Item("LMG", "Increases your damage when used", WEAPON,false));
                items.add(new Item("MedKit", "Increases your health when used", HEAL,false));
                items.add(new Item("Permission_BossRoom", "This will gave you access to Section X0-7 (Cant be used)",CARD,false));

                WorldMap.permission1 = true;
                break;

            case 5 :
                items.add(new Item("Permission_PortalRoom", "This will gave you access to Portalová Komora (Cant be used)",CARD,false));
                WorldMap.permission2 = true;
                break;

            case 6 :
                items.add( new Item("Pistol", "Increases your damage when used", WEAPON,false));
                System.out.println("There could be someone hiding in this room...");
                items.add(new Item("MedKit", "Increases your health when used", HEAL,false));
                items.add(new Item("Strojovna_Access_Card3", "This card will gave you access to Strojovna (Cant be used)",CARD,false));
                WorldMap.permission5 = true;
                break;

            case 7 :
                items.add(new Item("LOG-Entry#3","I can hear them... screams echo through the corridors.\nThe emergency systems are failing one by one.\nI don't know how much time I have left, but if anyone finds this log... \nThe ELECTRO STABILIZER is the KEY to close the portal!", LOG,true));
                items.add(new Item("MedKit", "Increases your health when used", HEAL,false));
                items.add( new Item("SMG", "Increases your damage when used", WEAPON,false));
                items.add( new Item("RocketLauncher", "Increases your damage when used", WEAPON,false));
                break;

            case 8 :
                System.out.println("you are standing right in front of the terminal that can close this huge Portal. You must use the Electric Stabilizer to close the portal!");
                break;
            default:
                return;
        }
        roomItems.put(currentPosition,items);
    }

    ArrayList<Item> itemsInRooms = roomItems.get(currentPosition);

    if (itemsInRooms != null && !itemsInRooms.isEmpty()){
        for (Item item : new ArrayList<>(itemsInRooms)) {
            Backpack.addItemToBackpack(item);
            System.out.println(item + " > > > was added to your backpack!");
        }
        itemsInRooms.clear();
    }else{
        System.out.println("There are no items left in this room.");
    }
}
    public boolean exit() {
        return false;
    }
}


