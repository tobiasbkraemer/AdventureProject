public class Room {
    private Room south;
    private Room north;
    private Room east;
    private Room west;
    private String name;
    private String description;


    public Room (String name, String description) {
        this.name =name;
        this.description = description;
    }

    public String getDescription () {
        return description;

    }

    public String getName () {
        return name;

    }

    public Room getSouthRoom () {
        return south;
    }

    public Room getNorthRoom () {
        return north;
    }

    public Room getWestRoom () {
        return west;
    }

    public Room getEastRoom () {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }


    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setWest(Room west) {
        this.west = west;
    }
}
