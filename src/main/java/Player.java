import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private Weapon equippedWeapon;
    private int health;

    public Player(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public Player setHealth(int health) {
        this.health = this.health + health;
        return null;
    }

    public void currentHealth(int damage) {
        health -= damage;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
        return currentRoom;
    }

    public Item takeItem(String itemName) {
        for (Item item : currentRoom.getRoomItems()) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                inventory.add(item);
                currentRoom.removeItem(itemName);
                return item;
            }
        }
        return null;
    }

    public Item dropItem(String itemName) {
        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                currentRoom.addItem(item);
                inventory.remove(item);
                return item;
            }
        }
        return null;
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

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public Item getItem(String name) {
        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }


    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public ReturnMessage eatFood(String itemName) {
        Item item = getItem(itemName);
        if (item instanceof Food) {
            health += ((Food) item).getHealthPoints();
            removeItem(item);
            return ReturnMessage.OK;
        } else {
            if (item != null) {
                return ReturnMessage.CANT;
            }
            return ReturnMessage.NOT_FOUND;
        }
    }

    public ReturnMessage equipWeapon(String itemName) {
        Item item = getItem(itemName);
        if (item instanceof Weapon) {
            equippedWeapon = (Weapon) item;
            removeItem(item);
            return ReturnMessage.OK;
        } else {
            if (item != null) {
                return ReturnMessage.CANT;
            }
            return ReturnMessage.NOT_FOUND;
        }
    }

    public ReturnMessage unEquipWeapon() {
        if (equippedWeapon != null) {
            inventory.add(equippedWeapon);
            equippedWeapon = null;
            return ReturnMessage.OK;
        } else {
            return ReturnMessage.CANT;
        }
    }

    public AttackCommands attackCommand(String enemyName) {

        Weapon weapon = equippedWeapon;
        Enemy enemy = currentRoom.searchEnemy(enemyName);
        if (weapon == null) {
            return AttackCommands.No_Weapon_Equipped;

        } else if (enemy == null) {
            return AttackCommands.No_Enemy;

        } else if (weapon.canUse()) {
            weapon.useAmmo();
            enemy.currentHealth(weapon.getDamage());
            if (!enemy.isDead()) {
                currentHealth(enemy.getWeapon().getDamage());
            } else {
                return AttackCommands.Enemy_Dead;
            }
            return AttackCommands.Attack_Enemy;
        } else {
            return AttackCommands.No_Ammo;
        }
    }

}



