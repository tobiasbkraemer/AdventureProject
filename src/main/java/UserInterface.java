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
        System.out.println("-".repeat(110) + "\n" + "Thanks God! You finally woke up after we crashed. "+"\n" +
                "We have ended up on a strange planet. The engines don't work and all our crewmates are gone. "+"\n" +
                "You have to find them and restart the engines so we can get get off this planet. " +"\n"+
                "But watch out, because I think there are other unidentified life forms on board the space ship. \n"
                + adventure.getCurrentRoom().getRoomDescription()
                + "\nFeel free to look around. Let me know if you need any help."+"\n"+ "-".repeat(110));
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
                            System.out.println("You equipped " + userInput + " and are now ready for combat!");
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
                            System.out.println("You unequipped " + userInput);
                        }
                        case CANT -> System.out.println(userInput + " cant be unequipped");
                        case NOT_FOUND -> System.out.println(userInput + " cant be found in your inventory");
                    }
                    break;

                case "inventory", "inv", "Inv", "Inventory":
                    if (adventure.getPlayer().getInventory().isEmpty()) {
                        System.out.println("There is nothing in your inventory :(");
                    } else {
                        System.out.println("Inventory: " + "\n");
                        for (Item item : adventure.getPlayer().getInventory()) {
                            System.out.println(item.getItemName());
                            System.out.println(item.getItemDescription());
                        }
                    }
                    break;

                case "weapons", "Weapons", "ei":
                    if (adventure.getPlayer().getEquippedWeapon() == null) {
                        System.out.println("You haven't equipped anything :(");
                    } else {
                        System.out.println("Weapons equipped: ");
                        System.out.println(adventure.getPlayer().getEquippedWeapon().getItemName());
                    }
                    break;

                case "exit", "Exit":
                    System.out.println("Ending program...");
                    endProgram();
                    break;

                case "die", "Die", "gu", "give up":
                    System.out.println("Nooo! You gave up...");
                    endProgram();
                    break;

                case "attack", "Attack","Shoot","shoot","swing","Swing":

                    AttackCommands attack = adventure.playerAttack(userInput);
                    Item searchEquippedWeapon = adventure.getEquippedWeapon();
                    Item equippedWeapon = adventure.getItem(userInput);

                    if (attack == AttackCommands.Attack_Enemy) {
                        System.out.println("Enemy was attacked. " + ((Weapon) searchEquippedWeapon).getDamage() + " damage dealt.");
                        System.out.println("Ouch! The enemy struck back.");
                        System.out.println("Your current health: "+adventure.getPlayer().getHealth()+" HP");
                        for (Enemy enemy : adventure.getCurrentRoom().getEnemies()) {
                            System.out.println("Alien current health: " + enemy.getHealthPoints());
                        }
                        if (((Weapon) searchEquippedWeapon).getRemainingAmmo()!=0)
                        System.out.println(((Weapon) searchEquippedWeapon).getRemainingAmmo() + " shots left");
                        if (adventure.getPlayer().getHealth()<=0) {
                            System.out.println("Game over - You died");
                            endProgram();
                        }


                    } else if (attack == AttackCommands.Enemy_Dead) {
                        System.out.println("Congrats! "+userInput + " has been slayed. Our crewmates are free and we can finally restart the spaceship's engines and get off this terrifying planet!");

                    } else if (attack == AttackCommands.No_Enemy) {
                        System.out.println("There is no threats in here");

                    }else if (attack == AttackCommands.No_Ammo) {
                        System.out.println("Oh no! You are out of ammo");

                    } else if (attack == AttackCommands.No_Weapon_Equipped) {
                        System.out.println("You dont have " + equippedWeapon + " equipped");

                    } else {
                        System.out.println("Input invalid. Try again");
                    }

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
                Type eat + food name, to eat food
                Type Equip followed by a weapon to equip it
                Type Unequip followed by a enquipped weapon to unequip it
                Type Weapons to see equipped weapons
                Type inv or inventory, to see your inventory
                Type drop + item name, to drop an item
                Type health or hp to see current health 
                """);

    }

    public void endProgram() {
        System.exit(1);
        System.out.println("Ending program...");
    }
}
