package students.items;

public class Weed extends Item {
    public Weed() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1); 
    }

    @Override
    public String toString() {
        return "#";
    }
    
    @Override
    public boolean died() {
        return false;
        
        //Because weeds can't die.
    }

}
