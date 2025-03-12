package command;

import World.WorldMap;

public class Go implements Command {

    private WorldMap worldMap;
    private int direction;

    public String execute() {
       return worldMap.move(direction)? "You have moved succesfully. " : "You cant go there.";
    }

    public Go(WorldMap worldMap, int direction) {
        this.worldMap = worldMap;
        this.direction = direction;
    }

    @Override
    public boolean exit() {
        return false;

    }
}
