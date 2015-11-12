package cs3500.music.view;

import java.awt.*;
import java.awt.event.MouseListener; // Possibly of interest for handling mouse events

import javax.swing.*;

/**
 * A skeleton Frame (i.e., a window) in Swing
 */
public class GuiViewFrame extends javax.swing.JFrame implements MusicRepresentationView {

  private final MusicGuiViewPanel displayPanel; // You may want to refine this to a subtype of JPanel

  /**
   * Creates new GuiView
   */
  public GuiViewFrame() {
    this.displayPanel = new MusicGuiViewPanel();
    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    this.getContentPane().add(displayPanel);
    this.pack();
  }

  //@Override
  public void initialize() {
    this.setVisible(true);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(500, 300);
  }

  /**
   * Represents the data statically, or sets up window
   */
  @Override
  public void display(SafeMusicRepresentation m) {
    this.displayPanel.changeMusic(m);
  }

  /**
   * The 'play' button for the view. Useless for those that statically display the data.
   */
  @Override
  public void play(SafeMusicRepresentation m) {
  }
}