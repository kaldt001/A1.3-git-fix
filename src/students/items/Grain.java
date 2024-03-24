package students.items;
public class Grain extends Food {
    private static int generationCount = 0; // This is just a variable the total number of grain objects that have been created
    private static final double COST_OF_GRAIN = 1.0; 

    
    public Grain(int age, int maturationAge, int deathAge, double monetaryValue) {
        super(age, maturationAge, deathAge, monetaryValue);
        incrementNumOfGrains(); // This increments the "numOfGrains" variable every time the constructor is used (at every instantiation).
    }

    // This method adds 1 to the numOfGrains object, used for increasing the count on the number of grains as seen above.
    private static void incrementNumOfGrains() {
        generationCount++;
    }


    public static int getGenerationCount() {
        return generationCount;
    }
    // Override the toString() method inherited from "Item" class, purposed for representing a given Grain object as 'g' or 'G'
    @Override
    public String toString() {
        if (getAge() < getMaturationAge()) {
            return "g";
        } else {
            return "G";
        }
    }

 
    public static double getGrainCost() {
        return COST_OF_GRAIN;
    }



}
