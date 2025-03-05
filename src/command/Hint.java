package command;

import World.Location;

public class Hint implements Command {

    private Location location;

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    public Hint(Location location) {
            this.location = location;
        }

    }
