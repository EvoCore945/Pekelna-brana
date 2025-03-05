package command;

public class End implements Command {

    public String execute(){
        return "Exiting the game.";
    }

    @Override
    public boolean exit() {
        return false;
    }

}
