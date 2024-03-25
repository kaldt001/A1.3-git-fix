package students;

import students.items.*;

public class Field {
    private Item[][] field;

    public Field(int height, int width) {
        field = new Item[height][width];
        initializeField();
    }

    private void initializeField() {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[0].length; col++) {
                field[row][col] = new Soil();
            }
        }
    }
}
