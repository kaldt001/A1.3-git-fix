package students.items;

public abstract class Item {
	private int age;
	private int maturationAge;
	private int deathAge;
	private double monetaryValue;
	
	// This is the item's constructor, it is responsible for intializing any item  object with age, maturationAge, deathAge and monetaryValue.
	public Item(int age, int maturationAge, int deathAge, double monetaryValue) {
		this.age = age;
		this.maturationAge = maturationAge;
		this.deathAge = deathAge;
		this.monetaryValue = monetaryValue; }
	
	// This is a simple set method, used to set an item object's age, given an integer age variable value, whenever called.
	public void setAge(int age) {this.age = age;}
	
	// This is a simple getter method, used to get an item object's age, whenever called.
	public int getAge() {return age;}
	
	// This is a simple getter method, used to get an item object's maturationAge, whenever called.
	public int getMaturationAge() {return maturationAge;}
	
	// This is a simple getter method, used to get an item object's deathAge, whenever called.
	public int getDeathAge() {return deathAge;}
	
	// This is a simple getter method, used to get an item object's monetaryValue, whenever called.
	public double getMonetaryValue() {return monetaryValue;}
	
	// This method increments the age variable of an item object by 1 whenever called, whenever called.
	public void tick() {age++;}
	
	// This method, when called, flags an item object as "died" if their age is greater than their deathAge value.
	public boolean died() {return age > deathAge;}
	
	// This method gets the monetary variable of an item object when it is past or equal to its maturation age. 
	public double getValue() {
	    if (this.age >= this.maturationAge) {
	        return this.monetaryValue;} 
	    else {
	        return 0.0; }}
	
	@Override 
	
	// Overriding the default java "equals()" method that all "Objects" inherit. 
	public boolean equals(Object obj) {
	    return this.age == ((Item) obj).getAge() &&
	           this.deathAge == ((Item) obj).getDeathAge() &&
	           this.maturationAge == ((Item) obj).getMaturationAge() &&
	           Double.compare(this.monetaryValue, ((Item) obj).getMonetaryValue()) == 0;}
	
    // This is a simple abstract method that represents item objects as a string. 
	public abstract String toString();
	
	}
	
