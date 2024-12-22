package configuration;

import listeners.MouseListener;
import listeners.SearchAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ui.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static ui.PanelUtils.addAction;

@Configuration
@ComponentScan(basePackages = {"ui", "files", "model"})
public class SpringConfiguration {

    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


    @Bean
    public JPanel mainPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BorderLayout());
        panel.setSize(screenSize);
        panel.add(listPanel(), BorderLayout.WEST);
        panel.add(componentPanel(), BorderLayout.EAST);

        addAction(panel, "search",
                KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK, true),
                new SearchAction());

        return panel;
    }



    @Bean
    public JPanel componentPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setMinimumSize(new Dimension(200, 200));
        panel.setPreferredSize(new Dimension(screenSize.width - 250, screenSize.height));
        panel.setMaximumSize(new Dimension(screenSize.width , screenSize.height));
        panel.add(searchPanel(), BorderLayout.NORTH);

        panel.setName("component panel");
        panel.addMouseListener(new MouseListener());



        return panel;
    }

    @Bean
    public JPanel listPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        panel.setMinimumSize(new Dimension(250, 200));
        panel.setPreferredSize(new Dimension(250, screenSize.height));
        panel.setName("list panel");
        panel.addMouseListener(new MouseListener());
        return panel;
    }

    @Bean
    public JPanel searchPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setPreferredSize(new Dimension(200, 30));
        panel.setName("search panel");
        panel.setVisible(false);


        return panel;
    }


}
