package command;

import World.WorldMap;

public class Go implements Command {

    private WorldMap worldMap;
    private String direction;

    public String execute() {
       return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

}
