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
   public static boolean permission1 = false;
   public static boolean permission2 = false;


    public boolean loadMap(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/map.txt"))){
            String part;
            while ((part = br.readLine()) != null){
                String[] parts = part.split(";");


                Location location = new Location(parts[1], Integer.parseInt(parts[0]), Arrays.copyOfRange(parts,2,6));
                world.put(Integer.valueOf(parts[0]), location);
            }
            return  true;
        } catch (IOException e) {
            System.out.println("Error while loading the map: " + e.getMessage());
           return  false;
        }
    }
    public Location getCurrentPosition2(){
        return world.get(currentPosition);
    }

    public int getCurrentPosition() {
        return currentPosition;
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
        if(newLocation == -1){
            return "You cant go that way!";

        }else{
            if (currentPosition == 0 && !permission2 == false && direction.equals("north")) {

                return "You dont have a permission 2 for this Room!";
            }
            if(currentPosition == 6 && !permission1 == false && direction.equals("south")){
                return "You need a Permission for this Room!";
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


