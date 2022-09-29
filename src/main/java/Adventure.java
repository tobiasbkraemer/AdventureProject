public class Adventure {
    private Player player;
    private Map map = new Map();

    public Adventure () {
        map.createMap();
        player = new Player();
        player.setCurrentRoom(map.getStarterRoom());
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public boolean goWest() {
        if (currentRoom.getWestRoom() != null) {
            currentRoom = currentRoom.getWestRoom();
            return true;
        } else {
            System.out.println("The path is blocked!");
            return false;
        }
    }

    public boolean goEast() {
        if (currentRoom.getEastRoom() != null) {
            currentRoom = currentRoom.getEastRoom();
            return true;
        } else {
            System.out.println("The path is blocked!");
            return false;
        }
    }
}

