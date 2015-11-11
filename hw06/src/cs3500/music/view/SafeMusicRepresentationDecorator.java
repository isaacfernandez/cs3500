package cs3500.music.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.model.Tone;
import cs3500.music.model.ToneImp;

/**
 * Created by isaacf on 11/11/15.
 */
public class SafeMusicRepresentationDecorator {
    //Protects the Model from the View
    //should be be an interface?

    private final MusicRepresentation model;

    public SafeMusicRepresentationDecorator(MusicRepresentation model) {
        this.model = model;
    }

    /**
     * Safely passes a reference to the set of notes at beat i
     * @param i the beat being requested
     * @return
     */
    public Collection<Tone> getNotesAtBeat(int i) {
        return Collections.unmodifiableCollection(this.model.getNotesAtBeat(i));
    }

    /**
     * Returns the length of the piece
     * @return
     */
    public int getLength() {
        return model.getLength();
    }

    /**
     * Returns a list of Tones (Pitch & Octave) that must be displayed for a full range
     * @return
     */
    public List<Tone> displayNotes() {
        ArrayList<Tone> notes = new ArrayList<Tone>();
        Tone header = model.lowest();
        Tone highest = model.highest();
        do {
            //Should split into a 'nextTone' method
            header = header.nextTone();
            notes.add(new ToneImp(header));
        } while (highest.compare(header) >= 0);
        return notes;
    }



}
