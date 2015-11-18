package cs3500.music.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Plays and displays music.
 */
public class GuiMidiViewImpl implements GuiView {
  /**
   * The GUI view of the music.
   *
   * INVARIANT:
   *      - This must be representing the same piece of music at the midi view.
   */
  private GuiViewFrame gui;

  /**
   * The MIDI view of the music.
   *
   * INVARIANT:
   *      - This must be representing the same piece of music at the gui view.
   */
  private MidiViewImpl midi;

  /**
   * Constructs a new GuiMidiViewImpl.
   */
  public GuiMidiViewImpl() {
    this.gui = new GuiViewFrame();
    this.midi = new MidiViewImpl();
  }

  @Override
  public void display(SafeMusicRepresentation m) {
    this.gui.display(m);
    this.midi.display(m);
  }

  /**
   * Sets up the display as it should look during the given beat
   *
   * @param beat the time being displayed
   */
  @Override
  public void displayAtBeat(SafeMusicRepresentation m, int beat) {
    this.gui.display(m);
    this.midi.displayAtBeat(m, beat);
  }

  @Override
  public void play(SafeMusicRepresentation m) {

  }

  @Override
  public Appendable getLog() {
    throw new IllegalArgumentException("We can't test this");
  }
}
