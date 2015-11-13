package cs3500.music.view;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import cs3500.music.model.Note;
import cs3500.music.model.Tone;

/**
 * TODO
 */
public class MusicRepresentationTextViewer implements MusicRepresentationView {

  private Appendable out;

  public MusicRepresentationTextViewer() {
    this.out = System.out;
  }

  public MusicRepresentationTextViewer(StringBuilder b) {
    this.out = b;
  }

  /**
   * Given a list of notes and sustaining notes, rearranges them into a staff SIDEEFFECTS: Mutates
   * sustainedNotes s.t.  any new notes to be sustained are incremented, and notes previous being
   * sustained decreased in value
   */
  private String getFormattedString(Collection<Tone> notes,
                                    int[] sustained, int low) {
    String[] marks = new String[sustained.length];

    for (Tone t : notes) {
      int index = (t.getValue()) - low;
      marks[index] = "X   "; //Note.NoteToString(t.note);
      if (t.getDuration() > 1) {
        sustained[index] = t.getDuration() - 1; //Account for the current playing note, 1 tick
      }
    }
    //INVARIANT: A note held down never overlaps another note at the same tone
    for (int i = 0; i < sustained.length; i++) {
      if (sustained[i] > 0) {
        if (!(marks[i] != null && marks[i].equals("X   "))) {
          marks[i] = "|   ";
        }
        sustained[i] = sustained[i] - 1;
      }
    }

    StringBuilder builder = new StringBuilder();

    for (String s : marks) {
      if (builder.length() > 0) {
        //builder.append("");
      }
      if (s == null) {
        builder.append("    ");
        continue;
      }
      builder.append(s);
    }

    String string = builder.toString();
    return string;
  }

  /**
   * Represents the data statically, or sets up window
   */
  @Override
  public void display(SafeMusicRepresentation m) {
      List<Tone> range = m.displayNotes();
      int[] sustainedNotes = new int[range.size()];
      StringBuilder headBuilder = new StringBuilder();
      //build header
      for (Tone t:  range) {
          String s = String.format("%1$-4s", Note.NoteToString(t.getNote()) + "" +  t.getOctave());
          headBuilder.append(s);
      }
      String header = headBuilder.toString();
    this.print(header);
    StringBuilder builder = new StringBuilder();
      int length = m.getLength();
      for (int i = 0; i < length; i++) {
        builder.append(this.getFormattedString(m.getNotesAtBeat(i),
            sustainedNotes,
            m.lowest().getValue()));
          builder.append("\n");
      }
      String display = builder.toString();
      this.print(display);
  }

  private void print(String s) {
    try {
      this.out.append(s);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * The 'play' button for the view. Useless for those that statically display the data.
   */
  @Override
  public void play(SafeMusicRepresentation m) {

  }

  /**
   * For testing purposes, return the log string builder
   */
  @Override
  public Appendable getLog() {
    return this.out;
  }
}
