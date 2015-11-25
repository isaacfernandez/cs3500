package cs3500.music.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;

import cs3500.music.model.Tone;

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
    this.gui.displayAtBeat(m, beat);
    this.midi.displayAtBeat(m, beat);
  }

  @Override
  public void play(SafeMusicRepresentation m) {

  }

  @Override
  public Appendable getLog() {
    throw new IllegalArgumentException("We can't test this");
  }

  /**
   * KeyListener for GUI view.
   */
  @Override
  public void addKeyListener(KeyListener listener) {
    this.gui.addKeyListener(listener);
  }

  @Override
  public Tone toneAt(int x, int y) {
    return this.gui.toneAt(x, y);
  }

  @Override
  public int beatAt(int x, int y) {
    return this.gui.beatAt(x, y);
  }
}
