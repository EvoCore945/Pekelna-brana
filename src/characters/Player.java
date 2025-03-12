package characters;

import command.Backpack;

public class Player {

    private String name;
    private String description;
    private int health;
    private int maxHealth;
    private Backpack backpack;
    private static Player instance;
    private int attackDamage;


    public Player(String name, String description, int health, int maxHealth, Backpack backpack, int attackDamage) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.maxHealth = maxHealth;
        this.backpack = backpack;
        this.attackDamage = attackDamage;
    }

    public Player() {
    }

    public Backpack getBackpack(){
        return backpack;
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) health = 0; {
            System.out.println("You took "+ damage +" damage! Health left: " + health);
        }
    }
    public boolean isAlive() {
        return health > 0;
    }
    public void attack(Monster monster) {
        if (isAlive()) {
            monster.takeDamage(attackDamage);
            System.out.println("You attacked the  monster! It now has " + monster.getHealth() + " health left.");
        }
    }
    public void useSpecialAttack(Monster monster) {
        System.out.println(name + " uses special attack!");
        monster.takeDamage(20);
    }

    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) health = maxHealth;
        System.out.println("You healed for " + amount + " HP! Current health: " + health);
    }



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }


    public String toString() {
        return name + ":" + description + " ( Health" + health + ")";
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}


