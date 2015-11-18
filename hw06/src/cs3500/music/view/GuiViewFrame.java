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
   * Creates new GuiView
   */
  public GuiViewFrame() {
    super("Music Player");
    JPanel bkgnd = new JPanel();
    this.displayPanel = new MusicGuiViewPanel();
    this.displayPanel.setBackground(Color.WHITE);
    this.displayPanel.setPreferredSize(this.displayPanel.getPreferredSize());
    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    JScrollPane scroll = new JScrollPane(displayPanel,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    scroll.setWheelScrollingEnabled(false);
    scroll.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        e.getAdjustable().setValue(e.getAdjustable().getValue());
      }
    });
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
    this.displayPanel.changeMusic(m);
  }

  /**
   * Sets up the display as it should look during the given beat
   *
   * @param beat the time being displayed
   */
  @Override
  public void displayAtBeat(SafeMusicRepresentation m, int beat) {
    this.displayPanel.displayAtBeat(m, beat);
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