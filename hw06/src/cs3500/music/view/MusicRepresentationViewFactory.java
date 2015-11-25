package cs3500.music.view;

import cs3500.music.controller.KeyboardHandler;
import cs3500.music.controller.MouseHandlerPointer;
import cs3500.music.model.MusicRepresentation;
import cs3500.music.util.TestImpMidiMoReceiver;
import cs3500.music.util.TestSynthesizer;

/**
 * View Factory to abstract over different views
 */
public class MusicRepresentationViewFactory {

  private static KeyboardHandler kb;
  private static MouseHandlerPointer p;

  public static MusicRepresentationView makeView(String mode, KeyboardHandler handler, MouseHandlerPointer mhandler) {
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
        g.addMouseMotionListener(MusicRepresentationViewFactory.p);
        g.addMouseListener(MusicRepresentationViewFactory.p);
        return g;
      default:
        throw new IllegalArgumentException("Not a valid view mode");
    }
  }
}
