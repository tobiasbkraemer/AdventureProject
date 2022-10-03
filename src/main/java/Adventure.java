import java.util.ArrayList;

public class Adventure {
    private Player player;
    private Map map = new Map();

    public Adventure () {
        map.createMap();
        player = new Player();
        player.setCurrentRoom(map.getStarterRoom());
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public boolean go(String direction){
        return player.move(direction);
    }


}

