package students;

import students.items.*;

import java.util.Random;

public class Field {
    private Item[][] field;
    private int height;
    private int width;
    private Random random;

    // This is a constructor for the field class
    public Field(int width, int height) {
        this.height = height;
        this.width = width;
        field = new Item[height][width];
        random = new Random();
        initializeField(); }

    // As the method's name suggests, I'm initializing the field here. (Via iterating row by row/column by column)
    private void initializeField() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                field[row][col] = new Soil(); } } 
        }

    // Updates the age for every item on field
    public void tick() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Item currentItem = field[row][col];

                // Increment the age of the current item
                currentItem.tick();

                // Randomly transform soil into weed with a 20% chance
                if (currentItem instanceof Soil && random.nextDouble() < 0.2) {
                    field[row][col] = new Weed(); }

                // Replace items that have died with untilled soil
                if (currentItem.died() && currentItem instanceof Item && !(currentItem instanceof Weed)) {
                    field[row][col] = new UntilledSoil(); } } }
        }

    // Represent the field as a string
    @Override
    public String toString() {
        String result = "  ";
        for (int col = 1; col <= width; col++) {
            result += col + " "; }
        result += "\n";
        for (int row = 0; row < height; row++) {
            result += (row + 1) + " ";
            for (int col = 0; col < width; col++) {
                Item currentItem = field[row][col];
                if (currentItem instanceof Apples && currentItem.getAge() >= currentItem.getMaturationAge()) {
                    result += "A "; } 
                else if (currentItem instanceof Grain && currentItem.getAge() >= currentItem.getMaturationAge()) {
                    result += "G "; } 
                else {
                    result += currentItem + " "; } }
            result += "\n"; }
        return result;
    }

    // Till the soil at the specified location
    public void till(int row, int col) {
        if (row >= 0 && row < height && col >= 0 && col < width) {
        	// Replacing whatever that location is with some soil.
            field[row][col] = new Soil(); } 
        else {
        	System.out.println();
            System.out.println("Those coordinates aren't associated to the farm. Trespassing isn't very wise, you might get in a heap of trouble with law enforcement!");
            System.out.println(); }
    }

    // Get the item at the specified location
    public Item get(int row, int col) {
        if (row >= 0 && row < height && col >= 0 && col < width) {
        	// Return the item at the specified, valid location
            return field[row][col]; } 
        else {
        	// Return nothing if its not in bounds
        	return null; }
     }

    // Calculate the total value of all items in the field
    public double getValue() {
        double totalValue = 0.0;
        
        // Check every single crevice of the field

        for (int row = 0; row < height; row++) 
        {
            for (int col = 0; col < width; col++) {
            	 // This every point on the field, add each monetary value one by one.
                totalValue += field[row][col].getValue(); } }
        return totalValue;
     }

    // Print a summary of the field including counts and total value
    public void getSummary() {
        int applesCount = 0;
        int grainCount = 0;
        int soilCount = 0;
        int untilledCount = 0;
        int weedCount = 0;

        // This calculates all the count-based values in the summary code following this block of code.
        for (int row = 0; row < height; row++) 
        {for (int col = 0; col < width; col++) {Item currentItem = field[row][col];
        
                if (currentItem instanceof Apples) {applesCount++;} 
                
                else if (currentItem instanceof Grain) {grainCount++; } 
                
                else if (currentItem instanceof Soil) {soilCount++; } 
                
                else if (currentItem instanceof UntilledSoil) {untilledCount++; } 
                
                else if (currentItem instanceof Weed) {weedCount++; } } }

        // This calculates the totalValue variable via the getValue method
        double totalValue = getValue();

        // This creates a viewable summary of the state of the game's various attributes
        System.out.println("Apples:        " + applesCount);
        System.out.println("Grain:         " + grainCount);
        System.out.println("Soil:          " + soilCount);
        System.out.println("Untilled soil: " + untilledCount);
        System.out.println("Weed:          " + weedCount);
        System.out.println("For a total farm value of: ($)" + totalValue);
        System.out.println("Total apples created: " + Apples.getGenerationCount());
        System.out.println("Total grain created:  " + Grain.getGenerationCount());
    }
    
    

    // Plant an item at a specified location, if and only if its on a soil tile and within the field's height/width parameters.
    public void plant(int row, int col, Item item) {
        if (row >= 0 && row < height && col >= 0 && col < width) {
        	
            // The code below checks if the cell being planted on is soil.
            if (field[row][col] instanceof Soil) {field[row][col] = item;}
            
            // The Code below prints an error message whenever a player tries to plant on anything within the field besides soil
            else {
                System.out.println();
                System.out.println("You sat there and contemplated on your failed attempt at planting stuff on a spot that isn't tilled soil.");
                System.out.println();
                System.out.println("Hint: Try tilling it first next time!");
                System.out.println();
                System.out.println("Meanwhile... "); } } 
        else 
        {
        	System.out.println();
        	System.out.println("...");
        	System.out.println();
        	System.out.println("And just like that, your recently purchased item was stolen by a pack of super intelligent kangaroos! Always plant within your premises."); }
    }
    
    // This method when called, removes all weed and untilled soil items on the field.
    public void useUberTill() {
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    if (field[row][col] instanceof Weed || field[row][col] instanceof UntilledSoil)  {field[row][col] = new Soil();} } }
            
    }

}
    
    
   

