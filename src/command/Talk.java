package command;

import characters.NPC;

public class Talk extends Command{

    private NPC character;

    public Talk() {
        this.character = character;
    }

    @Override
    public String execute() {
        if (character == null) return "There is no one to talk to here.";

        String dialogue = character.getDialogue();
        return (dialogue != null && !dialogue.isEmpty()) ? dialogue : "This character has nothing to say.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}

