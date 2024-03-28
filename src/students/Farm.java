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
	        }
	    }
	
}
