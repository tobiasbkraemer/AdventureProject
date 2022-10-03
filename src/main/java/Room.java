import java.util.ArrayList;

public class Room {
    private Room south;
    private Room north;
    private Room east;
    private Room west;
    private String name;
    private String description;

    private ArrayList <Item> items = new ArrayList<>();


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


    public void createItem (String name, String description){
        Item item = new Item (name, description);
        items.add(item);

    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getRoomItems() {
        return items;
    }

    public Item removeItem(String name){
        for (Item item : items){
            if (item.getItemName().equals(name)){
                items.remove(item);
                return item;
            }
        }
        return null;
    }
}
