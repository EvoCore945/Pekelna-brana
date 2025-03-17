
import World.Item;
import World.WorldMap;
import characters.NPC;
import characters.Player;
import command.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Console {

    private Scanner sc;
    private boolean exit = false;
    private Map<String, Command> commands = new HashMap<String, Command>();
    public static String CommandsFile = "commands.txt";

    public Console() {
        this.sc = new Scanner(System.in);
    }

    private void initializeCommands() {

        Player player = Player.getInstance();
        WorldMap worldMap = new WorldMap();
        NPC npc = new NPC("");

        commands.put("examine", new Examine(worldMap.getCurrentPosition()));
        commands.put("shoot", new Shoot(player));
        commands.put("pick up", new PickUp(new Item("", "", true), player.getBackpack()));
        commands.put("put down", new PutDown(new Item("", "", true), player.getBackpack()));
        commands.put("talk", new Talk(npc));
        commands.put("hint", new Hint());
        commands.put("use", new Use(new Item("", "", true)));
        commands.put("go", new Go());
    }

    public void doCommand(){
        System.out.println("What do you want to do?");
        String command = sc.nextLine();
        command = command.trim();
        command = command.toLowerCase();

        if(commands.containsKey(command)){
            System.out.println("--->" + commands.get(command).execute());
        }else{
            System.out.println("---> Nondefined command");
        }
    }
    public void startGame() {
        initializeCommands();
        System.out.println("Welcome to The Pekelna Brana!");
        System.out.println("Type 'hint' to see available commands.");

       try{
           do{
               doCommand();
           }while(!exit);
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
        System.out.println("Game Over.");
    }

    }






