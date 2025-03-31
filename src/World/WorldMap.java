package World;
import characters.Monster;
import characters.NPC;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class WorldMap {
    private static HashMap<Integer, Location> world = new HashMap<>();
    private static int start = 0;
    private static int currentPosition = start;
    public static boolean permission1 = false;
    public static boolean permission2 = false;
    public static boolean permission3 = false;
    public static boolean permission4 = false;
    public static boolean permission5 = false;

    /**
     * Loads all the rooms on the map from a file
     */
    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/map.txt"))) {
            String part;
            while ((part = br.readLine()) != null) {
                String[] parts = part.split(";");


                Location location = new Location(parts[1], Integer.parseInt(parts[0]), Arrays.copyOfRange(parts, 2, 6));
                world.put(Integer.valueOf(parts[0]), location);
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error while loading the map: " + e.getMessage());
            return false;
        }
    }

    public Location getCurrentPosition2() {
        return world.get(currentPosition);
    }

    static public int getCurrentPosition() {
        return currentPosition;
    }

    public HashMap<Integer, Location> getWorld() {
        return world;

    }

    /**
     * Processes player movement by checking the given direction and verifying if movement is allowed and ensuring the player has the necessary permissions for restricted areas
     * If valid, it updates the player's position; otherwise, it returns an appropriate error message.
     * author: ChatGPT
     */
    public String move(String direction) {
        int indexOFdirection;
        switch (direction.toLowerCase()) {

            case "north":
                indexOFdirection = 0;
                break;
            case "south":
                indexOFdirection = 1;
                break;
            case "east":
                indexOFdirection = 2;
                break;
            case "west":
                indexOFdirection = 3;
                break;
            default:
                return "Invalid direction. Type only these directions: " + " north,  south,  east, west";
        }
        int newLocation = world.get(currentPosition).getLocations()[indexOFdirection];
        if (newLocation == -1) {
            return "You cant go that way!";

        } else {
            if (currentPosition == 0 && !permission2 && direction.equals("north")) {

                return "You dont have a permission 2 to open Portalova komora!";
            }
            if (currentPosition == 0 && !permission3 && direction.equals("west")) {
                return "You need a Permission 3 to open Zbrojnice!";
            }
            if (currentPosition == 6 && !permission1 && direction.equals("south")) {
                return "You need a Permission 1 to open Sekce X0-7";
            }
            if (currentPosition == 0 && !permission4 && direction.equals("east")) {
                return "You need a Permission 4 to open Laborator!";
            }
            if (currentPosition == 2 && !permission5 && direction.equals("west")) {
                return "You need a Permission 5 to open Strojovna";
            }

            currentPosition = newLocation;
            return "You moved to " + world.get(currentPosition).getName();
        }
    }

    Random rd = new Random();

    /**
     * Adds various monsters to specific locations with randomized health and damage values
     */
    public void initialzizeMonsters() {
        Monster.addMonster(2, new Monster("RudyDemon", rd.nextInt(10, 30), rd.nextInt(5,10) ));
        Monster.addMonster(6, new Monster("Mutant", rd.nextInt(30,50), rd.nextInt(10,15)));
        Monster.addMonster(4, new Monster("Vidlicka", rd.nextInt(50,80), rd.nextInt(20,25)));
        Monster.addMonster(7, new Monster("OmegaX-07 (Boss)", 150, 50));
    }

    /**
     * Adds NPCs with predefined dialogue to certain locations.
     */
    public void initializeNPCs() {
        NPC.addNPC(6,new NPC("DR.Caldwell", "Hi, I am a doctor who have worked here before the chaos happened.\nYou have to find a key to close the Portal between ours and their dark world.\n I believe you will find the key in the section X0-7, but I am always hearing some strange sounds from there.\n THERE MIGHT BE SOMETHING... Anyway here is level 3 access card."));
        NPC.addNPC(2,new NPC("Soldier", "Go away please!\nThey are everywhere!!\nYou have to go... \nTake this shotgun...\nYou will need it...uhh.."));

    }

}




