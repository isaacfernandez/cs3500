package cs3500.music.model;

/**
 * Adapter from our Tone to their note
 */
public class ToneToNoteAdapter extends ToneImp implements Note {

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
   */
  public ToneToNoteAdapter(int duration, NoteEnum note, int octave, int volume, int instrument,
                           int startBeat) {
    super(duration, note, octave, volume, instrument);
    this.startBeat = startBeat;
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
   */
  public ToneToNoteAdapter(int duration, String note, int octave, int volume, int instrument,
                           int startBeat) {
    super(duration, note, octave, volume, instrument);
    this.startBeat = startBeat;
  }

  /**
   * Constructs a tone that has the same duration, note, octave, and volume as given Tone {@code t}.
   *
   * @param t tone
   */
  public ToneToNoteAdapter(Tone t, int startBeat) {
    super(t);
    this.startBeat = startBeat;
  }

  @Override
  public void setVolume(int vol) {
    //TODO lol
  }

  @Override
  public void setInstrument(int instrument) {
    //TODO also lol
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
    //TODO We dont actually need this
  }

  /**
   * Gets the end beat of a given note. This is the beat on which the note ends, not the beat after
   * that. Therefore, a 3 beat long note starting on beat 0 would end on beat 3, not 4.
   *
   * @return the end beat of the note as an integer
   */
  @Override
  public int getEndBeat() {
    //TODO We dont actually need this
    return 0;
  }

  /**
   * Sets the end of a given note. This is the beat on which the note ends, not the beat after that.
   * Therefore, a 3 beat long note starting on beat 0 would end on beat 3, not 4.
   *
   * @param beat The end beat as an integer
   * @throws IllegalArgumentException If that beat is not an acceptable beat for a note to end on
   */
  @Override
  public void setEndBeat(int beat) throws IllegalArgumentException {
    //TODO We dont actually need this
  }

  /**
   * Returns the integer value of the pitch.
   *
   * @return The integer value of the pitch.
   */

  @Override
  public int getPitch() {
    return super.getValue();
  }
  /**
   * Sets the integer value pitch of the note.
   *
   * @param pitch The integer value of the pitch of the note
   * @throws IllegalArgumentException If the pitch is an unacceptable value such as a negative pitch
   *                                  or a pitch higher than the upper bound of the implementation
   */
  @Override
  public void setPitch(int pitch) throws IllegalArgumentException {
    //TODO We dont actually need this
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
}
