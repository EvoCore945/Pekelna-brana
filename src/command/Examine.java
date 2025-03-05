package command;

import World.Location;

public class Examine implements Command {

    private Location location;

    public Examine(Location location) {
        this.location = location;
    }

    public String execute() {
        return "";
    }

    public boolean exit() {
        return false;
    }
}


