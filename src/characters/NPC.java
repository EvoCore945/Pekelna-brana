package characters;

import command.Command;

public class NPC {

    private String description;

    public NPC(String description) {
        this.description = description;
    }

    public String getDialogue() {
        return "NPC says: " + description;
    }
}





