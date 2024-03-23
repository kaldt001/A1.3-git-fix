package students.items;

public abstract class Item {
	private int age;
	private int maturationAge;
	private int deathAge;
	private double monetaryValue;
	
	public Item(int age, int maturationAge, int deathAge, double monetaryValue) {
		this.age = age;
		this.maturationAge = maturationAge;
		this.deathAge = deathAge;
		this.monetaryValue = monetaryValue;
		
	}
	
}
	
