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
	public void setAge(int age) {
		this.age = age;
		
	}
	
	public int getAge() {
		return age;
	}
	
	public void setMaturationAge(int maturationAge) {
		this.maturationAge = maturationAge;
		
	}
	
	public int getMaturationAge() {
		return maturationAge;
	}
	
	public void setDeathAge(int deathAge) {
		this.deathAge = deathAge;
		
	}
	
	public int getDeathAge() {
		return deathAge;
	}
	
	public void setMonetaryValue(double monetaryValue) {
		this.monetaryValue = monetaryValue;
		
	}
	
	public double getMonetaryValue() {
		return monetaryValue;
	}
	
	public void tick(int age) {
		age ++;
	}
	
	public boolean died() {
		return age > deathAge;
	}
}
	
