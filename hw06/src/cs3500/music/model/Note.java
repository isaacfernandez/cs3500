package cs3500.music.model;

/**
 * Interface for a {@code Note}. All implementations of {@code Note} must guarantee at least this
 * set of things
 */

public interface Note {

  int getVolume();

  void setVolume(int vol);

  int getInstrument();

  void setInstrument(int instrument);

  /**
   * Octaves start at 0
   * @return
   */
  int getOctave();

  String getPitchInOctave();

  /**
   * Gets the start beat of a given note.
   *
   * @return The start beat (as an integer)
   */
  int getStartBeat();

  /**
   * Sets the start beat of a given note.
   *
   * @param beat The start beat as an integer.
   * @throws IllegalArgumentException If that beat is not an acceptable beat for a note to start
   *                                  on
   */
  void setStartBeat(int beat) throws IllegalArgumentException;

  /**
   * Gets the end beat of a given note. This is the beat on which the note ends, not the beat
   * after that. Therefore, a 3 beat long note starting on beat 0 would end on beat 3, not 4.
   *
   * @return the end beat of the note as an integer
   */
  int getEndBeat();

  /**
   * Sets the end of a given note. This is the beat on which the note ends, not the beat after
   * that. Therefore, a 3 beat long note starting on beat 0 would end on beat 3, not 4.
   *
   * @param beat The end beat as an integer
   * @throws IllegalArgumentException If that beat is not an acceptable beat for a note to end on
   */
  void setEndBeat(int beat) throws IllegalArgumentException;

  /**
   * Returns the integer value of the pitch.
   *
   * @return The integer value of the pitch.
   */
  int getPitch();

  /**
   * Sets the integer value pitch of the note.
   *
   * @param pitch The integer value of the pitch of the note
   * @throws IllegalArgumentException If the pitch is an unacceptable value such as a negative
   *                                  pitch or a pitch higher than the upper bound of the
   *                                  implementation
   */
  void setPitch(int pitch) throws IllegalArgumentException;

  /**
   * Returns the length of the note in number of beats.
   *
   * @return The length of the note in number of beats
   */
  int getDuration();

  /**
   * Lets an observer know if a note is starting on a given beat. Possibly helpful for Views.
   *
   * @param beat The beat to check
   * @return True if note is starting on beat passed in, false if not
   */
  boolean starting(int beat);

}