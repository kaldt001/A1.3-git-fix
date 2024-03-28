package students.items;

public class Apples extends Food {
    private static int generationCount = 0;
    private static final double APPLE_COST = 2.0;

    public Apples(int age, double monetaryValue) {
        super(age, 3, 5, monetaryValue);
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

    // Gets the monetary value of an Apple.
    public static double getAppleCost() {
        return APPLE_COST;
    }

    
}

