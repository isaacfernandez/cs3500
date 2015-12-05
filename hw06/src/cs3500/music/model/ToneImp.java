package cs3500.music.model;

/**
 * Implementation of Tone.
 */
public class ToneImp implements Tone {

  /**
   * Duration of the tone as an integer number of beats.
   * INVARIANTS:
   *      - duration > 0
   */
  public final int duration;

  /**
   * Volume of the tone as an integer, with higher numbers representing louder notes.
   *
   * INVARIANTS:
   *      - 0 <= volume < 128
   */
  public final int volume;

  /**
   * Note of the tone.
   */
  public final NoteEnum note;

  /** Octave of the tone.
   * INVARIANTS:
   *      - octave >= 0
   *      - octave <= 10
   *      - if this.note == gS, a, aS, or b, octave <= 9
   */
  public final int octave;

  /**
   * The integer value of the instrument playing the tone.
   * INVARIANTS:
   *      - 1 <= instrument <= 128
   */
  public final int instrument;

  /**
   * Constructs a tone with the given duration {@code duration}, note {@code note},
   * octave {@code octave}, volume {@code volume}, and instrument {@code instrument}.
   *
   * @param duration duration of tone
   * @param note note of tone
   * @param octave octave of tone
   * @param volume volume of tone
   * @param instrument instrument playing tone
   *
   * @throws IllegalArgumentException invalid duration
   * @throws IllegalArgumentException invalid octave
   * @throws IllegalArgumentException invalid volume
   * @throws IllegalArgumentException invalid instrument
   */
  public ToneImp(int duration, NoteEnum note, int octave, int volume, int instrument) {
    //setting duration
    if (duration > 0) {
      this.duration = duration;
    } else {
      throw new IllegalArgumentException("Invalid duration!");
    }
    //setting note
    this.note = note;
    //setting octave
    if (octave >= 0 && octave <= 9) {
      this.octave = octave;
    } else if (!(this.note == NoteEnum.gS || this.note == NoteEnum.a
        || this.note == NoteEnum.aS || this.note == NoteEnum.b) && octave <= 10 && octave >= 0) {
      this.octave = octave;
    } else {
      throw new IllegalArgumentException("Invalid octave!");
    }
    //setting volume
    if (volume >= 0 && volume < 128) {
      this.volume = volume;
    } else {
      throw new IllegalArgumentException("Invalid volume!");
    }
    //setting instrument
    if (instrument >= 0 && instrument < 128) {
      this.instrument = instrument;
    } else {
      throw new IllegalArgumentException("Invalid instrument!");
    }
  }

  /**
   * Constructs a tone with the given duration {@code duration}, note representation of String
   * {@code note}, octave {@code octave}, volume {@code volume}, and instrument {@code instrument}.
   *
   * @param duration duration of tone
   * @param note string representation of note of tone
   * @param octave octave of tone
   * @param volume volume of tone
   * @param instrument instrument playing tone
   *
   * @throws IllegalArgumentException invalid duration
   * @throws IllegalArgumentException invalid note
   * @throws IllegalArgumentException invalid octave
   * @throws IllegalArgumentException invalid volume
   * @throws IllegalArgumentException invalid instrument
   */
  public ToneImp(int duration, String note, int octave, int volume, int instrument) {
    //setting duration
    if (duration > 0) {
      this.duration = duration;
    } else {
      throw new IllegalArgumentException("Invalid duration!");
    }
    //setting note
    this.note = NoteEnum.StringToNote(note);
    //setting octave
    if (octave >= 0 && octave <= 9) {
      this.octave = octave;
    } else if (!(this.note == NoteEnum.gS || this.note == NoteEnum.a
        || this.note == NoteEnum.aS || this.note == NoteEnum.b) && octave <= 10 && octave >= 0) {
      this.octave = octave;
    } else {
      throw new IllegalArgumentException("Invalid octave!" +"" + NoteEnum.NoteToString(this.note));
    }
    //setting volume
    if (volume >= 0 && volume < 128) {
      this.volume = volume;
    } else {
      throw new IllegalArgumentException("Invalid volume!");
    }
    //setting instrument
    if (instrument >= 0 && instrument < 128) {
      this.instrument = instrument;
    } else {
      throw new IllegalArgumentException("Invalid instrument!");
    }
  }

  /*
   * Cloning constructor
   */

  /**
   * Constructs a tone that has the same duration, note, octave, and volume as given
   * Tone {@code t}.
   *
   * @param t tone
   */
  public ToneImp(Tone t) {
    //setting duration
    if (t.getDuration() > 0) {
      this.duration = t.getDuration();
    } else {
      throw new IllegalArgumentException("Invalid duration!");
    }
    //setting note
    this.note = t.getNote();
    //setting octave
    //setting octave
    if (t.getOctave() >= 0 && t.getOctave() <= 9) {
      this.octave = t.getOctave();
    } else if (!(this.note == NoteEnum.gS || this.note == NoteEnum.a
        || this.note == NoteEnum.aS || this.note == NoteEnum.b) && t.getOctave() <= 10
        && t.getOctave() >= 0) {
      this.octave = t.getOctave();
    } else {
      throw new IllegalArgumentException("Invalid octave!");
    }
    //setting volume
    if (t.getVolume() >= 0 && t.getVolume() < 128) {
      this.volume = t.getVolume();
    } else {
      throw new IllegalArgumentException("Invalid volume!");
    }
    //setting instrument
    if (t.getInstrument() >= 0 && t.getInstrument() < 128) {
      this.instrument = t.getInstrument();
    } else {
      throw new IllegalArgumentException("Invalid instrument!");
    }
  }

  //Returns a negative value if this is lower than t
  public int compare(Tone t) {
    if (this.octave < t.getOctave()) {
      return -1;
    } else if (this.octave > t.getOctave()) {
      return 1;
    } else {
      return this.note.getValue() - t.getNote().getValue();
    }
  }

  @Override
  public int getDuration() {
    return duration;
  }

  @Override
  public NoteEnum getNote() {
    return note;
  }

  @Override
  public int getOctave() {
    return octave;
  }

  @Override
  public int getValue() {
    return this.octave * 12 + this.note.getValue();
  }

  @Override
  public int getVolume() {
    return this.volume;
  }

  @Override
  public int getInstrument() {
    return this.instrument;
  }

  @Override
  public Tone nextTone() {
    NoteEnum nextPitch = NoteEnum.ValueToNote((this.getValue() + 1) % 12);
    int oct = octave;
    if (NoteEnum.NoteToString(nextPitch).equals("C")) {
      oct++;
    }
    ToneImp ret = new ToneImp(1, nextPitch, oct, volume, instrument);
    return ret;
  }

  //Override equality
  @Override
  public boolean equals(Object o) {
    if (o instanceof ToneImp) {
      return ((ToneImp) o).compare(this) == 0
          && this.duration == ((ToneImp) o).duration
          && this.volume == ((ToneImp) o).volume
          && this.instrument == ((ToneImp) o).instrument;
    }
    return false;
  }

  @Override
  public String toString() {
    return this.note.toString() + this.octave;
  }

}
