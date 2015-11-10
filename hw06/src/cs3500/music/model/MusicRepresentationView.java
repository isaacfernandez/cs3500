package cs3500.music.model;

/**
 * Created by isaacf on 11/2/15.
 */
public interface MusicRepresentationView {

    //The constructor for a MusicRepresentationView should take a file
    //The file should only contains lines formatted like
    //0 4 D# 3
    //<beat> <duration> <pitch> <octave>


    /**
     * Represents the data
     */
    void display();
}
