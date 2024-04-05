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
    	
    	// Before the gameplay loop welcome the player and student details.
    	System.out.println();
    	System.out.println("WELCOME TO SIM FARM: **UBER TILL RELEASE**");
    	System.out.println("Author   : Dennis Kalongonda");
    	System.out.println("Stud ID  : 110403237");
    	System.out.println("Email ID : kaldt001");
    	System.out.println("This is my own work as defined by the University's Academic Misconduct Policy.");
    	System.out.println();
    	System.out.println("... Farm loading");
    	System.out.println();
    	System.out.println();

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
                if (inputParameters.length > 1) {x = Integer.parseInt(inputParameters[1]); }
                
                // A length of index 2 is equivalent to having 3 values, which would be the command and both coordinates. Index 2 is the 3rd value, coordinate y.
                if (inputParameters.length > 2) {y = Integer.parseInt(inputParameters[2]);}

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
                        System.out.println(); } 
                    
                    else {
                    	// Because if the user inputs "1" they actually want the first value which is index "0"
                        field.till(y - 1, x - 1); 
                        System.out.println("...");
                        System.out.println();
                        System.out.println("You turn was expended on your decision to till at coordinates (" + x + ", " + y + ").");
                        System.out.println(); }
                } 
                		// If the user selects h, enact the harvest action.
                else if ("h".equals(action)) {
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
                            System.out.println(); }
                        
                    }
                    
                  // If the user selects p, enact the plant action.  
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
                        
                        // If they opt to buy an apple and they can't afford one, tell them that their turn was forfeited and that they couldn't afford one.
                        if (buyOption.equals("a")) {if (startingFunds < Apples.getAppleCost()) {
                                System.out.println("You wasted your turn on going to the shops and trying to buy an apple without the funds to do so.");
                                
                              // If they DO have enough money, plant an apple and deduct the cost of an apple from their balance.  
                            } else {
                                field.plant(y - 1, x - 1, new Apples());
                                startingFunds -= Apples.getAppleCost();
                                System.out.println();
                                System.out.println();
                                System.out.println("The turn passes via the natural passage of time, due to the decision you made to try planting an apple at coordinates (" + x + ", " + y + ").");
                                System.out.println(); }
                        
                          // This just applies logic of planting an apple, but to "grain" isntead.
                        } else if (buyOption.equals("g")) {if (startingFunds < Grain.getGrainCost()) {
                                System.out.println();
                                System.out.println("You wasted your turn on going to the shops and trying to buy grain without the funds to do so.");
                                System.out.println();
                                
                            } else {
                                field.plant(y - 1, x - 1, new Grain());
                                startingFunds -= Grain.getGrainCost();
                                System.out.println();
                                System.out.println();
                                System.out.println("The turn passes via the natural passage of time, due to the decision you made to try planting some grain at coordinates (" + x + ", " + y + ").");
                                System.out.println(); }
                        
                          // If they opt to not select either apple or grain, the game sorta makes fun of them, forfeiting their turn.
                            System.out.println();
                            System.out.println("...");
                            System.out.println();
                            System.out.println("You decided to go to the shops and couldn't narrow down your choice on buying either an apple or grain.");
                            System.out.println();
                            System.out.println();
                            System.out.println("...");
                            System.out.println();
                            System.out.println("You come back to your farm, noticing that it has visibily changed.");
                            System.out.println(); }
                    }
                    
                  // If the player chooses the s option, enact the summary action.
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
                    
                    
                  // If the player chooses the w option, enact the wait action, which just lets the turn pass by
                } else if ("w".equals(action)) {
                    System.out.println();
                    System.out.println("...");
                    System.out.println();
                    System.out.println("You decided to wait and watch your farm intently.");
                    System.out.println();
                  
                  // If the user chooses the u option and they do not have an "uber tiller" active, enact the ubertill action.
                } else if ("u".equals(action) && (!uberTillerActive)) {
                    activateUberTiller();
                    
                  // If the user chooses the u option, and they have an uber tiller running, make fun of them for trying to get another one despite already having one.
                } else if ("u".equals(action) && uberTillerActive) {
                    System.out.println("You have an Uber Tiller running and lost track of time while watching it do its magic.");
                    System.out.println();
                    System.out.println();
                    
                  // If the user chooses the q option, enact the quit action, breaking out of the loop by making the "gameIsRunning" while loop condition false.
                } else if ("q".equals(action)) {
                    gameIsRunning = false;
                    System.out.println();
                    
                  // If the user tries to make any action besides the options covered in the if else statements, tell them that they tried doing stuff unrelated to the farm
                  // And forfeit their turn!
                } else {
                    System.out.println();
                    System.out.println("...");
                    System.out.println("You decided to do work unrelated to the farm. Your farm underwent changes while you were gone!");
                    System.out.println(); }

                
                // Ticks after every action..
                field.tick(); 
                
                // Increment turnCount if Uber Tiller is active
                if (uberTillerActive) {
                    field.useUberTill();
                	turnCount++;
                	startingFunds += 5;
                	System.out.println("+ + + +");
                	System.out.println();
                	System.out.println("Your clean your farm  was rewarded with nice cash bonus of $5.");
                	System.out.println();
                	
                	// Disable Uber Tiller and resets the turnCount when all of its turns are expended
                    if (turnCount >= 3) {uberTillerActive = false;
                    
                        turnCount = 0;
                        System.out.println();
                        System.out.println("But then...");
                        System.out.println("... CLANK!!");
                        System.out.println();
                        System.out.println("...");
                        System.out.println("The Uber Tiller got jammed with weeds and doesn't work anymore, so you discard it.");
                        System.out.println();
                        System.out.println();
                        System.out.println("Weed growth will resume after this turn.");
                        System.out.println();
                        
                        // Throws the Uber Tiller away after it breaks
                        hasUberTiller = false; }
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
    
    // This is a method that is used to enact the uberTill action, via a dialogue screen that prompts the user to buy one.
    public void activateUberTiller() {
    	
    	// If the player doesn't currently own an uberTiller, they are shown the purchase dialogue screen.
        if (!hasUberTiller) {
            System.out.println("!!!");
            System.out.println();
            System.out.println("Tired of weeds? Look no further than the Uber Tiller!\nAt a purchase price of $12:\nIt is said that this machine halts weed growth for 3 full turns! \nUntilled soil is automatically tilled.\nHowever, UT is a highly experimental prototype and a costly one at that, with a warranty that also expires after 3 turns.");
            System.out.println();
            System.out.println("...");
            System.out.println("Your eyes gleam at the sight of the Uber Tiller's beautiful space grey exterior.");
            System.out.println();
            System.out.println();
            System.out.println("You instinctively reach for your wallet. Will you purchase such a device and make your farm beautiful again? [y] [n]");

            Scanner scanner = new Scanner(System.in);
            String purchaseChoice = scanner.nextLine();
            
            // If the player selects yes and they have a balance equal to or greater than 12, they get an uber tiller, deducting $12 from their balance.
            if ("y".equals(purchaseChoice) && startingFunds >= 12) {
                System.out.println();
                System.out.println("!!!");
                System.out.println("YOU HAVE OBTAINED THE UBER TILLER. Use the 'u' action again to activate it!");
                System.out.println();
                startingFunds -= 12;
                hasUberTiller = true; } 
            
            // If the player selects yes and they don't have enough money to buy an uber tiller, they don't get one and the game makes fun of them.
            else if ("y".equals(purchaseChoice) && startingFunds < 12) {
                System.out.println();
                System.out.println("...");
                System.out.println("You walk home, looking at your account balance in shame as you didn't have enough money to buy the Uber Tiller.\nThe thought of getting one stays in your head.");
                System.out.println();
                System.out.println(); } 
            
            // If the player selects no, the game informs them of their choice but sorta goads them into buying one later.
            else if ("n".equals(purchaseChoice)) {
                System.out.println();
                System.out.println("...");
                System.out.println("You decide to hold on to the cash you have. You don't have the Uber Tiller, but keep the idea of buying one in your head.");
                System.out.println();
                System.out.println(); } 
            
            // If the player doesn't select yes or no, the game informs them of their choice but sorta goads them into buying one later.
            else {
                System.out.println();
                System.out.println("...");
                System.out.println("You couldn't come to a solid yes [y] or no [n] decision. Thus, you went back over to your farm empty-handed.");
                System.out.println();
                System.out.println(); }
            
          // But if the player DOES have an uber tiller (the case of if it's active or not is already covered) give the player the choice to run it.
        } else {
            System.out.println("Activate the Uber Tiller? [y] [n]");
            Scanner scanner = new Scanner(System.in);
            String activationChoice = scanner.nextLine();
            
            // Then if they choose yes to activate the uber tiller, print a funny little message and run the uber tiller.
            if ("y".equals(activationChoice)) {
                System.out.println();
                System.out.println("...");
                System.out.println("You look at your farm and decide that it's uber tilling time, then till all over the place.");
                System.out.println();
                uberTillerActive = true;
                
                // Resetting turnCount that tracks the amount of turns an uber tiller has, when an uber tiller is activated.
                turnCount = 0; 
              
              // If the player chooses not to activate the uber tiller, applaud them for having great restraint over using such an overpowered consumable.
            } else if ("n".equals(activationChoice)) {
            	System.out.println();
                System.out.println("...");
                System.out.println("You reach for your Uber Tiller but decide against using it for now.... With great power comes great responsibility.");
                System.out.println();
                System.out.println();
                
              // If the player doesn't choose yes or no to activate the uber tiller, tell them that they put it away, using their turn on waiting instead.
            } else {
            	System.out.println();
                System.out.println("...");
                System.out.println("You couldn't decide on if you did [y] or did not [n] want to use the Uber Tiller,\nYou simply packed it away, letting nature run its course.");
                System.out.println();
                System.out.println(); }
        }
    }
}
