package students.items;

public class Apples extends Food {
    private static int generationCount = 0;
    private static final double APPLE_COST = 2.0;
    private static final double MONETARY_VALUE = 3.0;
    
    // Default Apples constructor with no required arguments
    public Apples() {
        super(0, 3, 5, MONETARY_VALUE);
        incrementGenerationCount();
    }
    
    // Apples constructor with an age parameter. Whenever an apple for some reason, needs a pre-defined age.
    public Apples(int age) {
        super(age, 3, 5, MONETARY_VALUE);
        incrementGenerationCount();
    }

    private static void incrementGenerationCount() {
        generationCount++;
    }

    public static int getGenerationCount() {
        return generationCount;
    }
    
 // The Apples (not the company!) class' version of the toString method 
    public String toString() {
        if (getAge() < getMaturationAge()) {
            return "a";
        } else {
            return "A";
        }
    }

    // Gets the cost of an Apple.
    public static double getAppleCost() {
        return APPLE_COST;
    }
    
    

    
}

