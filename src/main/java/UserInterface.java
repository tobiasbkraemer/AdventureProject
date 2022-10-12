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
                case "s", "S", "south", "South":
                    if (adventure.go("south")) {
                        System.out.println("Going south" + "\n" + adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("The path is blocked");
                    }
                    break;
                case "w", "west", "West", "W":
                    if (adventure.go("west")) {
                        System.out.println("Going west" + "\n" + adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("The path is blocked");
                    }
                    break;
                case "e", "E", "East", "east":
                    if (adventure.go("east")) {
                        System.out.println("Going east" + "\n" + adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("The path is blocked");
                    }
                    break;
                case "n", "north", "North", "N":
                    if (adventure.go("north")) {
                        System.out.println("Going north" + "\n" + adventure.getCurrentRoom().getRoomDescription());
                    } else {
                        System.out.println("The path is blocked");
                    }
                    break;

                case "health", "hp", "Hp", "Health":
                    System.out.println("Currently you have " + adventure.getPlayer().getHealth() + " health");
                    break;

                case "look", "Look":
                    System.out.println("This is " + adventure.getCurrentRoom().getRoomName());
                    System.out.println(adventure.getCurrentRoom().getEnemies());
                    //System.out.println(adventure.getCurrentRoom().getRoomDescription());
                    if (!adventure.getPlayer().getCurrentRoom().getRoomItems().isEmpty()) {
                        for (Item item : adventure.getPlayer().getCurrentRoom().getRoomItems()) {
                            System.out.println(item.getItemName() + ", " + item.getItemDescription());

                        }
                    }
                    if (!adventure.getCurrentRoom().getEnemies().isEmpty()) {
                        for (Enemy enemy : adventure.getCurrentRoom().getEnemies()) {
                            System.out.println(enemy.getName() + " is nearby, HP: " + enemy.getHealthPoints());
                        }
                    }
                    break;

                case "help", "Help", "instruction", "instructions", "command", "commands":
                    showHelp();
                    break;

                case "take", "Take":
                    Item itemTaken = adventure.playerTakeItem(userInput);
                    if (itemTaken == null) {
                        System.out.println("The item doesn't exist");
                    } else {
                        System.out.println("You grabbed " + itemTaken.getItemName() + " for your inventory");
                    }
                    break;


                case "drop", "Drop":
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

                case "equip", "Equip", "eq", "Eq":
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

                case "unequip", "Unequip", "ueq":
                    result = adventure.playerUnEquip();
                    switch (result) {
                        case OK -> {
                            System.out.println("you unequipped " + userInput);
                        }
                        case CANT -> System.out.println(userInput + " cant be unequipped");
                        case NOT_FOUND -> System.out.println(userInput + " cant be found in your inventory");
                    }
                    break;

                case "inventory", "inv", "Inv", "Inventory":
                    if (adventure.getPlayer().getInventory().isEmpty()) {
                        System.out.println("There is nothing in your inventory :(");
                    } else {
                        System.out.println("\"Inventory: " + "\n");
                        for (Item item : adventure.getPlayer().getInventory()) {
                            System.out.println(item.getItemName());
                        }
                    }
                    break;

                case "weapons", "Weapons", "ei":
                    if (adventure.getPlayer().getEquippedWeapon() == null) {
                        System.out.println("You haven't equipped anything :(");
                    } else {
                        System.out.println("Weapons you have equipped: ");
                        System.out.println(adventure.getPlayer().getEquippedWeapon().getItemName());
                    }
                    break;

                case "exit", "Exit":
                    System.out.println("Ending program...");
                    endProgram();
                    break;
                case "die", "Die":
                    System.out.println("You commit Suicide...");
                    endProgram();
                    break;
                case "attack", "Attack":
                    AttackCommands attackResult;
                    attackResult = adventure.playerAttack(userInput);
                    switch (attackResult) {
                        case No_Enemy -> System.out.println("No threats in here");
                        case No_Such_Enemy -> {
                            System.out.println("Enemy doesn't exist");
                        }

                        case No_Ammo -> System.out.println("That's not a weapon");
                        case No_Weapon_Equipped -> System.out.println("You have no weapons equipped");
                        case Attack_Enemy -> {

                            Enemy enemy1 = adventure.getCurrentRoom().getEnemies().get(0);
                            if (!adventure.getPlayer().isDead()) {
                                System.out.println("you attacked " + enemy1.getName() + " with " + adventure.getPlayer().getEquippedWeapon().getItemName());

                                if (userInput.toLowerCase().equals(adventure.getCurrentRoom().getEnemies().get(0).getName())) {
                                    System.out.println(enemy1.getName() + "HP: " + enemy1.getHealthPoints());
                                }

                                for (Enemy enemy : adventure.getCurrentRoom().getEnemies()) {
                                    System.out.println(enemy.getName() + " HP: " + (enemy.getHealthPoints() - adventure.getPlayer().getEquippedWeapon().getDamage()));
                                }
                                System.out.println("you got hit by " + userInput + "!");
                                System.out.println("your health is now " + adventure.getPlayer().getHealth() + " HP");
                            } else {
                                System.out.println("you are dead, goodbye!!!");
                                System.exit(1);
                            }
                        }

                    }
                    break;


                case "spit", "Spit":
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
                Type s, S, south, South to go south
                Type n, N, north, North to go north
                Type w, W, west, West to go west
                type e, E, east, East to go east
                                
                Commands:
                Type look to see what room you are in, and a description of your surroundings
                Type exit or die to exit the game
                Type eat to eat a food
                Type Equip followed by a weapon to equip it
                Type Unequip followed by a enquipped weapon to unequip it
                Type Weapons to see equipped weapons
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
