package students;

import students.items.*;

import java.util.Random;

public class Field {
    private Item[][] field;
    private Random random;

    public Field(int height, int width) {
        field = new Item[height][width];
        random = new Random();
        initializeField();
    }

    private void initializeField() {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[0].length; col++) {
                field[row][col] = new Soil();
            }
        }
    }

    public void tick() {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[0].length; col++) {
                Item currentItem = field[row][col];
                int currentAge = currentItem.getAge(); // Getting the storing current age value in an int variable because the following tick() method needs an integer as an argument
                currentItem.tick(currentAge); // Uses the tick method on the current item, based on its current age value.
            }
        }
    }
    
    @Override
    public String toString() {
        String result = "  ";
        for (int col = 1; col <= width; col++) {
            result += col + " ";
        }
        result += "\n";
        for (int row = 0; row < height; row++) {
            result += (row + 1) + " ";
            for (int col = 0; col < width; col++) {
                result += field[row][col] + " ";
            }
            result += "\n";
        }
        return result;
    }

}
