import java.util.Scanner;


public class UserInterface {
    Scanner sc = new Scanner(System.in);
    private Adventure adventure;

    public void startProgram() {
        adventure = new Adventure();
        welcome();

    }

    public void welcome() {
        System.out.println("-".repeat(30) + "\n" + "Welcome on board the spaceship! \n"
                + "-".repeat(30) + "\nFeel free to look around. Just let me know if you need any help.");
        handleInput();
    }

    public void handleInput(String input) {


        while (!input.equals("exit")) {
            input = sc.nextLine();
            String[] inputSplit = input.split(" ");
            String command = inputSplit[0];
            String direction = "";

            if (inputSplit.length > 1){
                direction = inputSplit[1];
            }

            switch (command) {
                case "s", "walk south", "south", "go south":
                    if (adventure.go("south")) {
                        System.out.println("Going south" + "\n" + adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("The path is blocked");
                    }
                    break;
                case "w", "west", "go west", "walk west":
                    if (adventure.go("west")) {
                        System.out.println("Going west" + "\n" + adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("The path is blocked");
                    }
                    break;
                case "e", "east", "go east", "walk east":
                    if (adventure.go("east")) {
                        System.out.println("Going east" + "\n" + adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("The path is blocked");
                    }
                    break;
                case "n", "north", "go north", "walk north":
                    if (adventure.go("north")) {
                        System.out.println("Going north" + "\n" + adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("The path is blocked");
                    }
                    break;
                case "look":
                    System.out.println("This is " + adventure.getCurrentRoom().getRoomName());
                    System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    System.out.println(adventure.getCurrentRoom().getRoomItems());
                    break;
                case "help", "help me", "instruction", "instructions", "command", "commands":
                    showHelp();
                    break;

                case "take":
                    Item itemTaken = adventure.getPlayer().getCurrentRoom().removeItem(direction);
                    if (itemTaken == null) {
                        System.out.println("The item doesn't exist");
                    } else {
                        System.out.println("You grabbed " + itemTaken.getItemName()+" for your inventory");
                        adventure.getPlayer().addItem(itemTaken);
                    }
                    break;

                case "drop":
                    Item itemDropped = adventure.getPlayer().removeItem(direction);
                    if (itemDropped == null) {
                        System.out.println("The item doesn't exist");
                    } else {
                        System.out.println("You just dropped " + itemDropped.getItemName()+ " from you inventory");
                        adventure.getPlayer().getCurrentRoom().addItem(itemDropped);
                    }
                    break;

                case "inventory", "inv":
                    if (adventure.getPlayer().getInventory().isEmpty()) {
                        System.out.println("There is nothing in your inventory :(");
                    } else {
                        System.out.println("Items in your inventory: "+"\n"+adventure.getPlayer().getInventory());
                    }
                    break;


                case "exit":
                    System.out.println("Ending program...");
                    endProgram();
                    break;
                case "die":
                    System.out.println("You die...");
                    endProgram();
                    break;
                case "hit":
                    System.out.println("You hit yourself");
                    break;
                default:
                    System.out.println("Input invalid. Try again you moron.");
                    break;
            }
        }

    }

    public void showHelp() {
        System.out.println("""
                Directions:
                Type s, south, go south, walk south to go south
                Type n, north, go north, walk north to go north
                Type w, west, go west, walk west to go west
                type e, east, go east, walk east to go east
                
                Commands:
                Type look to see what room you are in, and a description of your surroundings
                Type exit or die to exit the game
                Type an item's name to use a item in your inventory
                Type hit to hit yourself
                Type punch to punch yourself
                Type spit to spit on yourself
                Type fart to fart""");

    }

    public void endProgram() {
        System.exit(1);
        System.out.println("Ending program...");
    }
}
