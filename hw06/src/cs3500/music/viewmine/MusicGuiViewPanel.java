package cs3500.music.viewmine;

import java.awt.*;
import java.util.List;
import java.util.*;

import javax.swing.*;

import cs3500.music.model.Tone;

/**
 * Implementation of a visual representation (view) of a MusicRepresentation
 */

public class MusicGuiViewPanel extends JPanel {

  /**
   * The music piece represented in this panel.
   */
  private SafeMusicRepresentation music;

  /**
   * Create a view Panel.
   */
  MusicGuiViewPanel() {
    this.music = new SafeMusicRepresentationDecorator();
  }


  @Override
  public void paint(Graphics g) {
    int x = 50;
    int y = 50;
    List<Tone> tones = music.displayNotes();
    int highestVal = music.highest().getValue();
    Tone tone = music.lowest();
    int lowestVal = tone.getValue();
    int height = (highestVal - lowestVal + 1) * 30;
    for (int i = 0; i < music.getLength(); i = i + 1) {
      Collection<Tone> c = music.getNotesAtBeat(i);
      for (Tone t : c) {
        y = (highestVal- t.getValue())*30 + 50;
        g.setColor(new Color(118, 184, 118));
        g.fillRect(x, y, t.getDuration()*30, 30);
        g.setColor(new Color(0, 120, 20));
        g.fillRect(x, y, 10, 30);
      }
      x = x + 30;
    }
    x = 50;
    y = 50;
    int beat = 0;
    g.setColor(Color.BLACK);
    while (x <= music.getLength()*30){
      g.fillRect(x, y, 2, height);
      g.drawString("" + beat, x - 2, 40);
      beat = beat + 4;
      x = x + 120;
    }
    g.fillRect(x, y, 2, height + 2);
    g.drawString("" + beat, x - 2, 40);
    x = 50;
    g.fillRect(x, y, music.getLength()*30, 2);
    y = y + 30;
    for (int i = tones.size() - 1; i >= 0 ; i = i - 1) {
      g.fillRect(x, y, music.getLength()*30, 2);
      g.drawString(tones.get(i).toString(), 20, y - 10);
      y = y + 30;
    }
  }

  /**
   * Change what music representation is being drawn to m
   * @param m music representation
   */
  public boolean changeMusic(SafeMusicRepresentation m) {
    if (this.music.equals(m)) {
      return false;
    }
    this.music = m;
    return true;
  }

  @Override
  public Dimension getPreferredSize() {
    int x = 100 + music.getLength()*30;
    int y = 100 + music.displayNotes().size()*30;
    return new Dimension(x, y);
  }
}
