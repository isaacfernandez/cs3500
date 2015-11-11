package cs3500.music.view;

import cs3500.music.model.MusicRepresentation;

/**
 * Created by isaacf on 11/11/15.
 */
public class MusicController {
    private final MusicRepresentationView view;
    private final MusicRepresentation model;

    public MusicController(MusicRepresentation model, String mode) {
        this.model = model;
        //TODO
        this.view = null;
    }
}
