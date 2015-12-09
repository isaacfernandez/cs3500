package cs3500.music.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Adapter from MusicRepresentation to MusicModel/
 */
public class MusicModelImpl extends Score implements MusicModel {

  /**
   * Constructs a new MusicModelImpl as a default score.
   */
  public MusicModelImpl() {
    super();
  }

  @Override
  public int getBpm() {
    return this.getTempo()/60000;
  }

  @Override
  public Collection<Note> allNotesOfPitch(int pitch) {
    LinkedList<Note> notes = new LinkedList<Note>();
    for (int x : this.piece.keySet()) {
      for (Tone t : this.piece.get(x)) {
        if (t.getValue() == pitch) {
          notes.add(new ToneToNoteAdapter(t, x));
        }
      }
    }
    return notes;
  }

  @Override
  public Map<Integer, Collection<Note>> sortedNotes() {
    Map<Integer, Collection<Note>> notes = new HashMap<>();
    LinkedList<Note> tempList = new LinkedList<>();
    for (int x : this.piece.keySet()) {
      for (Tone t: this.piece.get(x)) {
        tempList.add(new ToneToNoteAdapter(t, x));
      }
      notes.put(x, tempList);
      tempList.clear();
    }
    return notes;
  }

  @Override
  public Collection<Note> allNotes() {
    LinkedList<Note> notes = new LinkedList<Note>();
    for (int x : this.piece.keySet()) {
      for (Tone t : this.piece.get(x)) {
        notes.add(new ToneToNoteAdapter(t, x));
      }
    }
    return notes;
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
    Tone t = super.lowest();
    return new ToneToNoteAdapter(t, 0); //can use arbitrary beat because they never
    // actually use the beat of this

  }

  @Override
  public Note highestPitch() {
    Tone t = super.highest();
    return new ToneToNoteAdapter(t, 0); //can use arbitrary beat because they never
    // actually use the beat of this
  }

  @Override
  public Collection<Note> notesPlayingAtBeat(int beat) {
    LinkedList<Note> notes = new LinkedList<Note>();
    Tone tempTone = new ToneImp(1, NoteEnum.c, 1, 1, 1);
    ArrayList<Tone> tempList = new ArrayList<Tone>();
    for (int n = 0; n <= beat; n = n + 1) {
      tempList = this.piece.get(n);
      for (int i = 0; i < tempList.size(); i = i + 1) {
        tempTone = tempList.get(i);
        if (n + tempTone.getDuration() > beat) { //inclusive or exclusive?
          notes.add(new ToneToNoteAdapter(tempTone, n));
        }
      }
    }
    return notes;
  }

}
