import World.WorldMap;
import characters.Player;
import command.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        commands.put("backpack", new Backpack());
        commands.put("shoot", new Shoot());
        commands.put("talk", new Talk());
        commands.put("player",new PlayerDescription());
        commands.put("hint", new Hint());
        commands.put("help", new Help());
        commands.put("go", new Go());
        commands.put("end", new End());
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String playerName = scanner.nextLine();
        Player player = Player.getInstance();
        player.setName(playerName);
        initializeCommands();
       // introductiontext();
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
    private static void introductiontext(){

        try(BufferedReader reader =new BufferedReader(new FileReader("src/introduction.txt"))){
            String line;

            while((line = reader.readLine())!= null){
                System.out.println(line);
                Thread.sleep(1500);
            }
        } catch(IOException | InterruptedException e){
            System.out.println("Could not load introduction text.");
        }
    }
    }






