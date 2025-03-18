package World;

import command.Backpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class WorldMap {
    private static HashMap<Integer, Location> world = new HashMap<>();
    private int start = 0;
    private int currentPosition = start;
   public static boolean hasAccessCard;


    public boolean loadMap(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/map.txt"))){
            String part;
            while ((part = br.readLine()) != null){
                String[] parts = part.split(";");

                if (parts.length < 6) {
                    System.out.println("Invalid line format: " + part);
                    continue;
                }

                Location location = new Location(parts[0], Integer.parseInt(parts[0]), Arrays.copyOfRange(parts,2,6));
                world.put(Integer.valueOf(parts[0]), location);
            }
            return  true;
        } catch (IOException e) {
            System.out.println("Error while loading the map: " + e.getMessage());
           return  false;
        }
    }
    public Location getCurrentPosition(){
        return world.get(currentPosition);
    }

    public HashMap<Integer, Location> getWorld(){
        return world;

    }
    public String move(String direction){
        int indexOFdirection;
        switch(direction.toLowerCase()){

            case "north":
                indexOFdirection = 0;
                break;
            case "south":
                indexOFdirection = 1;
                break;
            case "East":
                indexOFdirection = 2;
                break;
            case "West":
                indexOFdirection = 3;
                break;
            default:
                return "Invalid direction. Type only these directions: " + " north,  south,  east, west";
        }
        int newLocation = world.get(currentPosition).getLocations()[indexOFdirection];
        if(newLocation == -1){
            return "You cant go that way!";

        }else{
            if (currentPosition == 0 && hasAccessCard==false) {
                return "You dont have a Item for this Room!";
            }
            currentPosition = newLocation;
            return "You moved to " + world.get(currentPosition).getName();
        }
    }

    public boolean unlockDoor(String doorName, Backpack backpack) {

        if (backpack.hasItem("Access card")) {
            System.out.println("Doors " + doorName + " were succesfully opened!");
            return true;
        } else {
            System.out.println("You dont have the right access card for this door!");
            return false;
        }
    }
}


