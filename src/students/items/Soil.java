package students.items;

public class Soil extends Item {

    public Soil() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0.0);
    }

    @Override
    public boolean died() {
        return false;
     // Because like weed and untilled soil, soil can't die.
    }

    @Override
    public String toString() {
        return ".";
    }
}
