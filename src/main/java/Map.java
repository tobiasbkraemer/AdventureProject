import java.util.ArrayList;

public class Map {
private Room starterRoom;

    public Room getStarterRoom() {
        return starterRoom;
    }
    public void createMap() {
        Room room1 = new Room("room1", "You are in the navigation-room, here is dusty and there is spiderwebs in every corner. In the middle of the room there is a table with a map over the whole spaceship.");
        Room room2 = new Room("room2", "You are in the weapon arsenal, all kinds of weapons are covering the floor. Loads of guns and knifes but no ammo for the guns.");
        Room room3 = new Room("room3", "You are in the Cafeteria. Here smells like dogwater, and coffee beans.");
        Room room4 = new Room("room4", "You are in Med bay, here lies some old medicin... not sure if it works correctly anymore...");
        Room room5 = new Room("room5", "You are in the toilet, it stinks of old dogwater. There is a wierd sound coming from the toilet... prepare yourself!");
        Room room6 = new Room("room6", "You are in Shields, big shields everywhere on the walls... might be useful.");
        Room room7 = new Room("room7", "You are in lower engine. You hear some metallic creeks from the ceiling, get ready for combat!");
        Room room8 = new Room("room8", "You are in Storage, it is completely dark.");
        Room room9 = new Room("room9", "You are in the communication-room, there is a strange sound coming from the radio.");
        
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.setWest(null);
        room1.setNorth(null);

        room2.setWest(room1);
        room2.setEast(room3);
        room2.setNorth(null);
        room2.setSouth(null);

        room3.setWest(room2);
        room3.setSouth(room6);
        room3.setNorth(null);
        room3.setEast(null);

        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.setWest(null);
        room4.setEast(null);

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

        Item item1 = new Item("Pills", "older then dogwater");
        Item item2 = new Item("Dogwater", "Smells");
        Item item3 = new Item("Dogwater", "Smells");
        Item item4 = new Item("Dogwater", "Smells");
        Item item5 = new Item("Dogwater", "Smells");
        Item item6 = new Item("Dogwater", "Smells");
        Item item7 = new Item("Dogwater", "Smells");

        room1.addItem(item1);

        starterRoom = room1;

    }


    public ArrayList<Item> getItems() {
        return items;
    }

    public Room getStarterRoom() {
        return starterRoom;
    }


}
