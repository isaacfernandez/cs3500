package cs3500.music.view;

import java.util.Collection;

import javax.sound.midi.*;

import cs3500.music.model.*;

/**
 * Midi Playback
 */
public class MidiViewImpl implements MusicRepresentationView {
  private Synthesizer synth;
  private Receiver receiver;

  public MidiViewImpl() {
    try {
      this.synth = MidiSystem.getSynthesizer();
      this.receiver = synth.getReceiver();
      this.synth.open();
    } catch (MidiUnavailableException e) {
      e.printStackTrace();
    }
  }

  //debug mode MidiViewImpl
  public MidiViewImpl(Synthesizer testy) {
    this.synth = testy;
    try {
      this.receiver = testy.getReceiver();
    } catch (MidiUnavailableException e) {
      e.printStackTrace();
    }
  }

  /**
   * Relevant classes and methods from the javax.sound.midi library:
   * <ul>
   *   <li>{@link MidiSystem#getSynthesizer()}</li>
   *   <li>{@link Synthesizer}
   *   <ul>
   *     <li>{@link Synthesizer#open()}</li>
   *     <li>{@link Synthesizer#getReceiver()}</li>
   *     <li>{@link Synthesizer#getChannels()}</li> </ul> </li>
   *     <li>{@link Receiver}
   *     <ul>
   *       <li>{@link Receiver#send(MidiMessage, long)}</li>
   *       <li>{@link Receiver#close()}</li> </ul> </li>
   *       <li>{@link MidiMessage}</li>
   *       <li>{@link ShortMessage}</li>
   *       <li>{@link MidiChannel}
   *       <ul>
   *         <li>{@link MidiChannel#getProgram()}</li>
   *         <li>{@link MidiChannel#programChange(int)}</li> </ul> </li></ul>
   *
   * @see <a href="https://en.wikipedia.org/wiki/General_MIDI">
   *   https://en.wikipedia.org/wiki/General_MIDI</a>
   */

  public void playNote(Collection<Tone> tones, int beat, int tempo)
      throws InvalidMidiDataException {
    for (Tone t : tones) {
      MidiMessage inst = new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0,
          t.getInstrument() - 1, 1);
      MidiMessage start = new ShortMessage(ShortMessage.NOTE_ON, 0, t.getValue(), t.getVolume());
      MidiMessage stop = new ShortMessage(ShortMessage.NOTE_OFF, 0, t.getValue(), t.getVolume());
      // -------------------------------------------->ON/OFF, instrument, note, vol
      this.receiver.send(inst, -1);
      this.receiver.send(start, -1);
      int endTime = (t.getDuration() + beat - 1) * tempo / 1000;
      this.receiver.send(stop, this.synth.getMicrosecondPosition() + endTime);
    }

  }

    /**
     * Represents the data statically, or sets up window
     */
    @Override
    public void display(SafeMusicRepresentation m) {
      for (int i = 0; i < m.getLength(); i++) {
        try {
          this.playNote(m.getNotesAtBeat(i), i, m.getTempo());
          Thread.sleep(m.getTempo() / 1000);
        } catch (InvalidMidiDataException e) {
          System.out.println("Invalid midi");
          e.printStackTrace();
        } catch (InterruptedException e) {
          System.out.println("I'm trying to sleep, shhh");
          e.printStackTrace();
        }
      }
      this.receiver.close(); // Only call this once you're done playing *all* notes
    }

  public void displayAtBeat(SafeMusicRepresentation m, int i) {
    try {
      this.playNote(m.getNotesAtBeat(i), i, m.getTempo());
    } catch (InvalidMidiDataException e) {
      System.out.println("Invalid midi");
      e.printStackTrace();
    }
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
    return new StringBuilder(this.receiver.toString());
  }
}