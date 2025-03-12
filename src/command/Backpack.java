package command;

import World.Item;
import java.util.ArrayList;

public class Backpack {
    private ArrayList<Item> items;
    private int capacity;


    public Backpack(int capacity) {
        this.items = new ArrayList<Item>();
        this.capacity = capacity;
    }

    public boolean addItem(Item item) {
        if (items.size() < capacity) {
            items.add(item);
            return true;
        }
        return false;
    }

    public boolean removeItem(Item item) {
       return items.remove(item);
    }

    public boolean hasItem(String itemName) {
        return items.stream().anyMatch(i -> i.getName().equalsIgnoreCase(itemName));
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String useItem() {
        return "Item used";
    }

    public String listItems() {
        if (items.isEmpty()) {
            return "Backpack is empty.";
        }
        StringBuilder itemList = new StringBuilder("Items in Backpack: ");
        for (Item item : items) {
            itemList.append(item.getName()).append(", ");
        }
        return itemList.toString();
    }

    public boolean isFull() {
        return items.size() >= capacity;
    }

    @Override
    public String toString() {
        return "Inventory: " + items.toString();
    }

}
