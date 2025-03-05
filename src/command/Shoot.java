package command;

import characters.Monster;

public class Shoot implements Command {

    private Monster monster;

    public Shoot(Monster monster) {
        this.monster = monster;
    }

    @Override
    public String execute() { return ""; }

    @Override
    public boolean exit() { return false; }
}



