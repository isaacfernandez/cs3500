package cs3500.music.model;

/**
 * Represents a tone in a piece of music.
 */
public interface Tone {
  //Returns a negative value if this is lower than t
  int compare(Tone t);

  /**
   * Returns the value of this tone, an integer representation of the note with 60 being middle C,
   * and the value increasing by one for each tone it is higher than middle C, and decreasing by one
   * for each tone it is lower than middle C.
   *
   * @return value of tone
   */
  int getValue();

  /**
   * Returns the integer {@code volume} of this tone.
   *
   * @return volume of tone
   */
  int getVolume();

  /**
   * Returns the integer representation of this tone, using the representation system specified by
   * MIDI
   *
   * @return int instrument of tone
   */
  int getInstrument();

  /**
   * Returns the tone one higher
   */
  Tone nextTone();

  //Override equality so that tones with the same value and
  @Override
  boolean equals(Object o);

  //Override toString
  @Override
  String toString();

  /**
   * Returns the integer octave of this tone, with C5 representing middle C.
   *
   * @return octave of tone
   */
  int getOctave();

  /**
   * Returns the integer number of beats this tone should be held for.
   *
   * @return duration of tone
   */
  int getDuration();

  /**
   * Returns the note of this tone.
   *
   * @return note of tone
   */
  NoteEnum getNote();
}
