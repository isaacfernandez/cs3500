package cs3500.music.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

/**
 * Adapter from MusicRepresentation to MusicModel/
 */
public class MusicModelImpl extends Score implements MusicModel {

  @Override
  public int getBpm() {
    //TODO
  }

  @Override
  public Collection<Note> allNotesOfPitch(int pitch) {
    return null; //TODO
  }

  @Override
  public Map<Integer, Collection<Note>> sortedNotes() {
    return null; //TODO
  }

  @Override
  public Collection<Note> allNotes() {
    return null; //TODO (i don't think they know what "unsorted" means)
  }

  @Override
  public void addNote(Note n) {
    super.addNote(n.getStartBeat(), n.getDuration(), n.getPitchInOctave(), n.getOctave(),
        n.getVolume(), n.getInstrument());
  }

  @Override
  public void removeNote(Note n) {
    super.removeNoteAt(n.getStartBeat(), n.getPitchInOctave(), n.getOctave());
  }

  @Override
  public Collection<Note> notesAtBeat(int beat) {
    List<Tone> tones = super.getNotesAtBeat(beat);
    LinkedList<Note> notes = new LinkedList<Note>();
    for (Tone t : tones) {
      notes.add(new ToneToNoteAdapter(t, beat));
    }
    return notes;
  }

  @Override
  public int endBeat() {
    return super.getLength();
  }

  @Override
  public Note lowestPitch() {
    return null;
  }

  @Override
  public Note highestPitch() {
    return null;
  }

  @Override
  public Collection<Note> notesPlayingAtBeat(int beat) {
    return null;
  }


}
