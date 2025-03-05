package characters;

public class Monster {

    private int health;
    private int attackDamage;

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int takeDamage(int damage) {
        return 0;
    }

    public boolean isDefeated() {
        return false;
    }

    public void attack(Player player) {

    }

    public String toString() {
        return "";
    }
}



