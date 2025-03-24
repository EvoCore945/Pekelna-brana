import World.WorldMap;

public class Main {
    public static void main(String[] args) {

        Console console = new Console();
        WorldMap worldMap = new WorldMap();
        worldMap.initialzizeMonsters();
        worldMap.initializeNPCs();
        worldMap.loadMap();
        console.startGame();
    }
}