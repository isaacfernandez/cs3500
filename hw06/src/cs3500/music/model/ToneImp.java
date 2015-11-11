package cs3500.music.model;

/**
 * Created by isaacf on 11/2/15.
 */
public final class ToneImp implements Tone {

    public final int duration;
    public final int volume;

    public Note getNote() {
        return note;
    }

    public int getOctave() {
        return octave;
    }

    public final Note note;
    public final int octave;

    public ToneImp(int duration, Note note, int octave, int volume) {
        this.duration = duration;
        this.note = note;
        this.octave = octave;
        this.volume = volume;
    }

    public ToneImp(int duration, String note, int octave, int volume) {
        this.duration = duration;
        this.note = Note.StringToNote(note);
        this.octave = octave;
        this.volume = volume;
    }

    public int getDuration() {
        return duration;
    }


    /**
     * Cloning constructor
     */
    public ToneImp(ToneImp t) {
        this.duration = t.duration;
        this.note = t.note;
        this.octave = t.octave;
        this.volume = t.volume;
    }

    public ToneImp(Tone t) {
        this.duration = t.getDuration();
        this.note = t.getNote();
        this.octave = t.getOctave();
        this.volume = t.getVolume();
    }

    //Returns a negative value if this is lower than t
    public int compare(Tone t) {
        if (this.octave < t.getOctave()) {
            return -1;
        }
        else if (this.octave > t.getOctave()) {
            return 1;
        }
        else {
            return this.note.getValue() - t.getNote().getValue();
        }
    }

    @Override
    public int getValue() {
        return this.octave * 12 + this.note.getValue();
    }

    @Override
    public int getVolume() {
        return this.volume;
    }


    @Override
    public Tone nextTone() {
        Note nextPitch =  Note.ValueToNote((this.getValue() % 12) + 1);
        int oct = this.octave;
        if (Note.NoteToString(nextPitch).equals("C")) {
            oct++;
        }
        ToneImp ret = new ToneImp(1, nextPitch, oct, this.volume);
        return ret;
    }

    //Override equality
    @Override
    public boolean equals(Object o) {
        if (o instanceof ToneImp) {
            Tone t = (Tone)o;
            return ((Tone) o).compare(this) == 0 && this.duration == ((ToneImp) o).duration;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.note.toString() + this.octave;
    }

}
