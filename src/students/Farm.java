package students;

import java.util.Scanner;
import students.items.*;

public class Farm {
    private Field field;
    private double startingFunds;

    public Farm(int fieldWidth, int fieldHeight, double startingFunds) {
        this.field = new Field(fieldWidth, fieldHeight);
        this.startingFunds = startingFunds;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean gameIsRunning = true;

        while (gameIsRunning) {
            System.out.println(field.toString());
            System.out.println();
            System.out.println("Bank balance: $" + startingFunds);
            System.out.println();
            System.out.println("Enter your next action:");
            System.out.println("  t x y: till");
            System.out.println("  h x y: harvest");
            System.out.println("  p x y: plant");
            System.out.println("  s: field summary");
            System.out.println("  w: wait");
            System.out.println("  q: quit");
            System.out.println();

            String playerInput = scanner.nextLine();
            String[] inputParameters = playerInput.trim().split(" ");
            if (inputParameters.length > 0) {
                String action = inputParameters[0];
                int x = 0;
                int y = 0;
                
                // A length of index 1 is equivalent to having 2 values, which would be the command at 0 and x coordinate at 1
                if (inputParameters.length > 1) {
                    x = Integer.parseInt(inputParameters[1]);
                }
                // A length of index 2 is equivalent to having 3 values, which would be the command and both coordinates. Index 2 is the 3rd value, coordinate y.
                if (inputParameters.length > 2) {
                    y = Integer.parseInt(inputParameters[2]);
                }

                if ("t".equals(action)) {
                	// Checking of there are 3 values, if not they are asked to enter a sufficient amount of inputs.
                    if (inputParameters.length < 3) {
                        System.out.println("Missing coordinates. Please enter 't x y'.");
                    } else {
                        field.till(y - 1, x - 1); // Because if the user inputs "1" they actually want the first value which is index "0"
                        System.out.println("Tilled soil at coordinates (" + x + ", " + y + ").");
                    }
                }
            }
        }
    }
}
