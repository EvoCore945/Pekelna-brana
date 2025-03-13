package World;

import characters.Monster;
import characters.NPC;

import java.util.ArrayList;

public class Location {

    private String name;
    private int ID;
    private int[] connections;
    private ArrayList<Item> items;
    private NPC npc;
    private Monster monster;

    public Location(String name, int ID, int[] connections, NPC npc, ArrayList<Item> items, Monster monster) {
        this.name = name;
        this.ID = ID;
        this.connections = connections;
        this.npc = npc;
        this.items = items;
        this.monster = monster;
    }

    public Location(String name, int id, int[] directions) {
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getDirection(int index) {
        return (index >= 0 && index < connections.length) ? connections[index] : -1;
    }

    public String getDescription() {
        return "You are in: " + name + ". " + (items.isEmpty() ? "There are no items here." : "Items are available in this location.");
    }

    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null; // Pokud položka není nalezena
    }

    public NPC getNpc() {
        return npc;
    }

    public Monster getMonster() {
        return monster;
    }
    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }

}
