package ui;

import files.XmlReader;
import model.Board;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

@Component
public class MainFrame extends JFrame implements ActionListener {

    private final XmlReader reader;
    public MainFrame(@Qualifier("mainPanel") JPanel mainPanel, XmlReader reader) throws HeadlessException {
        this.reader = reader;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JMenuBar menuBar = new JMenuBar();
        JMenuItem fileItem = new JMenuItem("File");
        fileItem.addActionListener(this);
        JMenu menu = new JMenu("File");
        menu.add(fileItem);
        menuBar.add(menu);

        this.setSize(screenSize);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);




        this.setJMenuBar(menuBar);
        this.setResizable(true);
        this.getContentPane().add(mainPanel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("File")) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                Board board = reader.getBoard(Path.of(fileChooser.getSelectedFile().getAbsolutePath()));
                System.out.println(board);
            }
        }
    }
}
