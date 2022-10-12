import java.util.concurrent.atomic.AtomicBoolean;

public class Adventure {
    private Player player;
    private Map map = new Map();


    public Adventure() {
        map.createMap();
        player = new Player(10);
        player.setCurrentRoom(map.getStarterRoom());
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public Weapon getEquippedWeapon() {
        return player.getEquippedWeapon();
    }

    public Item getItem(String itemName) {
        return player.getItem(itemName);
    }

    public boolean go(String direction) {
        return player.move(direction);
    }

    public ReturnMessage playerEat(String itemName) {
        return player.eatFood(itemName);
    }

    public ReturnMessage playerEquip(String itemName) {
        return player.equipWeapon(itemName);
    }

    public ReturnMessage playerUnEquip() {
        return player.unEquipWeapon();
    }

    public AttackCommands playerAttack(String userInput) {
        return player.attackCommand(userInput);
    }

    public Item playerTakeItem(String itemName) {
        return player.takeItem(itemName);
    }

    public Item playerDropItem(String itemName) {
        return player.dropItem(itemName);
    }



}

