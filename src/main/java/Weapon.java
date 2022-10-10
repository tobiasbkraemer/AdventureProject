public class Weapon extends Item {

    private int healthPoints;


    public Weapon
            (String name, String description, int healthPoints) {
        super(name, description);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }


}
