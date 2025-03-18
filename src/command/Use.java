package command;

import World.Item;

public class Use extends Command{

    private Item item;
    private Backpack backpack;

    public Use(Item item) {
        this.item = item;
    }

    public String execute() {
        if(!backpack.hasItem(item.getName())){
            return "You don't have " + item.getName() + ".";
        }
        return "You used" + item.getName() + ".";
    }

    public boolean exit() {
        return false;
    }
}