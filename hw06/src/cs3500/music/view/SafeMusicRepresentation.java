package cs3500.music.view;

import java.util.Collection;
import java.util.List;

import cs3500.music.model.Tone;

/**
 * Created by isaacf on 11/11/15.
 */
public interface SafeMusicRepresentation {
    Collection<Tone> getNotesAtBeat(int i);

    int getLength();

    List<Tone> displayNotes();
}
