package cs3500.music.model;

/**
 * Adapter from MusicRepresentation to MusicModel/
 */
public class MusicModelImpl extends Score implements MusicModel {

  //TODO fix this
  @Override
  public int getBpm() {
    return super.getTempo();
  }

  @Override
  public int endBeat() {
    return super.getLength();
  }


}
