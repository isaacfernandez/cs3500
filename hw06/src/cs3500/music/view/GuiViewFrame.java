package cs3500.music.view;

import java.awt.*;
import java.awt.event.MouseListener; // Possibly of interest for handling mouse events
import java.awt.event.*;
import javax.swing.*;

/**
 * Mother GuiViewFrame
 */
public class GuiViewFrame extends javax.swing.JFrame implements GuiView {

  private final MusicGuiViewPanel displayPanel;

  /**
   * A panel with a bar indicating the curent beat.
   */
  private GuiBeatPanel beatBar;

  /**
   * Creates new GuiView
   */
  public GuiViewFrame() {
    super("Music Player");
    JPanel bkgnd = new JPanel();
    this.displayPanel = new MusicGuiViewPanel();
    this.displayPanel.setBackground(Color.WHITE);
    this.displayPanel.setPreferredSize(this.displayPanel.getPreferredSize());
    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    this.beatBar = new GuiBeatPanel();
    this.beatBar.add(displayPanel);
    JScrollPane scroll = new JScrollPane(beatBar,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    scroll.setWheelScrollingEnabled(false);
    //JScrollBar hor = scroll.getHorizontalScrollBar();
    //hor.setValue(hor.getMaximum());
    this.getContentPane().add(scroll);
    this.setBackground(Color.WHITE);
    this.pack();
    this.initialize();
  }

  //@Override
  public void initialize() {
    this.setVisible(true);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(1200, 700);
  }

  /**
   * Represents the data statically, or sets up window
   */
  @Override
  public void display(SafeMusicRepresentation m) {
    if (this.displayPanel.changeMusic(m)) {
      this.displayPanel.repaint();
    }
  }

  /**
   * Sets up the display as it should look during the given beat
   *
   * @param beat the time being displayed
   */
  @Override
  public void displayAtBeat(SafeMusicRepresentation m, int beat) {
    if (this.displayPanel.changeMusic(m)) {
      this.displayPanel.repaint();
    }
    this.beatBar.setBeat(beat);
    this.beatBar.repaint();
}

  /**
   * The 'play' button for the view. Useless for those that statically display the data.
   */
  @Override
  public void play(SafeMusicRepresentation m) {
  }

  /**
   * For testing purposes, return the log string builder
   */
  @Override
  public Appendable getLog() {
    throw new IllegalArgumentException("We can't test this");
  }

}