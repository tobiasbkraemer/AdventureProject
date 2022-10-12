public class RangedWeapon extends Weapon{

    private int healthPoints;


    public RangedWeapon
            (String name, String description, int healthPoints) {
        super(name, description, healthPoints);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

}
