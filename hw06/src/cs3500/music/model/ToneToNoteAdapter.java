package cs3500.music.model;

/**
 * Adapter from our Tone to their note
 */
public class ToneToNoteAdapter extends ToneImp implements Note{

  //TODO?
  @Override
  public void setVolume(int vol) {
    //they never use setVolume in the view, volume is final
  }

  //TODO?
  @Override
  public void setInstrument(int instrument) {
    //they never use setInstrument in the view, instrument is final
  }

  //TODO
  @Override
  public String getPitchInOctave() {
    //what does this do?
  }

  //TODO
  @Override
  public int getStartBeat() {
    return 0;
  }

  //TODO
  @Override
  public void setStartBeat(int beat) throws IllegalArgumentException {
    //this is gonna suck
  }

  //TODO
  @Override
  public int getEndBeat() {
    return 0;
  }

  //TODO
  @Override
  public void setEndBeat(int beat) throws IllegalArgumentException {
    //also gonna suck
  }

  //TODO
  @Override
  public int getPitch() {
    return 0; //fffffffuuu
  }

  //TODO
  @Override
  public void setPitch(int pitch) throws IllegalArgumentException {
    //what
  }

  //??? TODO
  @Override
  public boolean starting(int beat) {
    return false;
  }
}
