import javax.swing.*;
import java.awt.*;

public class EzCaesar {

    public static void main(String[] args) {

        JFrame window = initWindow();

    }

    private static JFrame initWindow() {

        // Initial window creation and information set up
        JFrame window = new JFrame("EZ Caesar");
        window.setPreferredSize(new Dimension(800, 600));

        // Displaying the window
        window.pack();
        window.setVisible(true);

        return window;

    }

}
