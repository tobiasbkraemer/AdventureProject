import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);
    Adventure adventure = new Adventure();
    Map map = new Map();
    Player player = new Player();


    public void startProgram() {
        welcome();

    }

    public void welcome() {
        System.out.println("-".repeat(30)+"\n"+"Welcome on board the spaceship! \n"
                + "-".repeat(30) + "\nWhere to go?");
        direction();

    }

    public void direction() {
        adventure.createRoom();

        String input = "";
        while (!input.equals("exit")) {
            input = sc.nextLine();
            switch (input) {
                case "s":
                    System.out.println("Going south");
                    adventure.goSouth();
                    System.out.println(adventure.getCurrentRoom().getDescription());
                    break;
                case "w":
                    System.out.println("Going west");
                    adventure.goWest();
                    System.out.println(adventure.getCurrentRoom().getDescription());
                    break;
                case "e":
                    System.out.println("Going east");
                    adventure.goEast();
                    System.out.println(adventure.getCurrentRoom().getDescription());
                    break;
                case "n":
                    System.out.println("Going north");
                    adventure.goNorth();
                    System.out.println(adventure.getCurrentRoom().getDescription());
                    break;
                case "look":
                    System.out.println("This is "+adventure.getCurrentRoom().getName());
                    System.out.println(adventure.getCurrentRoom().getDescription());
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


    public void endProgram() {
        System.exit(0);
        System.out.println("Ending program...");
    }


}
