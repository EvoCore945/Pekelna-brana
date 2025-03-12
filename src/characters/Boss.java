package characters;

public class Boss extends Monster {

    private String specialAttack;

    public Boss(int health, int attackDamage, String specialAttack) {
        super(health, attackDamage);
        this.specialAttack = specialAttack;
    }

    public void useSpeciesAttack(Player player) {
        System.out.println("Boss uses special attack: " + specialAttack);
        player.takeDamage(20);
    }

    @Override
    public String toString() {
        return "Boss with " + getHealth() + " health, " + getAttackDamage() + " attack damage, and special attack: " + specialAttack;
    }
    }



