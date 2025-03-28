package command;

import World.WorldMap;
import characters.NPC;

public class Talk extends Command{

    private NPC character;

    public Talk() {
    }

    @Override
    public String execute() {
        int currentPosition = WorldMap.getCurrentPosition();
        NPC npc = NPC.getNPCAt(currentPosition);
        if (npc != null){
            return npc.talk();
        }else{
            return "There's no one here to talk to.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}

