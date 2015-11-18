package cs3500.music.view;

/**
 * Plays and displays music.
 */
public class GuiMidiViewImpl implements MusicRepresentationView {
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
    gui.display(m);
    midi.display(m);
  }

  @Override
  public void play(SafeMusicRepresentation m) {

  }

  @Override
  public Appendable getLog() {
    throw new IllegalArgumentException("We can't test this");
  }
}
