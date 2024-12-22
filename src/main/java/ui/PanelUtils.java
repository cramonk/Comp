package ui;

import javax.swing.*;

public class PanelUtils {
    public PanelUtils() {
    }
    public static void addAction(JComponent component, String name, KeyStroke keyStroke, Action action) {
        component.getInputMap().put(keyStroke, name);
        component.getActionMap().put(name, action);
    }
}
