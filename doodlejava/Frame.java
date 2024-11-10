package doodlejava;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import util.Resource;

public class Frame extends JFrame {

    private static final Dimension SIZE;

    static {
        int screenHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()) - 100;
        if (screenHeight > 800) {
            screenHeight = 800;
        }
        System.out.println(screenHeight);
        SIZE = new Dimension(540, 970);
    }
    
    private Menu menu;

    public Frame() {
        super();
        this.setIconImage(Resource.getImage("doodle.png"));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setSizeWithoutInsets(SIZE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.err.println("Error " + ex);
        }

        this.setTitle(0);
        this.menu = new Menu(SIZE);
  
        this.add(this.menu);
        this.menu.requestFocus();
    }

    public void start(Dimension size) {
        menu.start(SIZE);
    }

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setVisible(true);
        System.out.println("yes");
        f.start(SIZE);
        System.out.println("yes");
    }

    private void setTitle(int points) {
        this.setTitle("Doodle Jump - " + points + " points");
    }

    private void setSizeWithoutInsets(Dimension d) {
        Insets i = this.getInsets();
        this.setSize(d.width + i.left + i.right, d.height + i.top + i.bottom);
    }
}

class SwapPanelListener implements ActionListener {

    private JPanel pFrom;
    private JPanel pTo;

    public SwapPanelListener(JPanel from, JPanel to) {
        this.pFrom = from;
        this.pTo = to;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.pTo.setVisible(true);
        this.pFrom.setVisible(false);
    }
}
