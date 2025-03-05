package command;

import characters.NPC;

public class Talk implements Command{

    private NPC character;

    public Talk(NPC character) {
        this.character = character;
    }

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}

