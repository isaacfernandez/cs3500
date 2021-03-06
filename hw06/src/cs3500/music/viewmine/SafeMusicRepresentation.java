package cs3500.music.viewmine;

import java.util.Collection;
import java.util.List;

import cs3500.music.model.Tone;

/**
 * A simplified form of MusicRepresentation that is unmodifiable
 */
public interface SafeMusicRepresentation {
  /**
   * Safely passes a reference to the set of notes at beat i
   *
   * @param i the beat being requested
   * @return beats at i
   */
  Collection<Tone> getNotesAtBeat(int i);

  /**
   * Returns the number of beats in this music piece.
   *
   * @return length of piece
   */
  int getLength();

  /**
   * Returns the lowest note in this music piece.
   *
   * @return lowest note
   */
  Tone lowest();

  /**
   * Returns the highest note in this music piece.
   *
   * @return highest note
   */
  Tone highest();

  /**
   * Returns the tempo of this music piece.
   *
   * @return tempo
   */
  int getTempo();

  /**
   * Returns a list of all of the tones that need to be represented in this piece.
   *
   * @return list of tones
   */
  List<Tone> displayNotes();
}
