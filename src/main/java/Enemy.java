public class Enemy {
    private String name;
    private String description;
    private int healthPoints;
    private Weapon weapon;
    private Room room;

    @Override
    public String toString() {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", healthPoints=" + healthPoints +
                ", weapon=" + weapon +
                ", room=" + room +
                '}';
    }

    public Enemy(String name, String description, int healthPoints, Weapon weapon, Room room) {
        this.name = name;
        this.description = description;
        this.healthPoints = healthPoints;
        this.weapon = weapon;
        this.room = room;

    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void currentHealth(int damage) {
        healthPoints -= damage;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean isDead(){
        if (healthPoints<=0){
            room.addItem(weapon);
            room.removeEnemy(name);
            return true;
        }else{
            return false;
        }
    }


}
