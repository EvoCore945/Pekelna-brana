package command;

import characters.Monster;

public class Escape implements Command {


    private Monster monster;


    public String execute() {
    return "You ran away fro the monster";
    }


    public boolean escape() {
    return true;
    }


    public boolean exit() {
    return true;
    }

}
