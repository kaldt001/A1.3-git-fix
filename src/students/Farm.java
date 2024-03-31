package students;

import java.util.Scanner;
import students.items.*;

public class Farm {
    private Field field;
    private double startingFunds;

    // This is just the constructor for the Farm class
    public Farm(int fieldWidth, int fieldHeight, double startingFunds) {
        this.field = new Field(fieldWidth, fieldHeight);
        this.startingFunds = startingFunds;
    }

    // This makes the game run
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean gameIsRunning = true;

        // The basic game loop 
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

                    if ("t".equals(action)) {
                        // Checking if there are 3 values, if not they are asked to enter a sufficient amount of inputs.
                        if (inputParameters.length < 3) {
                            System.out.println("Missing required input. Please enter 't x y'.");
                        } else {
                            field.till(y - 1, x - 1); // Because if the user inputs "1" they actually want the first value which is index "0"
                            System.out.println("Tilled soil at coordinates (" + x + ", " + y + ").");
                        }
                    } else if ("h".equals(action)) {
                        // Checking if there are 3 values, if not they are asked to enter a sufficient amount of inputs.
                        if (inputParameters.length < 3) {
                            System.out.println("Missing required input. Please enter 'h x y'.");
                        } else {
                            x = Integer.parseInt(inputParameters[1]);
                            y = Integer.parseInt(inputParameters[2]);
                            // Harvesting from the specified location
                            Item item = field.get(y - 1, x - 1);
                            if (item instanceof Food && item.getAge() >= item.getMaturationAge()) { // Checking if age is past maturation age
                                double value = item.getValue(); // Getting monetary if condition is satisfied
                                startingFunds += value; // Adding value to player's money
                                field.till(y - 1, x - 1); // Replace harvested food with soil
                                System.out.println("Harvested food at coordinates (" + x + ", " + y + "). Added $" + value + " to your funds."); //printing just to check correct values are being passed
                            } else {
                                System.out.println("No harvestable food at coordinates (" + x + ", " + y + ").");
                            }
                        }
                    } else if ("p".equals(action)) {
                        // Checking if there are 3 values, if not they are asked to enter a sufficient amount of inputs.
                        if (inputParameters.length < 3) {
                            System.out.println("Missing required input. Please enter 'p x y'.");
                        } else {
                            x = Integer.parseInt(inputParameters[1]);
                            y = Integer.parseInt(inputParameters[2]);
                            // This should just prompt the user to select what to buy (and plant)
                            System.out.println("Enter either:");
                            System.out.println(" - 'a' to buy an apple");
                            System.out.println(" - 'g' to buy grain");
                            String buyOption = scanner.nextLine();
                            if (buyOption.equals("a")) {
                                if (startingFunds < Apples.getAppleCost()) {
                                    System.out.println("You don't have enough money to buy an apple.");
                                } else {
                                    field.plant(y - 1, x - 1, new Apples());
                                    startingFunds -= Apples.getAppleCost();
                                    System.out.println("Planted an apple at coordinates (" + x + ", " + y + ").");
                                }
                            } else if (buyOption.equals("g")) {
                                if (startingFunds < Grain.getGrainCost()) {
                                    System.out.println("You don't have enough money to buy grain.");
                                } else {
                                    field.plant(y - 1, x - 1, new Grain());
                                    startingFunds -= Grain.getGrainCost();
                                    System.out.println("Planted grain at coordinates (" + x + ", " + y + ").");
                                }
                            } else {
                                System.out.println("Invalid option. Please choose 'a' or 'g'.");
                            }
                        }
                    } else if ("s".equals(action)) {
                        field.getSummary();
                    } else if ("w".equals(action)) {
                        field.tick();
                    } else if ("q".equals(action)) {
                        gameIsRunning = false;
                    } else {
                        System.out.println("Invalid action. Please try again.");
                    }
                }
            }
        }
        // This should print whenever the game stops running.
        System.out.println("GG, come back later!");
    }
}
