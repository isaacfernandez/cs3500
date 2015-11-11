package cs3500.music.util;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.model.Score;

/**
 * Created by isaacf on 11/11/15.
 */
public class MusicRepresentationBuilder implements CompositionBuilder<MusicRepresentation> {
    /**
     * Constructs an actual composition, given the notes that have been added
     *
     * @return The new composition
     */


    private MusicRepresentation score;

    public MusicRepresentationBuilder() {
        this.score = new Score();
    }


    @Override
    public MusicRepresentation build() {
        return this.score;
    }

    /**
     * Sets the tempo of the piece
     *
     * @param tempo The speed, in microseconds per beat
     * @return This builder
     */
    @Override
    public CompositionBuilder<MusicRepresentation> setTempo(int tempo) {
        this.score.setTempo(tempo);
        return this;
    }

    /**
     * Adds a new note to the piece
     *
     * @param start      The start time of the note, in beats
     * @param end        The end time of the note, in beats
     * @param instrument The instrument number (to be interpreted by MIDI)
     * @param pitch      The pitch (in the range [0, 127], where 60 represents C4, the middle-C on a
     *                   piano)
     * @param volume     The volume (in the range [0, 127])
     */
    @Override
    public CompositionBuilder<MusicRepresentation> addNote(int start, int end, int instrument, int pitch, int volume) {
        int duration = end - start;
        //TODO
        //MIDI pitch --> Note function
        return this;
    }
}
