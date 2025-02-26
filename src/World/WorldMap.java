package World;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WorldMap {
    private HashMap<Integer, Location> world = new HashMap<>();
    private int start = 0;
    private int currentPosition = start;

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
            System.out.println("Chyba při načítání z mapy: " + e.getMessage());
           return  false;
        }
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

}
