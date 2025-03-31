package World;

import java.util.Random;

public class Item {
    Random rd = new Random();

    private String name;
    private String description;
    private ItemType type;
    private final int bonusHealth = rd.nextInt(10, 20);
    private final int bonusDamage = rd.nextInt(5, 10);
    boolean isLOG;


    public Item(String name, String description, ItemType type, boolean isLOG) {
        this.name = name;

        this.description = description;
        this.type = type;
        this.isLOG = isLOG;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }


    public String getDescription() {

        return description;
    }

    public int getBonusHealth() {
        return bonusHealth;
    }

    public int getBonusDamage() {
        return bonusDamage;
    }

    public boolean isLOG() {
        return isLOG;
    }

    @Override
    public String toString() {
        return "Item name = " + name +", type = " + type;
    }
}