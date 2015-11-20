package cs3500.music.view;

import cs3500.music.controller.KeyboardHandler;
import cs3500.music.model.MusicRepresentation;
import cs3500.music.util.TestImpMidiMoReceiver;
import cs3500.music.util.TestSynthesizer;

/**
 * Created by isaacf on 11/11/15.
 * View Factory to abstract over different views
 */
public class MusicRepresentationViewFactory {

  private static KeyboardHandler kb;

  public static MusicRepresentationView makeView(String mode, KeyboardHandler handler) {
    MusicRepresentationViewFactory.kb = handler;
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
      case "visualmidi":
        GuiView g =  new GuiMidiViewImpl();
        g.addKeyListener(MusicRepresentationViewFactory.kb);
        return g;
      default:
        throw new IllegalArgumentException("Not a valid view mode");
    }
  }
}
