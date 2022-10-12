import java.util.ArrayList;

public class Room {
    private Room south;
    private Room north;
    private Room east;
    private Room west;
    private String name;
    private String description;

    private ArrayList<Item> items = new ArrayList<>();


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

    public void createMeleeWeapon(String name, String description, int healthPoints) {
        MeleeWeapon meleeWeapon = new MeleeWeapon(name, description, healthPoints);
        addItem(meleeWeapon);
    }

    public void createRangedWeapon(String name, String description, int healthPoints) {
        RangedWeapon rangedWeapon = new RangedWeapon(name, description, healthPoints);
        addItem(rangedWeapon);
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


    public Item removeItem(String name) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(name)) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    /*public Weapon removeWeapon(String name){
        for (Weapon weapon : weapons){
            if (weapon.getItemName().equalsIgnoreCase(name)){
                weapons.remove(weapon);
                return weapon;
            }
        }
        return null;
    }*/
}
