package cs3500.music.viewmine;

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
   * Sets {@code beat} to the given integer {@code beat}
   *
   * @param beat the beat to set this.beat to
   */
  public void setBeat(int beat) {
    this.beat = beat;
  }

  @Override
  public void paint(Graphics g) {
    this.getComponent(0).paint(g);
    g.setColor(Color.RED);
    int x = 50 + this.beat*30;
    int y = 50;
    Dimension pref = this.getComponent(0).getPreferredSize();
    g.fillRect(x, y, 3, pref.height - 100);
  }

}
