package cs3500.music.tests;

import org.junit.Test;

import cs3500.music.model.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Collection;

public class MusicModelImplTest {

  public MusicModel testSong() {
    MusicModel mus2 = new MusicModelImpl();
    Note n0 = new ToneToNoteAdapter(1, "C#", 4, 100, 0, 0);
    Note n1 = new ToneToNoteAdapter(2, "D#", 4, 100, 0, 1);
    Note n2 = new ToneToNoteAdapter(3, "E", 3, 100, 0, 2);
    Note n3 = new ToneToNoteAdapter(1, "C", 4, 100, 0, 0);
    mus2.addNote(n0);
    mus2.addNote(n1);
    mus2.addNote(n2);
    mus2.addNote(n3);
    return mus2;
  }

  /*
  tests constructor exceptions on ToneToNoteAdapter
   */

  @Test(expected = IllegalArgumentException.class)
  public void testTone2NoteConstructorException0() {
    Note t = new ToneToNoteAdapter(0, "A", 1, 100, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTone2NoteConstructorException1() {
    Note t = new ToneToNoteAdapter(-2, NoteEnum.aS, 2, 90, 0, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTone2NoteConstructorException2() {
    Note t = new ToneToNoteAdapter(2, "As", 5, 80, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTone2NoteConstructorException3() {
    Note t = new ToneToNoteAdapter(2, "C", -1, 90, 0, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTone2NoteConstructorException4() {
    Note t = new ToneToNoteAdapter(1, NoteEnum.b, 10, 90, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTone2NoteConstructorException5() {
    Note t = new ToneToNoteAdapter(5, "D", -1, 100, 0, 300);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTone2NoteConstructorException6() {
    Note t = new ToneToNoteAdapter(5, NoteEnum.dS, 11, 100, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTone2NoteConstructorException7() {
    Note t = new ToneToNoteAdapter(1, NoteEnum.b, 6, -1, 0, 12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTone2NoteConstructorException9() {
    Note t = new ToneToNoteAdapter(2, "A", 5, 128, 1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTone2NoteConstructorException10() {
    Note t = new ToneToNoteAdapter(2, NoteEnum.g, 5, 142, 1, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTone2NoteConstructorException11() {
    Note t = new ToneToNoteAdapter(2, NoteEnum.g, 5, 142, 1, -1);
  }

  public void notesAtBeatTest0() {
    MusicModel music = this.testSong();
    Collection<Note> notes = music.notesAtBeat(0);
    assertEquals(notes.size(), 2);
    assertTrue(notes.contains(new ToneToNoteAdapter(1, "C#", 4, 100, 0, 0)));
    assertTrue(notes.contains(new ToneToNoteAdapter(1, "C", 4, 100, 0, 0)));
  }

  public void notesAtBeatTest1() {
    MusicModel music = this.testSong();
    Collection<Note> notes = music.notesAtBeat(1);
    assertEquals(notes.size(), 1);
    assertTrue(notes.contains(new ToneToNoteAdapter(2, "D#", 4, 100, 0, 1)));
  }

  public void allNotesOfPitchTest0() {
    MusicModel music = this.testSong();
    Collection<Note> notes = music.allNotesOfPitch(48);
    assertEquals(notes.size(), 1);
    assertTrue(notes.contains(new ToneToNoteAdapter(1, "C", 4, 100, 0, 0)));
  }

  public void allNotesOfPitchTest1() {
    MusicModel music = this.testSong();
    Collection<Note> notes = music.allNotesOfPitch(2);
    assertEquals(notes.size(), 0);
  }


}
