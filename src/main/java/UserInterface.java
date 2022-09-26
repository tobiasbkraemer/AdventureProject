import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);

    public void startProgram() {
        welcome();
    }

    public void welcome() {
        System.out.println("Welcome to the spaceship! \n"
                + "-".repeat(30) + "\nWhere to go? Go south or west");
        direction();
    }

    public void direction() {
        String input = "";
        while (!input.equals("exit")) {
            input = sc.nextLine();
            switch (input) {
                case "s":
                    System.out.println("Going south");
                    break;
                case "w":
                    System.out.println("Going west");
                    break;
                case "e":
                case "n":
                    System.out.println("The path is blocked! Try again");
                    break;
                case "exit":
                    endProgram();
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
