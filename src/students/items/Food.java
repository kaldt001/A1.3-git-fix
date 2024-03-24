package students.items;

public abstract class Food extends Item{
	
	public Food(int age, int maturationAge, int deathAge, double monetaryValue) {
        super(age, maturationAge, deathAge, monetaryValue);
    }
	
	@Override
	public String toString() {
        // Implement the string representation for Food
        return "Food: \n age= " + getAge() + ", maturationAge= " + getMaturationAge() + ", deathAge= " + getDeathAge() + ", monetaryValue= " + getMonetaryValue();
    }
	


}
