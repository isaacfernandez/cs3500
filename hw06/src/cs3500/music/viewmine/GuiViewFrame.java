package cs3500.music.viewmine;

import java.awt.*;

import javax.swing.*;

import cs3500.music.model.Tone;

/**
 * Mother GuiViewFrame
 */
public class GuiViewFrame extends javax.swing.JFrame implements GuiView {

  private final MusicGuiViewPanel displayPanel;

  /**
   * A panel with a bar indicating the curent beat.
   */
  private GuiBeatPanel beatBar;

  private JScrollPane scroll;
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
    this.scroll = new JScrollPane(beatBar,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    this.scroll.setWheelScrollingEnabled(false);
    this.scroll.getHorizontalScrollBar().setValue(0);
    //JScrollBar hor = scroll.getHorizontalScrollBar();
    //hor.setValue(hor.getMaximum());
    this.getContentPane().add(this.scroll);
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
    this.scroll.getHorizontalScrollBar().setValue(beat*30);
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


  @Override
  public Tone toneAt(int x, int y) {
    return null;
  }

  @Override
  public int beatAt(int x, int y) {
    if (x < 50) {
      return 0;
    } else {
      return (x - 50) / 30;
    }
  }
}