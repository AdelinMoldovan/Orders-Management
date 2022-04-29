package start;

import java.awt.*;
import presentation.ViewAndController;
import javax.swing.*;

/**
 * The type start.
 */
public class Start {
    /**
     * public static void main() method.
     *
     */
    public static void main(String[] args) {
        JFrame frame = new ViewAndController("Orders Management");
        frame.setMinimumSize(new Dimension(500, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}