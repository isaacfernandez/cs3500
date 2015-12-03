package cs3500.music.model;
// ASK if its okay to change this, originally:: package cs3500.hw05;
import java.util.Collection;
import java.util.Map;


/**
 * DO NOT EDIT THIS
 * CODE COMES FROM THE OTHER PEOPLE
 *
 * Interface for a MusicModel. All {@code MusicModels} must guarantee at least this suite of things.
 */

/* TODO: All note in a pitch, regardless of time

 */
public interface MusicModel {

    /**
     * Returns a Map from integer to a Collection of Notes.<br>
     * Each of these Collections denotes all of the notes that start on the integer.<br>
     *
     * @return A Map from integer to Collection of Notes
     */
    Map<Integer, Collection<Note>> sortedNotes();

    /**
     * Gets all notes in a piece, in the order they were added.
     *
     * @return An unsorted Collection of all notes in a piece.
     */
    Collection<Note> allNotes();

    /**
     * Adds a note to the piece.
     *
     * @param n The Note to add to the piece.
     */
    void addNote(Note n);

    /**
     * Removes a note from a piece. As there cannot be two of the exact same notes in a piece, there
     * should be no ambiguity as to which note to remove.
     *
     * @param n The Note to remove from the piece.
     */
    void removeNote(Note n);

    /**
     * Returns a Collection of all of the Notes starting at beat {@code beat}
     *
     * @param beat The beat to query
     * @return An unsorted Collection of all Notes in the piece that are occurring at a certain beat
     */
    Collection<Note> notesAtBeat(int beat);

    /**
     * Returns the last beat of the piece.
     *
     * @return The last beat of the piece as defined by the Notes currently in it.
     */
    int endBeat();


}