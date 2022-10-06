import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int currentHealth;
    private int health;
    private final int maxHealth = 10;

    public Player(int health) {
        this.health=health;
    }

    public int getHealth() {
        return health;
    }
    public Player setHealth(int health) {
        this.health = this.health+health;
        return null;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
        return currentRoom;
    }

    public boolean move(String direction) {
        Room requestedRoom = null;
        if (direction.charAt(0) == 'n') {
            requestedRoom = currentRoom.getNorthRoom();
        } else if (direction.charAt(0) == 's') {
            requestedRoom = currentRoom.getSouthRoom();
        } else if (direction.charAt(0) == 'e') {
            requestedRoom = currentRoom.getEastRoom();
        } else if (direction.charAt(0) == 'w') {
            requestedRoom = currentRoom.getWestRoom();
        }

        if (requestedRoom != null) {
            currentRoom = requestedRoom;
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }


    public Item removeItem(String name) {
        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(name)) {
                inventory.remove(item);
                return item;
            }
        }
        return null;
    }
    public Item getItem(String name) {
        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
    public ReturnMessage eatFood (String itemName) {
        Item item = getItem(itemName);
        if ( item instanceof Food) {
            health += ((Food) item).getHealthPoints();
            removeItem(itemName);
            return ReturnMessage.OK;
        } else {
            if (item!=null){
                return ReturnMessage.CANT;
            }
            return ReturnMessage.NOT_FOUND;
        }
    }
}


