package listeners;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MouseListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        Component component = e.getComponent();
        String name = component.getName();
        Random random = new Random();
        switch (name) {
            case "list panel" -> component.setBackground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            case "component panel" -> {

            }
        }
    }
}
