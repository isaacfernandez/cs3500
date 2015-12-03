package cs3500.music.view;

import java.util.Collection;
import cs3500.music.model.MusicModel;
import cs3500.music.model.Note;
import cs3500.music.model.NoteImpl;
import cs3500.music.model.Piece;


public class ConsoleView implements ViewInterface{
  String console = "       ";
  Note totalStart;
  Note totalEnd;
  int endBeat;

  @Override
  public void playPiece(MusicModel m) {
    this.totalStart = m.lowestPitch();
    this.totalEnd = m.highestPitch();
    this.endBeat = m.endBeat();
    for (int i = this.totalStart.getPitch(); i <= this.totalEnd.getPitch(); i++) {
      NoteImpl n = new NoteImpl(0, 0, i);
      console = console + n.getPitchInOctave() + n.getOctave() + " ";
    }
    console+= "\n";
    for (int i = 0; i <= this.endBeat; i++ ) {
      console+= i + "    ";
      if (i < 100) {
        console+= " ";
      }
      if (i < 10) {
        console+= " ";
      }
      this.playBeat(m, i);
    }
    System.out.print(console);
  }

  @Override
  public void playBeat(MusicModel m, int beat) {
    Collection<Note> notesAtBeat = m.notesPlayingAtBeat(beat);
    Collection<Note> notesAtBeatByPitch = Piece.sortNotesByPitch(notesAtBeat);
    int start = this.totalStart.getPitch();
    for (Note n : notesAtBeatByPitch) {
      while (start <= n.getPitch() ) {
        Note forPitch = new NoteImpl(0, 0, start);
        if (n.getPitch() == start) {
          if (n.getStartBeat() == beat) {
            console+= "X";
          }
          else {
            console+= "|";
          }
          console+= addSpaces(forPitch.getPitchInOctave(), true);
        }
        else {
          console+= addSpaces(forPitch.getPitchInOctave(), false);
        }
        start++;
      }
    }
    console += "\n";
  }

  public String addSpaces (String pitch, boolean isNote) {
    if (isNote) {
      if (pitch.length() > 1) {
        return  "   ";
      }
      else {
        return "  ";
      }
    }
    else {
      if (pitch.length() > 1) {
        return "    ";
      }
      else {
        return "   ";
      }
    }
  }

  public void playFromBeat(MusicModel m, int beat) {

  }
}

