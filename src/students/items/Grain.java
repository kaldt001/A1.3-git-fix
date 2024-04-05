package students.items;

public class Grain extends Food {
    private static int generationCount = 0; // This is just a variable the total number of grain objects that have been created
    private static final double COST_OF_GRAIN = 1.0; // Cost of purchasing grain
    private static final double MONETARY_VALUE = 2.0;

    // This is the defualt constructor for Grain class
    public Grain() {
    	
    	// Calls the superclass constructor with specified parameters for maturation and death age
        super(0, 2, 6, MONETARY_VALUE); 
        
        // This increments the "numOfGrains" variable every time the constructor is used (at every instantiation).
        incrementGenerationCount(); }
    
    // This is the Grain class' constructor that takes age as a parameter, for if such a thing is required.
    public Grain(int age) {super(age, 2, 6, MONETARY_VALUE);
        
        // Everytime a grain object is created, its GenerationCount increments by 1 to keep track of that new instance.
        incrementGenerationCount();	}

    // This method increments the generationCount variable by 1, used for increasing the count on the number of grains as seen above.
    private static void incrementGenerationCount() {generationCount++; }

    // Returns the total count of grain objects instantiated
    public static int getGenerationCount() {return generationCount; }

    // Overrides the inherited toString() to represent a Grain object as 'g' or 'G' based on its age
    @Override
    public String toString() {
    	
    	// For when the grain is immature
        if (getAge() < getMaturationAge()) {return "g"; } 
        
        // For when the grain is mature
        else {return "G"; }
        }

    // Returns the cost of purchasing grain
    public static double getGrainCost() {return COST_OF_GRAIN; }
 }
