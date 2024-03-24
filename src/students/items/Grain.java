package students.items;
public class Grain extends Food {
    private static int numOfGrains = 0; // This is just a variable the total number of grain objects that have been created
    private static final double COST_OF_GRAIN = 1.0; 

    
    public Grain(int age, int maturationAge, int deathAge, double monetaryValue) {
        super(age, maturationAge, deathAge, monetaryValue);
        incrementNumOfGrains(); // This increments the "numOfGrains" variable every time the constructor is used (at every instantiation).
    }

    // This method adds 1 to the numOfGrains object, used for increasing the count on the number of grains as seen above.
    private static void incrementNumOfGrains() {
        numOfGrains++;
    }


    public static int getNumOfGrains() {
        return numOfGrains;
    }



}
