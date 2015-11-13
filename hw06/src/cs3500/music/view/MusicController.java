package cs3500.music.view;

import java.util.Objects;

import javax.swing.text.ViewFactory;

import cs3500.music.model.MusicRepresentation;

/**
 * Representation of a controller for a MusicRepresentation.
 */
public class MusicController {
  private final MusicRepresentationView view;
  private final MusicRepresentation model;
  String mode;

  public MusicController(MusicRepresentation model, String mode) {
    this.mode = mode;
    this.model = Objects.requireNonNull(model);
    this.view = MusicRepresentationViewFactory.makeView(mode);
  }

  //Returns a string for debugging purposes
  public String start() {
    this.view.display(new SafeMusicRepresentationDecorator(this.model));
    if (this.mode.contains("test")) {
      return ((StringBuilder) this.view.getLog()).toString();
    } else {
      return "";
    }
  }
}
