package characters;

import command.Command;

public class NPC implements Command {

    private String description;

    public String getDialogue() { return ""; }

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}




