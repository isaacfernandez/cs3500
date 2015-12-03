package cs3500.music.view;

import java.awt.*;

import javax.swing.*;

import cs3500.music.model.MusicModel;

/**
 * A skeleton Frame (i.e., a window) in Swing
 */
public class GuiViewFrame extends javax.swing.JFrame implements ViewInterface {
    private MusicModel m;

    private final JPanel displayPanel; // You may want to refine this to a subtype of JPanel

    /**
     * Creates new GuiView
     */
    public GuiViewFrame(MusicModel m) {
        this.m = m;
        this.displayPanel = new ConcreteGuiViewPanel(m);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(displayPanel);
        this.pack();
    }

  public GuiViewFrame() {
    this.displayPanel = new ConcreteGuiViewPanel();
    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    this.getContentPane().add(displayPanel);
    this.pack();
  }

//    @Override
    public void initialize() {
        this.setVisible(true);
    }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(m.endBeat() * 12,
            ((m.highestPitch().getPitch() - m.lowestPitch().getPitch()) * 10) + 100);
  }

    @Override
    public void playPiece(MusicModel m) {

    }

    @Override
    public void playBeat(MusicModel m, int beat) {

    }

    @Override
    public void playFromBeat(MusicModel m, int beat) {

    }
}