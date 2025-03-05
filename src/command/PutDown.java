package command;

import World.Item;

public class PutDown implements  Command {

    private Item item;
    private Backpack inventory;

    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}

