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
    public void ItemsInRoom(){
        int currentPosition = WorldMap.getCurrentPosition();
        if(!roomItems.containsKey(currentPosition)){
            ArrayList<Item> items = new ArrayList<>();


        switch (currentPosition) {
            case 0 :
               break;

            case 1 :
               items.add(new Item("Zbrojnice_Acces_Card1", "Can open Zbrojnice. (Cant be used)", CARD));
                WorldMap.permission3 = true;

                break;

            case 2 :
                items.add( new Item("Shotgun", "Increases your damage when used", WEAPON));

                break;

            case 3 :
                items.add(new Item("Syringe", "Increases your health when used", HEAL));
                items.add(new Item("database","LORE", LOG));
                items.add(new Item("Serverovna_Access_Card2", "Can open Labroratoř (Cant be used)",CARD));
                WorldMap.permission4 = true;
                break;

            case 4 :
                items.add( new Item("LMG", "Increases your damage when used", WEAPON));
                items.add(new Item("MedKit", "Increases your health when used", HEAL));
                items.add(new Item("Permission_BossRoom", "This will gave you access to Section X0-7 (Cant be used)",CARD));

                WorldMap.permission1 = true;
                break;

            case 5 :
                items.add(new Item("Permission_PortalRoom", "This will gave you access to Portalová Komora (Cant be used)",CARD));
                WorldMap.permission2 = true;
                break;

            case 6 :
                items.add( new Item("Pistol", "Increases your damage when used", WEAPON));
                System.out.println("There could be someone hiding in this room...");
                items.add(new Item("MedKit", "Increases your health when used", HEAL));
                items.add(new Item("Strojovna_Access_Card3", "This card will gave you access to Strojovna (Cant be used)",CARD));
                WorldMap.permission5 = true;
                break;

            case 7 :
                items.add(new Item("MedKit", "Increases your health when used", HEAL));
                break;

            case 8 :
                items.add( new Item("SMG", "Increases your damage when used", WEAPON));
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


