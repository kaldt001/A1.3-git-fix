package students;

import java.util.Scanner;

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
	            String action = inputParameters[0];
	            int x;
	            int y;
	            
	            
	            if (inputParameters.length > 1) {
	                x = Integer.parseInt(inputParameters[1]); //checking for coordinate x via index "1" because index "0" is the command itself like "p".
	            }
	            if (inputParameters.length > 2) {
	                y = Integer.parseInt(inputParameters[2]); // Since coordinate x is at 1, index y is at 2 
	            }
	        }
	        
	        
	        
	    }
	
}
