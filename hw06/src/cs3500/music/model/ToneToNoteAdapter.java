package cs3500.music.model;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Adapter from our Tone to their note
 */
public class ToneToNoteAdapter extends ToneImp implements Note {

  /**
   * The beat the tone/note thing starts at.
   *
   * INVARIANTS:
   *    -- startBeat >= 0
   */
  private int startBeat;

  /**
   * Constructs a tone with the given duration {@code duration}, note {@code note}, octave {@code
   * octave}, volume {@code volume}, and instrument {@code instrument}.
   *
   * @param duration   duration of tone
   * @param note       note of tone
   * @param octave     octave of tone
   * @param volume     volume of tone
   * @param instrument instrument playing tone
   * @throws IllegalArgumentException invalid duration
   * @throws IllegalArgumentException invalid octave
   * @throws IllegalArgumentException invalid volume
   * @throws IllegalArgumentException invalid instrument
   * @throws IllegalArgumentException invalid start beat
   */
  public ToneToNoteAdapter(int duration, NoteEnum note, int octave, int volume, int instrument,
                           int startBeat) {
    super(duration, note, octave, volume, instrument);
    if (this.startBeat >= 0) {
      this.startBeat = startBeat;
    } else {
      throw new IllegalArgumentException("Bad start beat!");
    }
  }

  /**
   * Constructs a tone with the given duration {@code duration}, note representation of String {@code
   * note}, octave {@code octave}, volume {@code volume}, and instrument {@code instrument}.
   *
   * @param duration   duration of tone
   * @param note       string representation of note of tone
   * @param octave     octave of tone
   * @param volume     volume of tone
   * @param instrument instrument playing tone
   * @throws IllegalArgumentException invalid duration
   * @throws IllegalArgumentException invalid note
   * @throws IllegalArgumentException invalid octave
   * @throws IllegalArgumentException invalid volume
   * @throws IllegalArgumentException invalid instrument
   * @throws IllegalArgumentException invalid start beat
   */
  public ToneToNoteAdapter(int duration, String note, int octave, int volume, int instrument,
                           int startBeat) {
    super(duration, note, octave, volume, instrument);
    if (this.startBeat >= 0) {
      this.startBeat = startBeat;
    } else {
      throw new IllegalArgumentException("Bad start beat!");
    }
  }

  /**
   * Constructs a tone that has the same duration, note, octave, and volume as given Tone {@code t}.
   *
   * @param t tone
   * @throws IllegalArgumentException invalid start beat
   */
  public ToneToNoteAdapter(Tone t, int startBeat) {
    super(t);
    if (this.startBeat >= 0) {
      this.startBeat = startBeat;
    } else {
      throw new IllegalArgumentException("Bad start beat!");
    }
  }

  @Override
  public void setVolume(int vol) {
    //This is never used, and our value is final.
  }

  @Override
  public void setInstrument(int instrument) {
    //This is never used, and our value is final.
  }

  @Override
  public String getPitchInOctave() {
    return super.getNote().toString();
  }
  /**
   * Gets the start beat of a given note.
   *
   * @return The start beat (as an integer)
   */
  @Override
  public int getStartBeat() {
    return this.startBeat;
  }

  /**
   * Sets the start beat of a given note.
   *
   * @param beat The start beat as an integer.
   * @throws IllegalArgumentException If that beat is not an acceptable beat for a note to start on
   */
  @Override
  public void setStartBeat(int beat) throws IllegalArgumentException {
    //This is never used, and our value is final.
  }

  @Override
  public int getEndBeat() {
    return startBeat + duration;
  }

  @Override
  public void setEndBeat(int beat) throws IllegalArgumentException {
    //This is never used, and our value is final.
  }

  @Override
  public int getPitch() {
    return super.getValue();
  }

  @Override
  public void setPitch(int pitch) throws IllegalArgumentException {
    //This is never used, and our value is final.
  }

  /**
   * Lets an observer know if a note is starting on a given beat. Possibly helpful for Views.
   *
   * @param beat The beat to check
   * @return True if note is starting on beat passed in, false if not
   */
  @Override
  public boolean starting(int beat) {
    return this.startBeat == beat;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof ToneToNoteAdapter) {
      return this.getValue() == ((ToneToNoteAdapter) o).getValue()
          && this.getDuration() == ((ToneToNoteAdapter) o).getDuration()
          && this.getVolume() == ((ToneToNoteAdapter) o).getVolume()
          && this.getInstrument() == ((ToneToNoteAdapter) o).getInstrument()
          && this.getStartBeat() == ((ToneToNoteAdapter) o).getStartBeat();
    }
    return false;
  }

}
