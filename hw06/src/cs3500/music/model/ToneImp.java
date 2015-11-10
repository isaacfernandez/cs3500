package cs3500.music.model;

/**
 * Created by isaacf on 11/2/15.
 */
public final class ToneImp implements Tone {

    public final int duration;

    public Note getNote() {
        return note;
    }

    public int getOctave() {
        return octave;
    }

    public final Note note;
    public final int octave;

    public ToneImp(int duration, Note note, int octave) {
        this.duration = duration;
        this.note = note;
        this.octave = octave;
    }

    public ToneImp(int duration, String note, int octave) {
        this.duration = duration;
        this.note = Note.StringToNote(note);
        this.octave = octave;
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
    }

    public ToneImp(Tone t) {
        this.duration = t.getDuration();
        this.note = t.getNote();
        this.octave = t.getOctave();
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
    public Tone nextTone() {
        Note nextPitch =  Note.ValueToNote((this.getValue() % 12) + 1);
        int oct = this.octave;
        if (Note.NoteToString(nextPitch).equals("C")) {
            oct++;
        }
        ToneImp ret = new ToneImp(1, nextPitch, oct);
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
