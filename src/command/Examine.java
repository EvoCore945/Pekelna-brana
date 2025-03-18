package command;

import World.Item;
import World.Location;
import World.WorldMap;
import java.util.ArrayList;
public class Examine extends Command {

    private Location location;
    ArrayList<Item> itemsInRooms = new ArrayList<>();

    public Examine(Location location) {
        this.location = location;
    }

    public String execute() {

        if (location == null) {
            return "Unknown location.";
        }
        return "You are in: " + location.getName() + ". ";

    }
    public String ItemsInRoom(){
        WorldMap worldMap = new WorldMap();
        int currentPosition = worldMap.getCurrentPosition();

        switch (currentPosition) {
            case 0 :
                itemsInRooms.add(null);
                return "You are in Hangar.";

            case 1 :
            itemsInRooms.add(new Item("Zbrojnice_Acces_Card1", "Can open Zbrojnice."));

                return "You are in Sklad Paliva.";

            case 2 :
                itemsInRooms.add(new Item("Shotgun", "Increases your damage"));

                return "You are in Zbrojnice.";

            case 3 :
                itemsInRooms.add(new Item("database","LORE"));
                itemsInRooms.add(new Item("Serverovna_Acces_Card2", "Can open Labrorator"));
                return "You are in Serverovna.";

            case 4 :
                itemsInRooms.add(new Item("Permission_BossRoom", "This will gave you acces to Section X0-7"));

                WorldMap.permission1 = true;
                return "You are in Strojovna.";

            case 5 :
                itemsInRooms.add(new Item("Permission_PortalRoom", "This will gave you acces to Portalova Komora"));

                WorldMap.permission2 = true;
                return "You are in Velín.";

            case 6 :
                itemsInRooms.add(new Item("", ""));

                return "You are in Laboratoř.";

            case 7 :
                itemsInRooms.add(new Item("", ""));

                return "You are in Sekce X-07.";

            case 8 :
                itemsInRooms.add(new Item("", ""));

                return "You are in Portálová Komora.";

            default:
        }
        return"";
    }



    public boolean exit() {
        return false;
    }
}


