package command;
import World.WorldMap;
import java.util.Scanner;

public class Go extends Command {

    private WorldMap worldMap = new WorldMap();
    Scanner sc = new Scanner(System.in);

    /**
     * Moves player to specific location by his choice.
     * author: ChatGPT
     */
    public String execute() {
        System.out.println("Where do you want to go?");

        String direction = sc.next();
        direction = direction.toLowerCase();

        System.out.println(worldMap.move(direction));

        return "";
    }
    @Override
    public boolean exit() {
        return false;

    }
}