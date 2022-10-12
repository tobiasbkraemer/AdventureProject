import java.util.ArrayList;

public class Room {
    private Room south;
    private Room north;
    private Room east;
    private Room west;
    private String name;
    private String description;

    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();


    @Override
    public String toString() {
        return "Room{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getRoomDescription() {
        return description;
    }

    public String getRoomName() {
        return name;
    }

    public Room getSouthRoom() {
        return south;
    }

    public Room getNorthRoom() {
        return north;
    }

    public Room getWestRoom() {
        return west;
    }

    public Room getEastRoom() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }


    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setWest(Room west) {
        this.west = west;
    }


    public void createItem(String name, String description) {
        Item item = new Item(name, description);
        addItem(item);
    }

    public void createFood(String name, String description, int healthPoints) {
        Food food = new Food(name, description, healthPoints);
        addItem(food);
    }

    public void createMeleeWeapon(String name, String description, int damage) {
        MeleeWeapon meleeWeapon = new MeleeWeapon(name, description, damage);
        addItem(meleeWeapon);
    }

    public void createRangedWeapon(String name, String description, int damage, int ammo) {
        RangedWeapon rangedWeapon = new RangedWeapon(name, description, damage, ammo);
        addItem(rangedWeapon);
    }

    public void createEnemy(String name, String description, int healthPoints, Weapon weapon, Room room){
        Enemy enemy = new Enemy(name, description, healthPoints, weapon, room);
        addEnemy(enemy);
    }

    private void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> getRoomItems() {
        return items;
    }

    public ArrayList<Enemy> getEnemies () {
        return enemies;
    }


    public Item removeItem(String name) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(name)) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    public Enemy removeEnemy(String name) {
        for (Enemy enemy : enemies) {
            if (enemy.getName().equals(name)) {
                enemies.remove(enemy);
                return enemy;
            }
        }
        return null;
    }

    public Enemy searchEnemy(String searchEnemy) {
        for (Enemy enemy : enemies) {
            if (enemy.getName().equals(searchEnemy)) {
                return enemy;
            }
        }
        return null;
    }
}
