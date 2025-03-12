package command;

import characters.NPC;

public class Talk implements Command{

    private NPC character;

    public Talk(NPC character) {
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

