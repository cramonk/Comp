package ui;

import files.XmlReader;
import org.springframework.stereotype.Component;

import javax.swing.*;

public class Menu extends JMenuBar {

    public Menu(XmlReader reader) {
        JMenuItem fileItem = new JMenuItem("File");
//        fileItem.addActionListener();
        JMenu menu = new JMenu("File");
        menu.add(fileItem);
        this.add(menu);
    }
}
