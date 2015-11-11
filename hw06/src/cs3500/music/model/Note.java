package cs3500.music.model;

/**
 * Created by isaacf on 11/2/15.
 */
//There are 12 notes
public enum Note {
  c(0),
  cS(1),
  d(2),
  dS(3),
  e(4),
  f(5),
  fS(6),
  g(7),
  gS(8),
  a(9),
  aS(10),
  b(11);

  private final int val; //gives us a 0-11 index, also to compare higher / lower
  
  Note(int val) {
    this.val = val;
  }

  /**
   * Returns the integer value of this note.
   * @return value
   */
  public int getValue() {
    return this.val;
  }

  /**
   * Takes a String representation of a note {@code s} and returns a Note. Throws an
   * {@code IllegalArgumentException} if the given String is not a representation of a note.
   *
   * @param s string representation of note, a valid s would be one of
   *          { C C♯ D D♯ E F F♯ G G♯ A A♯ B }
   * @return Note n representing s
   * @throws IllegalArgumentException invalid note
   */
  public static Note StringToNote(String s) {
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

  /**
   * Returns a string representation of the given note {@code n}.
   *
   * @param n note
   * @return string representation of n
   */
  public static String NoteToString(Note n) {
    return Note.ValueToString(n.getValue());
  }

  /**
   * Returns a string representation of the given value {@code n}, which corresponds to
   * a note. Throws an {@code InvalidArgumentException} if value > 11.
   *
   * @param n int representation of note
   * @return string representation of n
   * @throws IllegalArgumentException invalid value
   */
  public static String ValueToString(int n) {
    String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    return notes[n];
  }

  /**
   * Returns a note representation of the given integer value {@code n}, which corresponds
   * to a note. Throws an {@code InvalidArgumentException} if value > 11.
   *
   * @param n int representation of note
   * @return note representation of n
   * @throws IllegalArgumentException invalid value
   */
  public static Note ValueToNote(int n) {
    return Note.StringToNote(Note.ValueToString(n));
  }
}
