import java.util.Scanner;


public class UserInterface {
    Scanner sc = new Scanner(System.in);

    private Adventure adventure;
    private Food food;
    private Weapon weapon;
    private Player player;

    public void startProgram() {
        adventure = new Adventure();
        welcome();

    }

    public void welcome() {
        System.out.println("-".repeat(30) + "\n" + "Welcome on board the spaceship! \n"
                + "-".repeat(30) + "\nFeel free to look around. Let me know if you need any help.");
        String input = "";
        handleInput(input);
    }

    public void handleInput(String input) {
        while (!input.equals("exit")) {
            input = sc.nextLine();
            String[] inputSplit = input.split(" ");
            String userInput = "";
            String command = inputSplit[0];

            if (inputSplit.length > 1) {
                userInput = inputSplit[1];
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

                case "health", "hp":
                    System.out.println("Currently you have " + adventure.getPlayer().getHealth() + " health");
                    break;

                case "look":
                    System.out.println("This is " + adventure.getCurrentRoom().getRoomName());
                    System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    if (!adventure.getPlayer().getCurrentRoom().getRoomItems().isEmpty()) {
                        for (Item item : adventure.getPlayer().getCurrentRoom().getRoomItems()) {
                            System.out.println(item.getItemName() + ", " + item.getItemDescription());
                        }
                    }
                    break;

                case "help", "instruction", "instructions", "command", "commands":
                    showHelp();
                    break;

                case "take":
                    Item itemTaken = adventure.playerTakeItem(userInput);
                    if (itemTaken == null) {
                        System.out.println("The item doesn't exist");
                    } else {
                        System.out.println("You grabbed " + itemTaken.getItemName() + " for your inventory");
                    }
                    break;


                case "drop":
                    Item itemDropped = adventure.playerDropItem(userInput);
                    if (itemDropped == null) {
                        System.out.println("The item doesn't exist");
                    } else {
                        System.out.println("You just dropped " + itemDropped.getItemName() + " from your inventory");
                    }
                    break;
                case "eat", "Eat":
                    ReturnMessage result;
                    result = adventure.playerEat(userInput);
                    switch (result) {
                        case OK -> {
                            System.out.println("You ate " + userInput);
                            System.out.println("Your health is now at: " + adventure.getPlayer().getHealth());
                        }
                        case CANT -> System.out.println(userInput + " is not edible");
                        case NOT_FOUND -> System.out.println(userInput + " cant be found in your inventory or room");
                    }
                    break;

                case "equip","eq":
                    result = adventure.playerEquip(userInput);
                    switch (result) {
                        case OK -> {
                            System.out.println("you equipped " + userInput);
                            adventure.getPlayer().equipWeapon(userInput);
                        }
                        case CANT -> System.out.println(userInput + " cant be equipped");
                        case NOT_FOUND -> System.out.println(userInput + " cant be found in your inventory");
                    }
                    break;

                case "unequip","ueq":
                    result = adventure.playerUnEquip();
                    switch (result) {
                        case OK -> {
                            System.out.println("you unequipped " + userInput);
                        }
                        case CANT -> System.out.println(userInput + " cant be unequipped");
                        case NOT_FOUND -> System.out.println(userInput + " cant be found in your inventory");
                    }
                    break;

                case "inventory", "inv":
                    if (adventure.getPlayer().getInventory().isEmpty()) {
                        System.out.println("There is nothing in your inventory :(");
                    } else {
                        System.out.println("\"Weapon Equipped: " + "\n");
                        for (Item item : adventure.getPlayer().getInventory()) {
                            System.out.println(item.getItemName());
                        }
                    }
                    break;

                case "weapons","Weapons","ei":
                    if (adventure.getPlayer().getEquippedWeapon()==null) {
                        System.out.println("You haven't equipped anything :(");
                    } else {
                        System.out.println("Weapons you have equipped: ");
                        System.out.println(adventure.getPlayer().getEquippedWeapon().getItemName());
                    }
                    break;

                case "exit":
                    System.out.println("Ending program...");
                    endProgram();
                    break;
                case "die":
                    System.out.println("You commit Suicide...");
                    endProgram();
                    break;
                case "hit":
                    //TODO Minus 1 health
                    System.out.println("You hit yourself");
                    break;
                case "punch":
                    //TODO Minus 1 health
                    System.out.println("You punch yourself");
                    break;
                case "fart":
                    //TODO Make 10/100 chance of shart which results in death
                    System.out.println("You farted");
                    break;
                case "spit":
                    System.out.println("You spit on yourself");
                    break;
                default:
                    System.out.println("Input invalid. Try again.");
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
                Type eat to eat a food
                Type inv to see inventory
                Type drop to drop a item
                Type health to see current health 
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
