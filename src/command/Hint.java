package command;

import World.Location;

public class Hint extends Command {

    private Location location;

    @Override
    public String execute() {
            return """
                Commands you can type:
                - go [direction] --> move to the location
                - hint --> if you are lost
                - examine [room] --> search the room for items
                - pickUp [item] --> pick up a item
                - putDown [item] --> put down a item
                - talk [NPC] --> talk with NPC
                - shoot [Enemy] --> Start the fight with a monster
                - end [PekelnaBrana] --> Close the game
                - pInfo --> information about you
                
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


