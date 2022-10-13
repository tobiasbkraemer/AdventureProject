import java.util.ArrayList;

public class Map {
    private Room starterRoom;
    ArrayList<Item> items = new ArrayList<>();

    public void createMap() {
        Room room1 = new Room("Navigation", "This is the main room of the spaceship. In the middle of the room there is a table with a map of the spaceship.");
        Room room2 = new Room("Cafeteria", "This is the Cafeteria. It's surprisingly clean in here, but there is a weird smell. It looks like old food on the table in front of you");
        Room room3 = new Room("Weapon arsenal", "This is the weapon arsenal, there is a rifles hanging on the wall, next to some big axes.");
        Room room4 = new Room("Medical", "This is the medical room. It's filled with unknown pills. the label is teared off, cant read the effects, but they could be useful.");
        Room room5 = new Room("Engine", "\"ARAARARGH!!!\" In the center of the engine room stands an alien guarding the crew mates and the engines. Equip a weapon and defeat the alien! "+"\n"+"But be careful, because it looks like the alien might fight back.");
        Room room6 = new Room("Electrical", "This is electrical. It looks like the power-source to the spaceship.");
        Room room7 = new Room("Dormitory","This is the dormitory. The room is full of beds. It's quiet in here, but that's rarely a good sign.");
        Room room8 = new Room("Storage", "Even though it is completely dark in Storage, you can almost feel the spiderwebs hanging from the ceiling and dust covering every surface. There may be some useful things in here, but it's too dark to see.");
        Room room9 = new Room("Communication", "You are in the communication-room. This is where all contact in and out the spaceship takes place.");

        // Navigation
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.setWest(null);
        room1.setNorth(null);
        room1.createItem("map","according to the map, you have to go through storage to get to the engines");

        // Cafeteria
        room2.setWest(room1);
        room2.setEast(room3);
        room2.setNorth(null);
        room2.setSouth(null);
        room2.createFood("food", "old, may be poisonous or healthy", -1);

        // Weapon arsenal
        room3.setWest(room2);
        room3.setSouth(room6);
        room3.setNorth(null);
        room3.setEast(null);
        room3.createRangedWeapon("rifle", "deals 2 damage per shot", 2,5);
        room3.createMeleeWeapon("axe", "deals 4 damage per swing", 4);

        // Medical
        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.setWest(null);
        room4.setEast(null);
        room4.createFood("pills", "effect unknown", +10);

        // Last room - Engine
        room5.setEast(null);
        room5.setWest(null);
        room5.setNorth(null);
        room5.setSouth(room8);
        room5.createEnemy("alien","huge and frightening",14, new MeleeWeapon("has large claws","deadly",3),room5);

        // Electrical
        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.setWest(null);
        room6.setEast(null);

        // Dormitory
        room7.setNorth(room4);
        room7.setEast(room8);
        room7.setWest(null);
        room7.setSouth(null);

        // Storage
        room8.setEast(room9);
        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setSouth(null);

        // Communication
        room9.setNorth(room6);
        room9.setEast(null);
        room9.setSouth(null);
        room9.setWest(room8);


        starterRoom = room1;

    }

    public Room getStarterRoom() {
        return starterRoom;
    }


}
