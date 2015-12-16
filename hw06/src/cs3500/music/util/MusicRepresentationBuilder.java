package cs3500.music.util;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.model.Note;
import cs3500.music.model.Score;
import cs3500.music.model.Skip;
import cs3500.music.model.SkipImp;

/**
 * Builder for score.
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
  public CompositionBuilder<MusicRepresentation> addNote(int start, int end, int instrument,
                                                         int pitch, int volume) {
    int duration = end - start;
    int note = pitch % 12;
    int octave = (pitch - note) / 12;
    score.addNote(start, duration, Note.ValueToString(note), octave, volume, instrument);
    return this;
  }

  @Override
  public CompositionBuilder<MusicRepresentation> addRepeat(int start, int end) {
    score.addRepeat(start, end);
    return this;
  }

  //end -- where the alt-ending ends
  //start -- where to jump back to
  //skipfrom -- where to jump forward on second playthrough
  public CompositionBuilder<MusicRepresentation> addAlt(int firstBeat, int startOfAlt, int endOfAlt) {
    Skip permSkip = new SkipImp(endOfAlt); //located at startofAlt
    Skip repeatSkip = new SkipImp(permSkip, startOfAlt, firstBeat); //This is the toplevel rewind skip
    score.addRepeat(endOfAlt, repeatSkip);
    return this;
  }
}
