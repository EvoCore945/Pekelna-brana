package command;

import characters.Player;

public class PlayerDescription extends Command{

    @Override
    /**
     * Writes information about player
     */
    public String execute() {
        Player player = Player.getInstance();
        return player.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
