public class MeleeWeapon extends Weapon{

    private int healthPoints;


    public MeleeWeapon
            (String name, String description, int healthPoints) {
        super(name, description, healthPoints);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}
