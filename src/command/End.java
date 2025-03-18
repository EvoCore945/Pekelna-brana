package command;

public class End extends Command {

    public static boolean exit;

    public String execute(){
        setExit(true);
        return "Exiting the game.";
    }

    @Override
    public boolean exit() {
        return true;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
