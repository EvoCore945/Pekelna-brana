package command;

public class Help  extends Command{
    @Override
    public String execute() {

        return "You need to find Access Cards in the room to open new locations. " +
                "Try to kill every enemy on the map for bonus health and damage. " +
                "You need a special item to finish the game.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
