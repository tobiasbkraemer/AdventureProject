import java.util.ArrayList;

public class Map {
    private Room starterRoom;
    ArrayList<Item> items = new ArrayList<>();

    public void createMap() {
        Room room1 = new Room("Navigation", "This is the main room of the spaceship. In the middle of the room there is a table with a map over the whole spaceship.");
        Room room2 = new Room("Cafeteria", "This is the Cafeteria. It's surprisingly clean in here, but there is a weird smell. On the table in front of you lies an apple. Looks suspicious");
        Room room3 = new Room("Weapon arsenal", "This is the weapon arsenal, there is a semi automatik riffle hanging on the wall, next to a big axe.");
        Room room4 = new Room("Medical", "This is the medical room. It's filled with unknown pills. We don't know the effect, but they could be useful.");
        Room room5 = new Room("Toilet", "This is the toilets, it stinks of dogwater. There is a weird sound coming from the toilet.");
        Room room6 = new Room("Electrical", "This is electrical. It seems like this room connect and give power to the rest of the spaceship.");
        Room room7 = new Room("Engine", "This is the engine room. A loud constant noise fills the room, as the engine is working at maximum speed.");
        Room room8 = new Room("Storage", "Even though it is completely dark in Storage, you can almost feel the spiderwebs hanging from the ceiling and dust covering every surface. There may be some useful things in here, but it's too dark to see.");
        Room room9 = new Room("Communication", "You are in the communication-room. This is where all contact in and out the spaceship takes place.");

        room1.setEast(room2);
        room1.setSouth(room4);
        room1.setWest(null);
        room1.setNorth(null);

        room2.setWest(room1);
        room2.setEast(room3);
        room2.setNorth(null);
        room2.setSouth(null);
        room2.createFood("Apple","may be poisonous or healthy",-1);

        room3.setWest(room2);
        room3.setSouth(room6);
        room3.setNorth(null);
        room3.setEast(null);

        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.setWest(null);
        room4.setEast(null);
        room4.createFood("Pills","effect unknown",+1);

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
