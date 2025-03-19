package characters;

import command.Command;

public class NPC {
    private String name;
    private String description;


    public NPC(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDialogue() {
        return "NPC says: " + description;
    }
}





