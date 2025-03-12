package command;

import World.Item;

public class PickUp implements Command {

    private Item item;
    private Backpack backpack;

    public String execute() {
        if (item.isPortable()) {
            return backpack.addItem(item) ? "You picked up the item: " + item.getName() : "Backpack is full!";
        } else {
            return "This item is not portable.";
        }
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

