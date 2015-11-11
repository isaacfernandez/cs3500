package cs3500.music.model;

/**
 * Created by isaacf on 11/4/15.
 */
public interface Tone {
    //Returns a negative value if this is lower than t
    int compare(Tone t);

    int getValue();

    int getVolume();

    int getInstrument();

    Tone nextTone();

    //Override equality
    @Override
    boolean equals(Object o);

    @Override
    String toString();

    int getOctave();

    int getDuration();

    Note getNote();
}
