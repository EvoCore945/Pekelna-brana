package characters;

import java.util.HashMap;
import java.util.Random;

public class Monster {

    private String name;
    private int health;
    private int attackDamage;
    private static HashMap<Integer, Monster> monsters = new HashMap<>();
    Random rd = new Random();

    public Monster(String name, int health, int attackDamage) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
    }

    public static Monster getMonsterAt(int location){
        return monsters.get(location);
}

    public static void addMonster(int location, Monster monster){
        monsters.put(location, monster);
    }
    public static void removeMonster(int location){
        monsters.remove(location);
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
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}



