package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SearchAction extends AbstractAction {



    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField textField = new JTextField(10);
        JPanel mainPanel = (JPanel) e.getSource();
        JPanel componentPanel = (JPanel) mainPanel.getComponent(1);
        JPanel searchPanel = (JPanel) componentPanel.getComponents()[0];
        searchPanel.setVisible(true);
        searchPanel.add(textField);

        String text = textField.getText();

        mainPanel.getParent().repaint();
        textField.requestFocus();
    }
}
