package command;

import characters.Monster;

public class Escape implements Command {


    private Monster monster;


    public String execute() {
        return Math.random() > 0.5 ? "You have successfully escaped!." : "Escape failed!";
    }

    public boolean exit() {
    return true;
    }

}
