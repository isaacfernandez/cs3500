package cs3500.music.view;

import java.awt.*;
import java.awt.event.MouseListener; // Possibly of interest for handling mouse events
import java.awt.event.*;
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
    return new Dimension(1000, 600);
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

  /**
   * For testing purposes, return the log string builder
   */
  @Override
  public Appendable getLog() {
    throw new IllegalArgumentException("We can't test this");
  }
}