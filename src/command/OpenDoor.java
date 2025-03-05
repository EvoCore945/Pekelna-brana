package command;

import World.WorldMap;

public class OpenDoor implements Command{

    private WorldMap worldMap;

    public String execute() { return ""; }

    @Override
    public boolean exit() {
        return false;
    }

    public boolean canOpen(String doorName) {
        return false;
    }

    public String unlockDoor(String doorName) {
        return "";
    }
}


