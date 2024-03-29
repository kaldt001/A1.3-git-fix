package students;

import students.items.*;

import java.util.Random;

public class Field {
    private Item[][] field;
    private int height;
    private int width;
    private Random random;

    public Field(int height, int width) {
        this.height = height;
        this.width = width;
        field = new Item[height][width];
        random = new Random();
        initializeField();
    }

    private void initializeField() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                field[row][col] = new Soil();
            }
        }
    }

    public void tick() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Item currentItem = field[row][col];
                
                // Uses the tick method on the current item, based on its current age value.
                int currentAge = currentItem.getAge(); // Getting the storing current age value in an int variable because the following tick() method needs an integer as an argument
                currentItem.tick(currentAge);
                
                // The code below makes it so there is a 20% chance (represented by 0.2) to transform an instance of Soil into Weed
                if (currentItem instanceof Soil && random.nextDouble() < 0.2) {
                    field[row][col] = new Weed();
                }
                
                // This makes it so that if an item dies, it's replaced with UntilledSoil
                if (currentItem.died()) {
                    field[row][col] = new UntilledSoil();
                }
            }
        }
    }

    @Override
    public String toString() {
        String result = "  ";
        for (int col = 1; col <= width; col++) {
            result += col + " ";
        }
        result += "\n";
        for (int row = 0; row < height; row++) {
            result += (row + 1) + " ";
            for (int col = 0; col < width; col++) {
                result += field[row][col] + " ";
            }
            result += "\n";
        }
        return result;
    }
    
    public void till(int row, int col) {
        if (row >= 0 && row < height && col >= 0 && col < width) // Checking for location, if in the field
        	{
            field[row][col] = new Soil(); // Replacing whatever that location is with some soil.
        }
    }
    
    public Item get(int row, int col) {
        if (row >= 0 && row < height && col >= 0 && col < width) {
            
            return field[row][col]; // Return the item at the specified, valid location
        }
       
        else {
        	
        return null; // Return nothing if its not in bounds
        
        }
    
    }
    
    public double getValue() {
        double totalValue = 0.0;
        
        for (int row = 0; row < height; row++) // Check every single crevice of the field
        {
            for (int col = 0; col < width; col++) {
                 
                totalValue += field[row][col].getValue(); // This every point on the field, add each monetary value one by one.
            }
        }
        return totalValue;
    }
    
    public void getSummary() {
        int applesCount = 0;
        int grainCount = 0;
        int soilCount = 0;
        int untilledCount = 0;
        int weedCount = 0;

        // Calculate the counts of each item type
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Item currentItem = field[row][col];
                if (currentItem instanceof Apples) {
                    applesCount++;
                } else if (currentItem instanceof Grain) {
                    grainCount++;
                } else if (currentItem instanceof Soil) {
                    soilCount++;
                } else if (currentItem instanceof UntilledSoil) {
                    untilledCount++;
                } else if (currentItem instanceof Weed) {
                    weedCount++;
                }
            }
        }

        // Calculate the total value
        double totalValue = getValue();

        // Print the summary
        System.out.println("Apples:        " + applesCount);
        System.out.println("Grain:         " + grainCount);
        System.out.println("Soil:          " + soilCount);
        System.out.println("Untilled:      " + untilledCount);
        System.out.println("Weed:          " + weedCount);
        System.out.println("For a total of $" + totalValue);
        System.out.println("Total apples created: " + Apples.getGenerationCount());
        System.out.println("Total grain created: " + Grain.getGenerationCount());
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }


}
