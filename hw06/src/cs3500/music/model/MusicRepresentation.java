package cs3500.music.model;

import java.util.List;
import java.util.Map;

/**
 * Represents a music piece.
 */
public interface MusicRepresentation {

  /**
   * Returns the length of the representation of the piece in beats
   *
   * @return int 'width' of the piece
   */
  int getLength();

  /**
   * Returns the range (in octaves) of the piece That is, is the lowest note is in the 2nd octave,
   * and the highest is in the 4 this will return 3 (2, 3, 4)
   *
   * @return int 'height' of the piece
   */
  int getRange();

  /**
   * Returns the lowest tone of the piece.
   *
   * @return lowest tone of piece
   */
  Tone lowest();

  /**
   * Returns the highest tone of the piece.
   *
   * @return highest tone of piece
   */
  Tone highest();

  /**
   * Adds a note with the specified qualities at the specified beat
   *
   * @param beat     when the note should start
   * @param duration for how many beats the note should be sustained
   * @param note     the note itself, one of { C C♯ D D♯ E F F♯ G G♯ A A♯ B }
   * @param octave   which octave the note is to be played in
   * @return MusicRepresentation self, the mutated object
   */
  MusicRepresentation addNote(int beat, int duration, String note, int octave, int volume,
                              int instrument);

  /**
   * Removes the note at beat n. Assumed that only one instrument is playing at a specific beat at
   * a certain octave, ie, there are no two notes the same with different durations
   *
   * @return MusicRepresentation self, the mutated object
   */
  MusicRepresentation removeNoteAt(int beat, String note, int octave);

  /**
   * Returns a list of the tones starting at beat n Can return a list of size 0, representing no
   * tones starting at that beat
   *
   * @return list of notes at beat
   */
  List<Tone> getNotesAtBeat(int beat);

  /**
   * Returns the int tempo of the piece.
   *
   * @return tempo
   */
  int getTempo();

  /**
   * Returns a Map, (int)Beat -> Repeat
   * @return the map
   */
  Map<Integer, Integer> getRepeats();

  /**
   * Adds a repeat from startbeat to endbeat
   */
  void addRepeat(int start, int end);

  /**
   * Sets the int tempo of the piece to {@code t}.
   */
  void setTempo(int t);

  /**
   * Counts number of tones in piece, useful for testing.
   *
   * @returns number of tones in piece
   */
  int countNotes();

}
