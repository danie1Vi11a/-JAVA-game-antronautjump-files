package doodlejava;

import java.awt.Dimension;
import oneiros.games.OSprite;
import oneiros.sound.SoundManager;
import util.Resource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Menu extends OSprite {

    static {
        SoundManager.add("jump", Resource.getSoundFile("jump.wav"));
        SoundManager.add("fall", Resource.getSoundFile("pada.wav"));
    }

    private GamePanel gamePanel;

    public Menu(Dimension size) {
        super(Resource.getImage("menuScreen.png"));
        this.setSize(size);

        menuStart(size);
    }

    public void menuStart(Dimension size) {
        start(size);
    }

    public void start(Dimension size) {
        this.gamePanel = new GamePanel(size);

        setTitle(Integer.toString(0));
        this.gamePanel = new GamePanel(size);
        this.gamePanel.setNewGameListener(new NewGameListener() {

            @Override
            public void updateScore(int score) {
                setTitle(Integer.toString(score));
            }

            @Override
            public void gameOver() {
                setTitle(Integer.toString(0));
            }
        });
        this.add(this.gamePanel);
        this.gamePanel.requestFocus();
        this.gamePanel.start();
    }

    private void setTitle(String points) {
        // setTitle("Doodle Jump - " + points + " points");
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