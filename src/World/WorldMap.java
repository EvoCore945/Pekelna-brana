package World;

import command.Backpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WorldMap {
    private HashMap<Integer, Location> world = new HashMap<>();
    private int start = 0;
    private int currentPosition = start;
    private static WorldMap instance;

    public static WorldMap getInstance() {
        if (instance == null) {
            instance = new WorldMap();
        }
        return instance;
    }

    public boolean loadMap(){
        try(BufferedReader br = new BufferedReader(new FileReader("mistnost.csv)"))){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(" --- ");
                if(parts.length < 6) continue;

               int ID = Integer.parseInt(parts[0]);
               String name = parts[1];
               int[] directions = new int[4];


                for (int i = 0; i < 4; i++) {
                    directions[i] = parts[i + 2].equals("-1") ? -1 : Integer.parseInt(parts[i + 2]);
                }
                world.put(ID, new Location(name,ID,directions));
            }
            return  true;
        } catch (IOException e) {
            System.out.println("Error while loading the map: " + e.getMessage());
           return  false;
        }
    }

    public int getCurrentPositionID() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Location getCurrentPosition(){
        return world.get(currentPosition);
    }

    public boolean move(int direction){
        int nextID = world.get(currentPosition).getDirection(direction);
        if(nextID != -1 && world.containsKey(nextID)){
            currentPosition = nextID;
            return true;
        }
        return false;
}
public Map<Integer, Location> getWorld(){
        return world;

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


