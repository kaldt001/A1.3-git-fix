package students.items;

public class Weed extends Item {
    public Weed() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1); }

    @Override
    
    // This is the weed implementation of the toString method, which specifically represents weed objects as a  "#" symbol.
    public String toString() {return "#"; }
    
    @Override
    
    // Because weeds can't die, this condition always ensures their "died()" boolean is always false.
    public boolean died() {return false; }
}
