package command;

import World.WorldMap;

public class OpenDoor implements Command {

    private WorldMap worldMap;
    private String doorName;
    private Backpack backpack;

    public OpenDoor(WorldMap worldMap, String doorName, Backpack backpack) {
        this.worldMap = worldMap;
        this.doorName = doorName;
        this.backpack = backpack;
    }

    public String execute() {
        boolean success = worldMap.unlockDoor(doorName, backpack);
        if(success){
            return "Doors" + doorName + " were opened.";
        }else{
            return "Doors" + doorName + "cant be opened, wrong access card!";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
