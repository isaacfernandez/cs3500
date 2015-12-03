package cs3500.music.viewmine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.model.Score;
import cs3500.music.model.Tone;
import cs3500.music.model.ToneImp;

/**
 * Wraps around a MusicRepresentation to present a safe version to a view.
 */
public class SafeMusicRepresentationDecorator implements SafeMusicRepresentation {
  //Protects the Model from the View
  //should be be an interface?

  /**
   * The MusicRepresentation this safe representation represents.
   */
  private final MusicRepresentation model;

  /**
   * Constructs a new SafeMusicRepresentationDecorator from the given {@code model}
   *
   * @param model the music piece
   */
  public SafeMusicRepresentationDecorator(MusicRepresentation model) {
    this.model = model;
  }

  /**
   * Constructs a safe music representation decorator with a blank score
   */
  public SafeMusicRepresentationDecorator() {
    this.model = new Score();
  }

  @Override
  public Collection<Tone> getNotesAtBeat(int i) {
    return Collections.unmodifiableCollection(this.model.getNotesAtBeat(i));
  }

  @Override
  public int getLength() {
    return model.getLength();
  }

  @Override
  public Tone lowest() {
    return model.lowest();
  }

  @Override
  public Tone highest() {
    return model.highest();
  }

  @Override
  public int getTempo() {
    return model.getTempo();
  }

  @Override
  public List<Tone> displayNotes() {
    ArrayList<Tone> notes = new ArrayList<Tone>();
    Tone header = model.lowest();
    Tone highest = model.highest();
    do {
      //Should split into a 'nextTone' method
      notes.add(new ToneImp(header));
      header = header.nextTone();
    } while (highest.compare(header) >= 0);
    return notes;
  }
}
