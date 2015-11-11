package cs3500.music.view;

/**
 * Created by isaacf on 11/2/15.
 */
public interface MusicRepresentationView {


    /**
     * Represents the data
     */
    void display(SafeMusicRepresentationDecorator m);

    /**
     * The 'play' button for the view. Useless for those that statically display the data.
     */
    void play(SafeMusicRepresentationDecorator m);
}
