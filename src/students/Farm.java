package students;

import java.util.Scanner;
import students.items.*;

public class Farm {
    private Field field;
    private double startingFunds;
    private boolean hasUberTiller = false;
    private boolean uberTillerActive = false;
    private int turnCount = 0;

    // This is just the farm's constructor method.
    public Farm(int fieldWidth, int fieldHeight, double startingFunds) {
        this.field = new Field(fieldWidth, fieldHeight);
        this.startingFunds = startingFunds;
    }

    // This makes the game run & enacts the gameplay loop.
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean gameIsRunning = true;

        // This the basic game loop 
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
            System.out.println("  u: !uber till!");
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
                    // Checking if there are 3 values, if not they are asked to enter a sufficient amount of inputs.
                    if (inputParameters.length < 3) {
                        System.out.println();
                        System.out.println("...");
                        System.out.println();
                        System.out.println("You thought intently about tilling but entered the [procrastinate] state, so your brain only got halfway there.");
                        System.out.println();
                        System.out.println("You've already lost the time allocated to this turn, but to fully carry out the tilling process on your next attempt, input t x y.");
                        System.out.println();
                        System.out.println("...");
                        System.out.println();
                    } else {
                        field.till(y - 1, x - 1); // Because if the user inputs "1" they actually want the first value which is index "0"
                        System.out.println("...");
                        System.out.println();
                        System.out.println("You turn was expended on your decision to till at coordinates (" + x + ", " + y + ").");
                        System.out.println();
                    }
                } else if ("h".equals(action)) {
                    if (inputParameters.length < 3) {
                        System.out.println();
                        System.out.println("...");
                        System.out.println();
                        System.out.println("You thought intently about harvesting but entered the [procrastinate] state, so your brain only got halfway there.");
                        System.out.println();
                        System.out.println("You've already lost the time allocated to this turn, but to fully carry out the harvesting process on your next attempt, input t x y.");
                        System.out.println();
                        System.out.println("...");
                        System.out.println();
                    } else {
                        x = Integer.parseInt(inputParameters[1]);
                        y = Integer.parseInt(inputParameters[2]);
                        // Harvesting from the specified location
                        Item item = field.get(y - 1, x - 1);
                        if (item instanceof Food && item.getAge() >= item.getMaturationAge()) {
                            double value = item.getValue();
                            startingFunds += value;
                            field.till(y - 1, x - 1);
                            System.out.println("Harvested food at coordinates (" + x + ", " + y + "). Added $" + value + " to your funds.");
                        } else {
                            System.out.println();
                            System.out.println("...");
                            System.out.println();
                            System.out.println("No harvestable food at coordinates (" + x + ", " + y + ").");
                            System.out.println();
                            System.out.println("And while you were busy harvesting nothing, the passage of time continued!");
                            System.out.println();
                            
                        }
                    }
                } else if ("p".equals(action)) {
                    if (inputParameters.length < 3) {
                        System.out.println();
                        System.out.println("...");
                        System.out.println();
                        System.out.println("You thought intently about planting but entered the [procrastinate] state, so your brain only got halfway there.");
                        System.out.println();
                        System.out.println("You've already lost the time allocated to this turn, but to fully carry out the planting process on your next attempt, input t x y.");
                        System.out.println();
                        System.out.println("...");
                        System.out.println();
                    } else {
                        x = Integer.parseInt(inputParameters[1]);
                        y = Integer.parseInt(inputParameters[2]);
                        // This should just prompt the user to select what to buy (and plant)
                        System.out.println();
                        System.out.println("Enter either:");
                        System.out.println(" - 'a' to buy an apple");
                        System.out.println("OR");
                        System.out.println(" - 'g' to buy grain");
                        String buyOption = scanner.nextLine();
                        if (buyOption.equals("a")) {
                            if (startingFunds < Apples.getAppleCost()) {
                                System.out.println("You wasted your turn on going to the shops and trying to buy an apple without the funds to do so.");
                            } else {
                                field.plant(y - 1, x - 1, new Apples());
                                startingFunds -= Apples.getAppleCost();
                                System.out.println();
                                System.out.println();
                                System.out.println("The turn passes via the natural passage of time, due to the decision you made to try planting an apple at coordinates (" + x + ", " + y + ").");
                                System.out.println();
                                
                            }
                        } else if (buyOption.equals("g")) {
                            if (startingFunds < Grain.getGrainCost()) {
                                System.out.println();
                                System.out.println("You wasted your turn on going to the shops and trying to buy grain without the funds to do so.");
                                System.out.println();
                            } else {
                                field.plant(y - 1, x - 1, new Grain());
                                startingFunds -= Grain.getGrainCost();
                                System.out.println();
                                System.out.println();
                                System.out.println("The turn passes via the natural passage of time, due to the decision you made to try planting some grain at coordinates (" + x + ", " + y + ").");
                                System.out.println();
                            }
                        } else {
                            System.out.println();
                            System.out.println("...");
                            System.out.println();
                            System.out.println("You decided to go to the shops and couldn't narrow down your choice on buying either an apple or grain.");
                            System.out.println();
                            System.out.println();
                            System.out.println("...");
                            System.out.println();
                            System.out.println("You come back to your farm, noticing that it has visibily changed.");
                            System.out.println();
                        }
                    }
                } else if ("s".equals(action)) {
                    System.out.println("One intense loading screen later...");
                    System.out.println();
                    System.out.println("CURRENT FARM STATE:");
                    field.getSummary();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("While you were busy obsessing over your farm's stats, the passage of time continued! \nDon't forget to take care of your farm!");
                    System.out.println();
                } else if ("w".equals(action)) {
                    System.out.println();
                    System.out.println("...");
                    System.out.println();
                    System.out.println("You decided to wait and watch your farm intently.");
                    System.out.println();
                } else if ("u".equals(action) && (!uberTillerActive)) {
                    activateUberTiller();
                } else if ("u".equals(action) && uberTillerActive) {
                    System.out.println("You have an Uber Tiller running and lost track of time while watching it do its magic.");
                    System.out.println();
                    System.out.println();
                } else if ("q".equals(action)) {
                    gameIsRunning = false;
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println("...");
                    System.out.println("You decided to do work unrelated to the farm. Your farm underwent changes while you were gone!");
                    System.out.println();
                    
                }

                
                
                field.tick(); // Ticks after every action..
                // Increment turnCount if Uber Tiller is active
                if (uberTillerActive) {
                    field.useUberTill();
                	turnCount++;
                	startingFunds += 5;
                	System.out.println("+ + + +");
                	System.out.println();
                	System.out.println("Your clean your farm  was rewarded with nice cash bonus of $5");
                	System.out.println();
                    if (turnCount >= 3) {
                        // Disable Uber Tiller and resets the turnCount when max turns reached
                        uberTillerActive = false;
                        turnCount = 0;
                        System.out.println();
                        System.out.println("!!!");
                        System.out.println("BUST CLANK SHUTTER");
                        System.out.println();
                        System.out.println("...");
                        System.out.println("The Uber Tiller got jammed with weeds and doesn't work anymore, so you discard it.");
                        System.out.println();
                        System.out.println();
                        System.out.println("Weed growth will resume after this turn.");
                        System.out.println();
                        hasUberTiller = false; // Throws the Uber Tiller away after it breaks
                    }
                }
            }
        }

        // These should print whenever the game stops running.
        System.out.println("!");
        System.out.println();
        System.out.println("In a bizzare fit of rage, you decided to eviscerate your farm with a flamethrower! It's gone now.");
        System.out.println();
        System.out.println("It's gone now, but feel free to make a new one the next time you play Dennis' super awesome farm simulator! :D");
        System.out.println("...");
    }

    public void activateUberTiller() {
        if (!hasUberTiller) {
            System.out.println("!!!");
            System.out.println();
            System.out.println("Tired of weeds? Look no further than the Uber Tiller!\nAt a purchase price of $12:\nIt is said that this machine halts weed growth for 3 full turns! \nHowever, it is a highly experimental prototype and a costly one at that, with a warranty that also expires after 3 turns.");
            System.out.println();
            System.out.println("...");
            System.out.println("Your eyes gleam at the sight of the Uber Tiller's beautiful space grey exterior.");
            System.out.println();
            System.out.println();
            System.out.println("You instinctively reach for your wallet. Will you purchase such a device and make your farm beautiful again? [y] [n]");

            Scanner scanner = new Scanner(System.in);
            String purchaseChoice = scanner.nextLine();

            if ("y".equals(purchaseChoice) && startingFunds >= 12) {
                System.out.println();
                System.out.println("!!!");
                System.out.println("YOU HAVE OBTAINED THE UBER TILLER. Use the 'u' action again to activate it!");
                System.out.println();
                startingFunds -= 12;
                hasUberTiller = true;
            } else if ("y".equals(purchaseChoice) && startingFunds < 12) {
                System.out.println();
                System.out.println("...");
                System.out.println("You walk home, looking at your account balance in shame as you didn't have enough money to buy the Uber Tiller.\nThe thought of getting one stays in your head.");
                System.out.println();
                System.out.println();
            } else if ("n".equals(purchaseChoice)) {
                System.out.println();
                System.out.println("...");
                System.out.println("You decide to hold on to the cash you have. You don't have the Uber Tiller, but keep the idea of buying one in your head.");
                System.out.println();
                System.out.println();
            } else {
                System.out.println();
                System.out.println("...");
                System.out.println("You couldn't come to a solid yes [y] or no [n] decision. Thus, you went back over to your farm empty-handed.");
                System.out.println();
                System.out.println();
            }
        } else {
            System.out.println("Activate the Uber Tiller? [y] [n]");
            Scanner scanner = new Scanner(System.in);
            String activationChoice = scanner.nextLine();

            if ("y".equals(activationChoice)) {
                System.out.println();
                System.out.println("...");
                System.out.println("You look at your farm and decide that it's uber tilling time, then till all over the place.");
                System.out.println();
                uberTillerActive = true;
                turnCount = 0; // Resetting turnCount when Uber Tiller is activated
            } else if ("n".equals(activationChoice)) {
            	System.out.println();
                System.out.println("...");
                System.out.println("You reach for your Uber Tiller but decide against using it for now.... With great power comes great responsibility.");
                System.out.println();
                System.out.println();
            } else {
            	System.out.println();
                System.out.println("...");
                System.out.println("You couldn't decide on if you did [y] or did not [n] want to use the Uber Tiller,\nYou simply packed it away, letting nature run its course.");
                System.out.println();
                System.out.println();
            }
        }
    }
}
