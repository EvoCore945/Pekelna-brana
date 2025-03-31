package command;

import World.Location;

public class Hint extends Command {

    private Location location;

    @Override
    /**
     * Writes all the available commands
     */
    public String execute() {
            return """
                Commands you can type:
                - go [direction] --> move to the location
                - backpack --> show or use your items in backpack
                - hint --> all commands
                - help --> if you are lost
                - player --> your stats
                - examine [room] --> search the room for items
                - pickUp [item] --> pick up a item
                - talk [NPC] --> talk with NPC
                - shoot [Enemy] --> Start the fight with a monster
                - end [PekelnaBrana] --> Close the game
                """
                    ;
        }

    public Hint() {
    }

    @Override
    public boolean exit() {
        return false;
    }
}


