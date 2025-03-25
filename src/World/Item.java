package World;

public class Item {

    private String name;
    private String description;
    private ItemType type;
    private int bonusHealth;
    private int bonusDamage;


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
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}

