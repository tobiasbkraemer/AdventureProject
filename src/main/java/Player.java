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

    public void addItem(Item item) {
        inventory.add(item);
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
        Enemy selectedEnemy = null;
        Enemy enemyNearby = currentRoom.getEnemies().get(0);
        if (getEquippedWeapon() == null) {
            return AttackCommands.No_Weapon_Equipped;
        } else {
            if (getEquippedWeapon().canUse()) {
                if (!currentRoom.getEnemies().isEmpty()) {
                    for (Enemy enemy : currentRoom.getEnemies()) {
                        if (enemyName.equals(enemy.getName())) {
                            selectedEnemy = enemy;
                            attack(selectedEnemy);
                            return AttackCommands.Attack_Enemy;
                        }
                    }
                    if (selectedEnemy == null) {
                        attack(enemyNearby);
                        return AttackCommands.No_Such_Enemy;
                    }
                } else {
                    return AttackCommands.No_Enemy;
                }
            } else {
                return AttackCommands.No_Usable_Weapon;
            }
        }

        return null;
    }

    public void attack(Enemy enemy) {
        dealDamage(enemy);
        getHit(enemy);
        enemy.isDead();
    }

    private void getHit(Enemy enemy) {
        health -= enemy.getWeapon().getDamage();
    }

    private void dealDamage(Enemy enemy) {
        int damageDealt = enemy.getHealthPoints() - equippedWeapon.getDamage();
        enemy.hit(damageDealt);
        equippedWeapon.setAmmo(equippedWeapon.getRemainingAmmo() - 1);
    }

    public boolean isDead() {
        if (health <= 0) {
            return true;
        } else {
            return false;
        }
    }

}



