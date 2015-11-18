package cs3500.music.view;

import java.util.Collection;
import java.util.List;

import cs3500.music.model.Tone;

/**
 * Created by isaacf on 11/11/15.
 * A simplified form of MusicRepresentation that is unmodifiable
 */
public interface SafeMusicRepresentation {
  Collection<Tone> getNotesAtBeat(int i);

  int getLength();

  Tone lowest();

  Tone highest();

  int getTempo();

  List<Tone> displayNotes();
}
