public class Room {
    private String south;
    private String north;
    private String east;
    private String west;

    Room room1 = new Room(name,disc );
    Room room2 = new Room(name,disc );
    Room room3 = new Room(name,disc );
    Room room4 = new Room(name,disc );
    Room room5 = new Room(name,disc );
    Room room6 = new Room(name,disc );
    Room room7 = new Room(name,disc );
    Room room8 = new Room(name,disc );
    Room room9 = new Room(name,disc );

    room1.setEast(room2);
    room1.setsouth(room4);
    room2.setWest(room1);
    room2.setEast(room3);
    room3.setWest(room2);
    room3.setSouth(room6);
    room4.setNorth(room1);
    room4.setSouth(room7);
    room5.setEast(room6);
    room6.setNorth(room3);
    room6.setWest(room5);
    room6.setSouth(room9);
    room7.setNorth(room4);
    room7.setEast(room8);
    room8.setEast(room9);
    room8.setWest(room7);
    room9.setNorth(room6);
    room9.setWest(room8);





    public void setEast(String east) {
        this.east = east;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public void setWest(String west) {
        this.west = west;
    }
}
