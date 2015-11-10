package cs3500.hw06;

import java.util.ArrayList;

/**
 * Created by isaacf on 11/2/15.
 */
public interface MusicRepresentation {

    /**
     * Returns the length of the representation of the piece in beats
     * @return int 'width' of the piece
     */
    int getLength();

    /**
     * Returns the range (in octaves) of the piece
     * That is, is the lowest note is in the 2nd octave, and the highest is in the 4
     * this will return 3 (2, 3, 4)
     * @return int 'height' of the piece
     */
    int getRange();

    /**
     *
     */
    Tone lowest();

    Tone highest();

    /**
     * Adds a note with the specified qualities at the specified beat
     * @param beat when the note should start
     * @param duration for how many beats the note should be sustained
     * @param note the note itself, one of { C C♯ D D♯ E F F♯ G G♯ A A♯ B }
     * @param octave which octave the note is to be played in
     * @return MusicRepresentation self, the mutated object
     */
    MusicRepresentation addNote(int beat, int duration, String note, int octave);

    /**
     * Removes the note at beat n. Assumed that only one instrument is playing at a specific beat
     * at a certain octave, ie, there are no two notes the same with different durations
     * @param beat
     * @param note
     * @param octave
     * @return MusicRepresentation self, the mutated object
     */
    MusicRepresentation removeNoteAt(int beat, String note, int octave);

    /**
     * Returns a list of the tones at beat n
     * Can return a list of size 0
     * @param beat
     * @return
     */
    ArrayList<Tone> getNotesAtBeat(int beat);

    /**
     * Useful method for testing
     */
    int countNotes();
}
