package cs3500.music.model;

/**
 * Created by isaacf on 11/9/15.
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by isaacf on 11/2/15.
 */
public class Score implements MusicRepresentation {

    private int minOctave;
    private int maxOctave;
    private int tempo;

    //All notes to play at beat n
    private ArrayList<Tone> beat;

    //A map of all list of beats
    private HashMap<Integer, ArrayList> piece;

    public Score() {
        this.minOctave = 12;
        this.maxOctave = 0;
        piece = new HashMap<Integer, ArrayList>();
    }

    /**
     * Adds a note with the specified qualities at the specified beat
     * @param beat when the note should start
     * @param duration for how many beats the note should be sustained
     * @param note the note itself, one of { C C♯ D D♯ E F F♯ G G♯ A A♯ B }
     * @param octave which octave the note is to be played in
     * @return MusicRepresentation self, the mutated object
     * WARN: Adding a note that sustains over another note with the same value can lead to
     * undocumented behavior
     */
    public void addNote(int beat, int duration, Note note, int octave, int vol, int instrument) {
        if (octave > this.maxOctave) {
            this.maxOctave = octave;
        }
        if (octave < this.minOctave) {
            this.minOctave = octave;
        }

        Tone n = new ToneImp(duration, note, octave, vol, instrument);
        ArrayList<Tone> beatsAtN = this.piece.get(beat);
        if (beatsAtN == null) {
            beatsAtN = new ArrayList<Tone>();
        }
        beatsAtN.add(n);
        this.piece.put(beat, beatsAtN);
    }

    /**
     * Returns the length of the representation of the piece in beats
     * Really just returns the max of beat and duration
     * @return int 'width' of the piece
     */
    @Override
    public int getLength() {
        int max = 0;
        for (int n : this.piece.keySet()) {
            ArrayList<Tone> bAN = this.piece.get(n);
            for (Tone t : bAN) {
                int silenceT = (n + t.getDuration());
                max = (max > silenceT ) ? max : silenceT;

            }
        }
        return max;
    }

    /**
     * Returns the range (in octaves) of the piece That is, is the lowest note is in the 2nd octave,
     * and the highest is in the 4 this will return 3 (2, 3, 4)
     *
     * @return int 'height' of the piece
     */
    @Override
    public int getRange() {
        return 1 + (this.maxOctave - this.minOctave);
    }

    /** Lowest tone, to aid views in calculating the range
     * @return lowest Tone
     */
    @Override
    public Tone lowest() {
        Tone lowest = new ToneImp(1, "B", 50, 0, 0);
        for (int n : this.piece.keySet()) {
            ArrayList<Tone> bAN = this.piece.get(n);
            for (Tone t : bAN) {
                if (lowest.compare(t) > 0) {
                    lowest = t;
                }
            }
        }
        return lowest;
    }

    /**
     * Much nicer: Gets the highest tone in the score, to aid views in knowing the range
     * @return the highest tone in the score
     */
    @Override
    public Tone highest() {
        Tone highest = new ToneImp(1, "C", 0, 0, 0);
        for (int n : this.piece.keySet()) {
            ArrayList<Tone> bAN = this.piece.get(n);
            for (Tone t : bAN) {
                if (highest.compare(t) < 0) {
                    highest = t;
                }
            }
        }
        return highest;
    }

    /**
     * Adds a note with the specified qualities at the specified beat
     *
     * @param beat     when the note should start
     * @param duration for how many beats the note should be sustained
     * @param note     the note itself, one of { C C♯ D D♯ E F F♯ G G♯ A A♯ B }
     * @param octave   which octave the note is to be played in
     */
    @Override
    public MusicRepresentation addNote(int beat, int duration, String note,
                                       int octave, int volume, int instrument) {
        this.addNote(beat, duration, note, octave, volume, instrument);
        return this;
    }

    /**
     * Removes the note at beat n. Assumed that only one instrument is playing at a specific beat at
     * a certain octave, ie, there are no two notes the same with different durations
     */
    @Override
    public MusicRepresentation removeNoteAt(int beat, String note, int octave) {
        ArrayList<Tone> ref = this.piece.get(beat);
        if (ref == null) {
            throw new IllegalArgumentException("No note, no beat");
            // throw new IllegalArgumentException("Note d.n.e");
            //Fail silently why not?
        }

        for (Tone t: ref) {
            if (t.getNote().equals(Note.StringToNote(note)) && octave == t.getOctave()) {
                ref.remove(t);
                this.piece.put(beat, ref);
                if (octave == this.minOctave || octave == this.maxOctave) {
                    this.recomputeMinMaxOctave();
                }
                return this;
            }
        }
        throw new IllegalArgumentException("Tried to remove a nonexistent note (2)");
    }

    /**
     * Hideous method to recompute the range in terms of octaves of the score
     */
    private void recomputeMinMaxOctave() {
        int max = 0;
        int min = 12;
        for (int n : this.piece.keySet()) {
            ArrayList<Tone> bAN = this.piece.get(n);
            for (Tone t : bAN) {
                max = (max > t.getOctave()) ? max : t.getOctave();
                min = (min > t.getOctave()) ? t.getOctave() : min;
            }
        }
        this.maxOctave = max;
        this.minOctave = min;
    }

    /**
     * Returns a list of the tones at beat n
     * Can return a list of size 0
     * @param beat where to pick tones from
     * @return An ArrayList<Tone>
     */
    @Override
    public ArrayList<Tone> getNotesAtBeat(int beat) {
        ArrayList<Tone> ref = this.piece.get(beat);
        if (ref == null) {
            ref = new ArrayList<Tone>();
        }
        //Clone the ArrayList so we pass a copy, not a reference
        ArrayList<Tone> ret = new ArrayList<Tone>();
        for (Tone t : ref) {
            ret.add(new ToneImp(t));
        }
        return ret;
    }

    /**
     * Gets the tempo of the piece
     */
    @Override
    public int getTempo() {
        return this.tempo;
    }

    /**
     * Sets the tempo of the piece
     */
    @Override
    public void setTempo(int t) {
        this.tempo = t;
    }

    /**
     * Method for testing / size checking purposes
     * @return the count of notes in the program
     */
    public int countNotes() {
        int count = 0;
        for (int n : this.piece.keySet()) {
            count += this.piece.get(n).size();
        }
        return count;
    }
}
