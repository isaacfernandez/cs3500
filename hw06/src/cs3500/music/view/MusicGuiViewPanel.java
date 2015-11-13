package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.*;

import javax.swing.*;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.model.Note;
import cs3500.music.model.Score;
import cs3500.music.model.Tone;


public class MusicGuiViewPanel extends JPanel {

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
    int height = (highestVal - lowestVal + 2) * 30;
    for (int i = 0; i < music.getLength(); i = i + 1) {
      Collection<Tone> c = music.getNotesAtBeat(i);
      for (Tone t : c) {
        y = (highestVal- t.getValue())*30 + 50;
        g.setColor(Color.CYAN);
        g.fillRect(x, y, t.getDuration()*30, 30);
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 10, 30);
      }
      x = x + 30;
    }
    x = 50;
    y = 50;
    int beat = 0;
    g.setColor(Color.BLACK);
    for (int i = 0; i <= tones.size(); i = i + 1) {
      g.fillRect(x, y, 2, height);
      g.drawString("" + beat, x - 2, 40);
      beat = beat + 4;
      x = x + 120;
    }
    x = 50;
    g.fillRect(x, y, music.getLength()*30, 2);
    y = y + 30;
    for (int i = 1; i <= tones.size() + 1; i = i + 1) {
      g.fillRect(x, y, music.getLength()*30, 2);
      g.drawString(tone.toString(), 20, y - 10);
      tone = tone.nextTone();
      y = y + 30;
    }
  }

  /**
   * Change what music representation is being drawn to m
   * @param m music representation
   */
  public void changeMusic(SafeMusicRepresentation m) {
    this.music = m;
  }

}