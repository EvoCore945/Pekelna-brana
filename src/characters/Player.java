package characters;

import command.Backpack;

public class Player {

    private String name = "Player";
    private int health = 100;
    private static Player instance = new Player();
    private int attackDamage = 15;

    public Player() {
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    public static void setInstance(Player instance) {
        Player.instance = instance;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' + ", health=" + health + ", attackDamage=" + attackDamage + '}';
    }
}


