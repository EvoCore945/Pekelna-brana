
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
    private Map<String, Command> commands = new HashMap<>();

    public Console() {
        this.sc = new Scanner(System.in);
    }

    private void initializeCommands() {

        WorldMap worldMap = new WorldMap();


        commands.put("examine", new Examine(worldMap.getCurrentPosition2()));
        commands.put("shoot", new Shoot());
       // commands.put("pick up", new PickUp(new Item("", ""), player.getBackpack()));
        commands.put("talk", new Talk());
        commands.put("prinfo",new PlayerDescription());
        commands.put("hint", new Hint());
        commands.put("use", new Use(new Item("", "")));
        commands.put("go", new Go());
        commands.put("end", new End());
    }

    public void doCommand(){
        System.out.println("What do you want to do?");
        String command = sc.nextLine();
        command = command.trim();
        command = command.toLowerCase();

        if(commands.containsKey(command)){
            System.out.println("---> " + commands.get(command).execute());
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
           }while(!End.exit);
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
        System.out.println("Game Over.");
    }

    }






