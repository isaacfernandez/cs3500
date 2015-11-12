package cs3500.music.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import javax.swing.*;


public class MusicGuiViewPanel extends JPanel {

  private SafeMusicRepresentation music;

  /**
   * Create a view Panel.
   */
  MusicGuiViewPanel() {
    this.music = new SafeMusicRepresentationDecorator();
  }


  @Override
  public void paint(Graphics g){
    int x = 10;
    int y = 10;
    for (int i = 0; i < music.displayNotes().size(); i = i + 1) {
      g.drawRect(x, y, 5, 10);
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
