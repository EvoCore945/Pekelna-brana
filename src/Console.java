
import World.Item;
import World.WorldMap;
import characters.Monster;
import characters.NPC;
import characters.Player;
import command.*;
import command.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Console {

    private Scanner scanner;
    private Map<String, Command> commands;

    public Console() {
        this.scanner = new Scanner(System.in);
        initializeCommands();
    }


    private void initializeCommands(){

        this.commands = new HashMap<>();
        Player player = Player.getInstance();
        WorldMap worldMap = WorldMap.getInstance();
        NPC npc = new NPC("");

        commands.put("explore", new Examine(worldMap.getCurrentPosition()));
        commands.put("shoot", new Shoot(player));
        commands.put("pick up", new PickUp(new Item("", "", true), player.getBackpack()));
        commands.put("put down", new PutDown(new Item("", "", true), player.getBackpack()));
        commands.put("talk", new Talk(npc));
        commands.put("hint", new Hint(worldMap.getCurrentPosition()));
        commands.put("use", new Use(new Item("","",true)));
        commands.put("go", new Movement(worldMap, ""));
    }

    public void startGame() {
        System.out.println("Welcome to The Pekelna Brana!");
        System.out.println("Type 'help' to see available commands.");

        boolean running = true;
        while (running) {
            String command = readCommand();
            running = processCommand(command);
        }
        System.out.println("Game Over.");
    }

    private String readCommand() {
        System.out.print("> ");
        return scanner.nextLine().trim().toLowerCase();
    }
    private boolean processCommand(String command) {
        if (command.equals("exit")) {
            return false;
        }
        printMessage(proceedCommand(command));
        return true;
    }

    private String proceedCommand(String command) {
        if (command.equals("go")) {
            printMessage("Enter direction (north, south, east, west): ");
            String direction = readCommand();
            return new Movement(WorldMap.getInstance(), direction).execute();
        } else if (commands.containsKey(command)) {
            return commands.get(command).execute();
        }
        return "Unknown command. Type 'help' to see available commands.";
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}






