public abstract class Weapon extends Item {

    private int damage;


    public Weapon (String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public boolean canUse(){
        return true;
    }

    public abstract int getRemainingAmmo();


    public abstract void useAmmo();


}
