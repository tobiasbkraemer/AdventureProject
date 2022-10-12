import java.util.ArrayList;

public class Map {
    private Room starterRoom;
    ArrayList<Item> items = new ArrayList<>();

    public void createMap() {
        Room room1 = new Room("Navigation", "This is the main room of the spaceship. In the middle of the room there is a screen with a map of the spaceship. Theres 9 rooms total");
        Room room2 = new Room("Cafeteria", "This is the Cafeteria. It's surprisingly clean in here, but there is a weird smell. On the table in front of you lies an apple. Looks suspicious");
        Room room3 = new Room("Weapon arsenal", "This is the weapon arsenal, there is a loads of weapons hanging on the wall.");
        Room room4 = new Room("Medical", "This is the medical room of the spaceship. It's filled with unknown pills. the label is teared off, cant read the effects, but they could be useful.");
        Room room5 = new Room("Command center", "This is it, there is a big monster guarding the power source.");
        Room room6 = new Room("Electrical", "This is electrical. It looks like the power source to the spaceship is missing.");
        Room room7 = new Room("Prison cell", "The spaceship looks like its been an old bounty hunter-spaceship. The spaceships crew mates are locked in the cells. a crew mate who turned his back on the others are guarding the cells. The imprisoned crew mates yells that the power source is in the command center guarded by a big monster.");
        Room room8 = new Room("Passage", "Even though it is completely dark in passage, you can almost feel the spiderwebs hanging from the ceiling and dust covering every surface. There may be some useful things in here, but it's too dark to see. Theres a door to the north.");
        Room room9 = new Room("Communication", "You are in the communication-room. This is where all contact in and out the spaceship takes place.");

        room1.setEast(room2);
        room1.setSouth(room4);
        room1.setWest(null);
        room1.setNorth(null);
        room1.createMeleeWeapon("knife", "pointy", -5);

        room2.setWest(room1);
        room2.setEast(room3);
        room2.setNorth(null);
        room2.setSouth(null);
        room2.createFood("apple", "may be poisonous or healthy", -1);

        room3.setWest(room2);
        room3.setSouth(room6);
        room3.setNorth(null);
        room3.setEast(null);
        room3.createRangedWeapon("rifle", "causes 2 damage", 2,5);
        room3.createMeleeWeapon("axe", "causes 3 damage", 2);
        room3.createEnemy("brian","big hairy fella",10, new MeleeWeapon("his voice","annoying",1),room3);


        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.setWest(null);
        room4.setEast(null);
        room4.createFood("pills", "effect unknown", +1);

        room5.setEast(null);
        room5.setWest(null);
        room5.setNorth(null);
        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.setWest(null);
        room6.setEast(null);

        room7.setNorth(room4);
        room7.setEast(room8);
        room7.setWest(null);
        room7.setSouth(null);
        room7.createItem("key","for opening locked doors");

        room8.setEast(room9);
        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setSouth(null);

        room9.setNorth(room6);
        room9.setEast(null);
        room9.setSouth(null);
        room9.setWest(room8);

        /*Item item1 = new Item("Map", "an old map over the spaceship");
        Item item2 = new Item("Flashlight", "great for dark rooms");
        Item item3 = new Item("Keys", "hanging on the wall, useful for opening door");
        Item item4 = new Item("Pills","lies on the table",-5);
        Item item5 = new Item("Rifle","without any ammunition");
        Item item6 = new Item("Axe","hanging on the wall");
        Item item7 = new Item("Ammunition","might become usefull");


        room1.addItem(item1);
        room6.addItem(item2);
        room8.addItem(item3);
        room4.addItem(item4);
        room3.addItem(item5);
        room3.addItem(item6);
        room8.addItem(item7);*/


        starterRoom = room1;

    }


    public ArrayList<Item> getItems() {
        return items;
    }

    public Room getStarterRoom() {
        return starterRoom;
    }


}
