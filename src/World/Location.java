package World;

public class Location {

    private String name;
    private int ID;
    private int[] locations;


    public Location(String name, int ID, String[] locations) {
        this.name = name;
        this.ID = ID;
        this.locations = new int[4];
        for (int i = 0; i <locations.length; i++) {
            this.locations[i] = Integer.parseInt(locations[i]);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int[] getLocations() {
        return locations;
    }

    public void setLocations(int[] locations) {
        this.locations = locations;
    }


   /* public String getDescription() {
        return "You are in: " + name + ". " + (items.isEmpty() ? "There are no items here." : "Items are available in this location.");
    }

   public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null; // Pokud položka není nalezena
    }*/



}
