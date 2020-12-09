/**
 * A text label which displays text and a changing counter.
 */
package GameOfLife.Display;

import javax.swing.*;
import java.awt.*;

class Label extends JLabel {
    String constantText;

    /**
     * Constructs a Label.
     * @param constantText  The part of the Label that stays the same during runtime.
     * @param color         The text's color
     */
    public Label(String constantText, Color color) {
        super(constantText);
        this.constantText = constantText;
        setForeground(color);
    }

    /**
     * Updates the Label's visible text.
     * @param counter   The counter to display.
     */
    public void update(int counter) {
        setText(this.constantText + counter);
    }
}
