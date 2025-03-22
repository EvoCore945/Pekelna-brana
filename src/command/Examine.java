package command;
import characters.NPC;
import World.Item;
import World.Location;
import World.WorldMap;
import java.util.ArrayList;
public class Examine extends Command {

    private Location location;
    private WorldMap world = new WorldMap();
    ArrayList<Item> itemsInRooms = new ArrayList<>();


    public Examine(Location location) {
        this.location = location;
    }


    public String execute() {
        ItemsInRoom();

        if (world.getCurrentPosition2() == null) {
            return "Unknown location.";
        }

        return "You are in: " + world.getCurrentPosition2() + ". ";

    }
    public void ItemsInRoom(){
        WorldMap worldMap = new WorldMap();
        int currentPosition = worldMap.getCurrentPosition();

        ArrayList<Item> items = new ArrayList<>();
        switch (currentPosition) {
            case 0 :
               break;

            case 1 :
                System.out.println("Items in this room:");
                items.add(new Item("Zbrojnice_Acces_Card1", "Can open Zbrojnice."));
                WorldMap.permission3 = true;

                break;

            case 2 :
                items.add( new Item("Shotgun", "Increases your damage"));

                break;

            case 3 :
                items.add(new Item("database","LORE"));
                items.add(new Item("Serverovna_Access_Card2", "Can open Labroratoř"));
                WorldMap.permission4 = true;
                break;

            case 4 :
                items.add(new Item("Permission_BossRoom", "This will gave you access to Section X0-7"));

                WorldMap.permission1 = true;
                break;

            case 5 :
                items.add(new Item("Permission_PortalRoom", "This will gave you access to Portalová Komora"));
                WorldMap.permission2 = true;
                break;

            case 6 :
                items.add(new Item("Strojovna_Access_Card3", "This card will gave you access to Strojovna"));
                NPC npc = new NPC("Dr.Caldwell", "");
                WorldMap.permission5 = true;

                break;

            case 7 :

                break;

            case 8 :

                break;

            default:
        }

        for (Item item : items){

            if (!itemsInRooms.contains(item) ){
                itemsInRooms.add(item);
                System.out.println(item);

            }
        }
    }

    public boolean exit() {
        return false;
    }
}


