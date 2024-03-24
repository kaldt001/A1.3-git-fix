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
		this.age ++;
	}
	
	public boolean died() {
		return age > deathAge;
	}
	
	public double getValue() {
	    if (this.age > this.maturationAge) {
	        return this.monetaryValue;
	    } else {
	        return 0.0; 
	    }

	}
	
	@Override
	public boolean equals(Object obj) {
	    return this.age == ((Item) obj).getAge() &&
	           this.deathAge == ((Item) obj).getDeathAge() &&
	           this.maturationAge == ((Item) obj).getMaturationAge() &&
	           Double.compare(this.monetaryValue, ((Item) obj).getMonetaryValue()) == 0;
	}
	
	public abstract String toString();

	
}
	
