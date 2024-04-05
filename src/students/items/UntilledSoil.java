package students.items;

public class UntilledSoil extends Item {

    public UntilledSoil() {super(Integer.MAX_VALUE, Integer.MAX_VALUE, -1, -1.0); }

    @Override
    
    // Because untilled soil can't die, this condition always ensures their "died()" boolean is always false.
    public boolean died() {return false; }

    @Override
    
    // This is the untilled soil implementation of the toString method, which specifically represents untilled soil objects as a  "/" symbol.
    public String toString() {return "/"; }
    
}
