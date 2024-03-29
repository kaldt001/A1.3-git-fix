package students.items;

public class Grain extends Food {
    private static int generationCount = 0; // This is just a variable the total number of grain objects that have been created
    private static final double COST_OF_GRAIN = 1.0; // Cost of purchasing grain

    // Constructor for Grain class
    public Grain(int age, double monetaryValue) {
        super(age, 2, 4, monetaryValue); // Calls the superclass constructor with specified parameters for maturation and death age
        incrementNumOfGrains(); // This increments the "numOfGrains" variable every time the constructor is used (at every instantiation).
    }

    // Increments the count of grain objects
    private static void incrementNumOfGrains() {
        generationCount++; // This method adds 1 to the numOfGrains object, used for increasing the count on the number of grains as seen above.
    }

    // Returns the total count of grain objects instantiated
    public static int getGenerationCount() {
        return generationCount;
    }

    // Overrides the inherited toString() to represent a Grain object as 'g' or 'G' based on its age
    @Override
    public String toString() {
        if (getAge() < getMaturationAge()) {
            return "g"; // For when the grain is immature
        } else {
            return "G"; // For when the grain is mature
        }
    }

    // Returns the cost of purchasing grain
    public static double getGrainCost() {
        return COST_OF_GRAIN;
    }
}
