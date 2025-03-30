package characters;

import command.Backpack;

import java.util.Scanner;

public class Player {

    private String name;
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
        return "Name = " + name + "\n Health = " + health + "\n AttackDamage = " + attackDamage;
    }
}


