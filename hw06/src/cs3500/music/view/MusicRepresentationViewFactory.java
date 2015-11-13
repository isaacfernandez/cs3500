package cs3500.music.view;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.util.TestImpMidiMoReceiver;
import cs3500.music.util.TestSynthesizer;

/**
 * Created by isaacf on 11/11/15.
 */
public class MusicRepresentationViewFactory {

  private final SafeMusicRepresentation m;

  MusicRepresentationViewFactory(SafeMusicRepresentation m) {
    this.m = m;
  }

  static MusicRepresentationView makeView(String mode) {
    return MusicRepresentationViewFactory.makeView(mode, new StringBuilder());
  }
  static MusicRepresentationView makeView(String mode, StringBuilder log) {
    switch (mode) {
      case "console":
        return new MusicRepresentationTextViewer();
      case "testconsole":
        return new MusicRepresentationTextViewer(log);
      case "midi":
        return new MidiViewImpl();
      case "testmidi":
        return new MidiViewImpl(new TestSynthesizer(log));
      case "visual":
        return new GuiViewFrame();
      default:
        throw new IllegalArgumentException("Not a valid view mode");
    }
  }
}
