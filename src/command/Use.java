package command;

import World.Item;

public class Use implements Command{

    private Item item;

    public String execute() {
        return "";
    }

    public boolean exit() {
        return false;
    }
}

