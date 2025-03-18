package command;

import characters.Boss;
import characters.Monster;
import characters.Player;

public class Shoot extends Command {

    private Monster monster;
    private Player player;
    private Boss boss;

    public Shoot(Boss boss, Player player) {
        this.monster = null;
        this.player = player;
        this.boss = boss;
    }

    public Shoot(Player player) {
        this.player = player;
        this.boss = null;
    }

    private String fightMonster() {
        if (monster.isDefeated()) {
            return "The monster is already defeated.";
        }

        if(!player.isAlive()) {
            return "You are dead! Cannot fight.";
        }

        player.attack(monster);
        if (monster.isDefeated()) {
            return "You defeated the monster!";
        }
        monster.attack(player);
        return "Monster attacked you! Your health: " + player.getHealth();

    }
    private String fightBoss() {

        if (!player.isAlive()) {
            return "You are dead! Cannot fight.";
        }
        boss.useSpeciesAttack(player);
        if (!player.isAlive()) {
            return "You were defeated by the boss!";
        }
        player.attack(boss);
        return "You attacked the boss! Boss health: " + boss.getHealth();
    }

    @Override
    public String execute() {
        if (monster != null) {
            return fightMonster();
        } else if (boss != null) {
            return fightBoss();
        }
        return "No enemy to fight!";
    }

    @Override
    public boolean exit() {
        return !player.isAlive() || (monster != null && monster.isDefeated()) || (boss != null && !player.isAlive());
    }

        }





