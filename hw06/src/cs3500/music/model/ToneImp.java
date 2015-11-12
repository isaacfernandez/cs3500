package cs3500.music.model;

/**
 * Implementation of Tone.
 */
public final class ToneImp implements Tone {

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
  public final Note note;

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
   *      - //TODO
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
  public ToneImp(int duration, Note note, int octave, int volume, int instrument) {
    //setting duration
    if (duration > 0) {
      this.duration = duration;
    } else {
      throw new IllegalArgumentException("Invalid duration!");
    }
    //setting note
    this.note = note;
    //setting octave
    if (octave >= 0 && octave < 9) {
      this.octave = octave;
    } else if (!(this.note == Note.gS || this.note == Note.a
        || this.note == Note.aS || this.note == Note.b) && octave < 10) {
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
    this.instrument = instrument;
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
    this.note = Note.StringToNote(note);
    //setting octave
    if (octave >= 0 && octave <= 9) {
      this.octave = octave;
    } else if (!(this.note == Note.gS || this.note == Note.a
        || this.note == Note.aS || this.note == Note.b) && octave <= 10) {
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
    this.instrument = instrument;
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
    } else if (!(this.note == Note.gS || this.note == Note.a
        || this.note == Note.aS || this.note == Note.b) && t.getOctave() <= 10) {
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
    this.instrument = t.getInstrument();
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
  public Note getNote() {
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
    Note nextPitch = Note.ValueToNote((this.getValue() % 12) + 1);
    int oct = octave;
    if (Note.NoteToString(nextPitch).equals("C")) {
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
