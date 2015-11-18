package cs3500.music.view;

import java.awt.*;

import javax.swing.*;

/**
 * Displays the red bar representing the point we're at in the song.
 */
public class GuiBeatPanel extends JPanel {
  /**
   * The beat the song is at.
   */
  int beat;

  /**
   * Constructs a new GuiBeatPanel at beat 0.
   */
  public GuiBeatPanel() {
    super();
    this.beat = 0;
    this.setOpaque(false);
  }

  /**
   * Sets beat to the given number.
   */
  public void setBeat(int beat) {
    this.beat = beat;
  }

  @Override
  public void paint(Graphics g) {
    this.getComponent(0).paint(g);
    this.setOpaque(false);
    g.setColor(Color.RED);
    int x = 50 + this.beat*30;
    int y = 50;
    Dimension pref = this.getComponent(0).getPreferredSize();
    g.fillRect(x, y, 2, pref.height - 100);
  }

}
