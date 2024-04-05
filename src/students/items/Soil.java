package students.items;

public class Soil extends Item {

    public Soil() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0.0); }

    @Override
    
    // Because soil can't die, this condition always ensures their "died()" boolean is always false.
    public boolean died() {return false; }

    @Override
    
    // This is the soil implementation of the toString method, which specifically represents soil objects as a  "." symbol.
    public String toString() {return "."; }

}

