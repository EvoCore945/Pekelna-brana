package characters;

public class Monster {

    private int health;
    private int attackDamage;
 //   private static Monster instance;


    public Monster(int health, int attackDamage) {
        this.health = health;
        this.attackDamage = attackDamage;
    }

    public Monster() {

    }

  /*  public static Monster getInstance() {
        if (instance == null) {
            instance = new Monster();
        }
        return instance;
    }*/

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public boolean isDefeated() {
        return health <= 0;
    }

    public void attack(Player player) {
        player.takeDamage(attackDamage);
    }

    public String toString() {
        return "Monster with " + health + " health and " + attackDamage + " attack damage.";
    }
}



