package command;
import World.Item;
import World.ItemType;
import World.WorldMap;
import characters.Player;
import java.util.ArrayList;
import java.util.Scanner;

public class Backpack extends Command {
    WorldMap worldMap;
    private static ArrayList<Item> backpack = new ArrayList<>();

    public static ArrayList<Item> getBackpack() {
        return backpack;
    }

    /**
     * Adds item to backpack.
     */
    public static void addItemToBackpack(Item item){
        backpack.add(item);
    }

    /**
     * Allows player to interact with their backpack
     * It checks if the backpack is empty, then provides options to list all items or use a specific item.
     */
    public String execute() {
        Scanner sc = new Scanner(System.in);

        if (backpack.isEmpty()) {
            System.out.println("Backpack is empty");
            return "";
        }
        System.out.println("TYPE: '1' - Writes all the items in your backpack.");
        System.out.println("TYPE: '2' - Use a specific item");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                showBackpack();
                break;
            case 2:
                useItem(sc);
                break;
            default:
                System.out.println("Invalid selection");
        }
        return "";
    }

    /**
     * Shows all the items in the backpack
     */
    public void showBackpack() {

        System.out.println("These are the items in your backpack:");
        for (int i = 0; i < backpack.size(); i++) {
            if(!backpack.get(i).isLOG()){
                System.out.println((i + 1) + ". " + backpack.get(i).getName() + " - " + backpack.get(i).getDescription());
            }else{
                System.out.println((i + 1) + ". " + backpack.get(i).getName());
            }

        }
    }

    /**
     * Checks the type of the selected item and then uses it
     */
    public void useItem(Scanner sc) {

        int currentPosition = WorldMap.getCurrentPosition();
        showBackpack();
        System.out.println("Enter the number of the item you want to use:");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid input");
            sc.next();
            return;
        }

        int index = sc.nextInt() - 1;

        if (index < 0 || index >= backpack.size()) {

            System.out.println("Invalid selection");
        }

        Item selectedItem = backpack.get(index);
        if(selectedItem.getType().equals(ItemType.CARD)){
            System.out.println("Cards are already used.");
        }
        if(selectedItem.getType().equals(ItemType.LOG)){
            System.out.println("Reading log:");
            System.out.println(selectedItem.getDescription());
        }
        if (selectedItem.getType().equals(ItemType.HEAL)) {
            int bonusHealth = Player.getInstance().getHealth() + selectedItem.getBonusHealth();
            Player.getInstance().setHealth(Player.getInstance().getHealth() + selectedItem.getBonusHealth());
            backpack.remove(index);
            System.out.println("Health restored to " + Player.getInstance().getHealth());
        } else if (selectedItem.getType().equals(ItemType.WEAPON)) {
            Player.getInstance().setAttackDamage(Player.getInstance().getAttackDamage() + selectedItem.getBonusDamage());
            backpack.remove(index);
            System.out.println("Attack damage increased to " + Player.getInstance().getAttackDamage());
        }
        if(selectedItem.getType().equals(ItemType.FINALITEM) && currentPosition == 8 ){
            System.out.println("You successfully placed Electro Stabilizer into the Portal device...");
            System.out.println("CONGRATULATIONS! YOU HAVE CLOSED THE PORTAL AND SAVED THE STATION!");
            End.exit = true;
        }else{
            System.out.println("You have to be in a portal room !");
        }
    }

        @Override
        public boolean exit () {
            return false;
        }
    }
