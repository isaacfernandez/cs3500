package cs3500.music.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.model.Score;
import cs3500.music.model.Tone;

/**
 * TODO
 */
public class MusicRepresentationTextViewer implements MusicRepresentationView {

  /**
   * Creates a representation of the data idk what the view is suppose to take?
   */
  public void display() {
    //Figure out how wide we'll need to display
  }

  /**
   * Given a list of notes and sustaining notes, rearranges them into a staff SIDEEFFECTS: Mutates
   * sustainedNotes s.t.  any new notes to be sustained are incremented, and notes previous being
   * sustained decreased in value
   */
  private String getFormattedString(List<Tone> notes,
                                    int[] sustained,
                                    int lowEnd, int hiEnd) {
    String[] marks = new String[1 + hiEnd - lowEnd];

    for (Tone t : notes) {
      int index = (t.getValue()) - lowEnd;
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

  }

  /**
   * The 'play' button for the view. Useless for those that statically display the data.
   */
  @Override
  public void play(SafeMusicRepresentation m) {

  }
}
