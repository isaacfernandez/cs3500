package cs3500.music.view;

import cs3500.music.model.MusicRepresentation;

/**
 * Created by isaacf on 11/11/15.
 */
public class MusicRepresentationViewFactory {

    private final SafeMusicRepresentation m;

    MusicRepresentationViewFactory(SafeMusicRepresentation m) {
        this.m = m;
    }

    static MusicRepresentationView makeView(String mode) {
        switch (mode) {
            case "console":
                return new MusicRepresentationTextViewer();
            case "midi":
                return new MidiViewImpl();
            case "visual":
                return new GuiViewFrame();
            default:
                throw new IllegalArgumentException("Not a valid view mode");
        }
    }
}
