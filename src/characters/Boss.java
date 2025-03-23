package characters;

public class Boss  {

    private String specialAttack;

    public Boss(int health, int attackDamage, String specialAttack) {

        this.specialAttack = specialAttack;
    }

    @Override
    public String toString() {
        return "" + specialAttack;
    }
    }



