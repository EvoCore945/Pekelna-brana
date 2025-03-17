package command;

import World.Location;

public class Examine implements Command {

    private Location location;

    public Examine(Location location) {
        this.location = location;
    }

    public String execute() {
        if (location == null) {
            return "Unknown location.";
        }
       // String description = location.getDescription();
        return "You are in: " + location.getName() + ". ";
    }

    public boolean exit() {
        return false;
    }
}


