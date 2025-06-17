import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Flow;

public class EzCaesar {

    public static void main(String[] args) {

        JFrame window = initWindow();

    }

    private static JFrame initWindow() {

        // Initial window creation and information set up
        JFrame window = new JFrame("EZ Caesar");
        window.setPreferredSize(new Dimension(800, 600));

        // Add contents to window
        window.getContentPane().add(initContents());

        // Displaying the window
        window.pack();
        window.setVisible(true);

        return window;

    }

    private static Container initContents() {

        // Create the base frame that holds all window elements
        JPanel contentsContainer = new JPanel(new BorderLayout());

        // Application layout boxes
        JPanel inputOutputArea = new JPanel();
        inputOutputArea.setLayout(new BoxLayout(inputOutputArea, BoxLayout.PAGE_AXIS));
        JPanel inputLine = new JPanel();
        inputLine.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Create input area
        JLabel inputLabel = new JLabel("Input: ");
        JTextField inputField = new JTextField();
        inputField.setColumns(40);

        JLabel offsetSpinnerLabel = new JLabel("Offset: ");
        JSpinner offsetSpinner = new JSpinner();
        JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) offsetSpinner.getEditor();
        spinnerEditor.getTextField().setColumns(4);

        // Create output area
        JTextArea outputField = new JTextArea();
        outputField.setEditable(false);
        outputField.setColumns(40);

        // Input field gets converted while typing
        inputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                offsetContents(inputField.getText(), outputField, (Integer)offsetSpinner.getValue());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                offsetContents(inputField.getText(), outputField, (Integer)offsetSpinner.getValue());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                offsetContents(inputField.getText(), outputField, (Integer)offsetSpinner.getValue());
            }
        });
        inputField.addActionListener(e -> {
            offsetContents(inputField.getText(), outputField, (Integer)offsetSpinner.getValue());
        });

        offsetSpinner.addChangeListener(e -> {
            offsetContents(inputField.getText(), outputField, (Integer)offsetSpinner.getValue());
        });

        // Organize application components
        inputLine.add(inputLabel);
        inputLine.add(inputField);
        inputLine.add(offsetSpinnerLabel);
        inputLine.add(offsetSpinner);

        inputOutputArea.add(inputLine);
        inputOutputArea.add(outputField);

        contentsContainer.add(inputOutputArea, BorderLayout.CENTER);

        return contentsContainer;
    }

    static void offsetContents(String inputString, JTextArea outputArea, int offset) {
        String output = Cipher.shiftString(inputString, offset, Cipher.aToz);
        outputArea.setText(output);
    }

}
