package cs3500.music.util;

import cs3500.music.model.MusicModel;
import cs3500.music.model.MusicModelImpl;
import cs3500.music.model.NoteEnum;

/**
 * Builder for score.
 */
public class MusicModelBuilder implements CompositionBuilder<MusicModel> {
  /**
   * Constructs an actual composition, given the notes that have been added
   *
   * @return The new composition
   */


  private MusicModelImpl score;

  public MusicModelBuilder() {
    this.score = new MusicModelImpl();
  }


  @Override
  public MusicModel build() {
    return this.score;
  }

  /**
   * Sets the tempo of the piece
   *
   * @param tempo The speed, in microseconds per beat
   * @return This builder
   */
  @Override
  public CompositionBuilder<MusicModel> setTempo(int tempo) {
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
  public CompositionBuilder<MusicModel> addNote(int start, int end, int instrument,
                                                         int pitch, int volume) {
    int duration = end - start;
    int note = pitch % 12;
    int octave = (pitch - note) / 12;
    score.addNote(start, duration, NoteEnum.ValueToString(note), octave, volume, instrument);
    return this;
  }
}
