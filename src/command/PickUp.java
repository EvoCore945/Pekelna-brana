package command;

import World.Item;

public class PickUp extends Command {

    private Item item;
    private Backpack backpack;

    public String execute() {

            return backpack.addItem(item) ? "You picked up the item: " + item.getName() : "Backpack is full!";
    }

    public PickUp(Item item, Backpack backpack) {
        this.item = item;
        this.backpack = backpack;
    }

    @Override
    public boolean exit() {
        return false;
    }
}

