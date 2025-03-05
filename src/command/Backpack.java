package command;

import World.Item;

import java.awt.*;
import java.util.ArrayList;

public class Backpack {
    private ArrayList<Item> items;
    private int capacity;


    public Backpack(ArrayList<Item> items, int capacity) {
        this.items = items;
        this.capacity = capacity;

    }

    public boolean addItem(Item item) {
            items.add(item);
            return true;

    }

    public boolean removeItem(Item item) {
       return items.remove(item);
    }

    public boolean hasItem(String itemName) {
        return true;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String useItem() {
        return "Item used";
    }

    public boolean isFull() {
        return true;
    }

    @Override
    public String toString() {
        return "Inventory: " + items.toString();
    }
}
