package command;

import World.Item;

public class PutDown implements  Command {

    private Item item;
    private Backpack backpack;

    public PutDown(Item item, Backpack backpack) {
        this.item = item;
        this.backpack = backpack;
    }

    public String execute() {
        if(backpack.removeItem(item)){
            return "You put down the " + item.getName();
        }
            return "You don't have the " + item.getName() + " in your inventory";
        }

    @Override
    public boolean exit() {
        return false;
    }
}