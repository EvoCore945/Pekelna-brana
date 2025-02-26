package World;

public class Location {

    private String name;
    private int ID;
    private int[] connections;


    public Location(String name, int ID, int[] connections) {
        this.name = name;
        this.ID = ID;
        this.connections = connections;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getDirection(int index){
        return (index >= 0 && index< connections.length) ? connections[index] : -1;
    }
}
