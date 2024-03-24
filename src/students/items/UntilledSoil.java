package students.items;

public class UntilledSoil extends Item {

    public UntilledSoil() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE, -1, -1.0);
    }

    @Override
    public boolean died() {
        return false;
        // Because untilled soil can also never die.
    }

    @Override
    public String toString() {
        return "/";
    }
}
