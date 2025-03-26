package World;

import java.util.Random;

public class Item {
    Random rd = new Random();

    private String name;
    private String description;
    private ItemType type;
    private final int bonusHealth = rd.nextInt(10,20);
    private final int bonusDamage = rd.nextInt(5,10);


    public Item(String name, String description, ItemType type) {
        this.name = name;
        this.description = description;
        this.type = type;
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

    @Override
    public String toString() {
        return "Item name = " + name  + ", = " + description + ", type = " + type;
    }
}

