package cs3500.music.model;

/**
 * Created by isaacf on 11/2/15.
 */
//There are 12 notes
public enum Note {
    c(1),
    cS(2),
    d(3),
    dS(4),
    e(5),
    f(6),
    fS(7),
    g(8),
    gS(9),
    a(10),
    aS(11),
    b(12);

    private final int val; //gives us a 0-12 index, also to compare higher / lower

    Note(int val) {
        this.val = val;
    }

    public int getValue() {
        return this.val;
    } //I like seeing those other 0 indexes

    /**
     * Takes a String note and returns a Note note
     * @param s One of { C C♯ D D♯ E F F♯ G G♯ A A♯ B }
     * @return Note n representing s
     */
    static Note StringToNote(String s) {
        //Remind me to install jdk7
        if (s.equals("C")) {
            return c;
        }
        if (s.equals("C#")) {
            return cS;
        }
        if (s.equals("D")) {
            return d;
        }
        if (s.equals("D#")) {
            return dS;
        }
        if (s.equals("E")) {
            return e;
        }
        if (s.equals("F")) {
            return f;
        }
        if (s.equals("F#")) {
            return fS;
        }
        if (s.equals("G")) {
            return g;
        }
        if (s.equals("G#")) {
            return gS;
        }
        if (s.equals("A")) {
            return a;
        }
        if (s.equals("A#")) {
            return aS;
        }
        if (s.equals("B")) {
            return b;
        }
        throw new IllegalArgumentException("Invalid Note provided");
    }

    static String NoteToString(Note n) {
        return Note.ValueToString(n.getValue());
    }

    static String ValueToString(int n) {
        String[] notes = { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        return notes[n-1];
    }

    static Note ValueToNote(int n) {
        return Note.StringToNote(Note.ValueToString(n));
    }


}
