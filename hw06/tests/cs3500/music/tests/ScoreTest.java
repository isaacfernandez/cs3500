package cs3500.music.tests;

import org.junit.Test;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.model.Note;
import cs3500.music.model.NoteEnum;
import cs3500.music.model.Score;
import cs3500.music.model.Tone;
import cs3500.music.model.ToneImp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScoreTest {

  //addNote(int beat, int duration, String note, int octave);
  public MusicRepresentation testSong() {
    MusicRepresentation mus2 = new Score();
    mus2.addNote(0, 1, "C#", 4, 100, 0);
    mus2.addNote(1, 2, "D#", 4, 100, 0);
    mus2.addNote(2, 3, "E", 3, 100, 0);
    mus2.addNote(0, 1, "C", 4, 100, 0);
    return mus2;
  }

  /*
  tests constructor exceptions on tone
   */

  @Test(expected = IllegalArgumentException.class)
  public void testToneConstructorException0() {
    Tone t = new ToneImp(0, "A", 1, 100, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToneConstructorException1() {
    Tone t = new ToneImp(-2, NoteEnum.aS, 2, 90, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToneConstructorException2() {
    Tone t = new ToneImp(2, "As", 5, 80, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToneConstructorException3() {
    Tone t = new ToneImp(2, "C", -1, 90, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToneConstructorException4() {
    Tone t = new ToneImp(1, NoteEnum.b, 10, 90, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToneConstructorException5() {
    Tone t = new ToneImp(5, "D", -1, 100, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToneConstructorException6() {
    Tone t = new ToneImp(5, NoteEnum.dS, 11, 100, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToneConstructorException7() {
    Tone t = new ToneImp(1, NoteEnum.b, 6, -1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToneConstructorException9() {
    Tone t = new ToneImp(2, "A", 5, 128, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToneConstructorException10() {
    Tone t = new ToneImp(2, NoteEnum.g, 5, 142, 1);
  }

  /*
  tests equals and compare on tone
   */
  Tone t0 = new ToneImp(1, "A", 1, 100, 0);
  Tone t1 = new ToneImp(1, "A", 1, 100, 0);
  Tone t2 = new ToneImp(1, "C", 1, 100, 0);
  Tone t3 = new ToneImp(1, "A", 2, 100, 0);
  Tone t4 = new ToneImp(1, "A", 1, 101, 0);
  Tone t5 = new ToneImp(1, "A", 1, 100, 1);

  @Test
  public void testEqualsAndCompare0() {
    assertFalse(t0.equals(t2));
  }

  @Test
  public void testEqualsAndCompare1() {
    assertTrue(t1.equals(t0));
  }

  @Test
  public void testEqualsAndCompare2() {
    assertTrue(t0.equals(t1));
  }

  @Test
  public void testEqualsAndCompare3() {
    assertFalse(t0.equals(t3));
  }

  @Test
  public void testEqualsAndCompare4() {
    assertFalse(t0.equals(t4));
  }

  @Test
  public void testEqualsAndCompare5() {
    assertFalse(t0.equals(t5));
  }

  @Test
  public void testEqualsAndCompare6() {
    assertTrue(t1.equals(t1));
  }

  @Test
  public void testEqualsAndCompare7() {
    assertFalse(t1.equals(5));
  }
  /*
  tests cloning tones
   */
  @Test
  public void testCloneTone0() {
    Tone t = new ToneImp(1, "A", 1, 100, 0);
    Tone clone = new ToneImp(t);
    assertEquals(true, t.equals(t));
  }

  @Test
  public void testCloneTone1() {
    Tone t = new ToneImp(5, NoteEnum.b, 3, 55, 1);
    Tone clone = new ToneImp(t);
    assertEquals(true, t.equals(t));
  }

  /*
  tests getValue on tones
   */
  Tone t6 = new ToneImp(10, "C", 5, 100, 1);
  Tone t7 = new ToneImp(1, "C", 0, 10, 0);
  Tone t8 = new ToneImp(2, NoteEnum.gS, 2, 90, 0);
  Tone t9 = new ToneImp(3, NoteEnum.c, 10, 99, 0);
  Tone t10 = new ToneImp(5, "D#", 10, 25, 0);

  @Test
  public void testGetValue0() {
    assertEquals(t6.getValue(), 60);
  }

  @Test
  public void testGetValue1() {
    assertEquals(t7.getValue(), 0);
  }

  @Test
  public void testGetValue2() {
    assertEquals(t8.getValue(), 32);
  }

  @Test
  public void testGetValue3() {
    assertEquals(t9.getValue(), 120);
  }

  @Test
  public void testGetValue4() {
    assertEquals(t10.getValue(), 123);
  }

  /*
  tests getLength on scores
   */
  @Test
  public void testGetLength() {
    assertEquals(5, this.testSong().getLength());
  }

  /*
  tests getRange on scores
   */
  @Test
  public void testGetRange() {
    assertEquals(2, this.testSong().getRange());
    assertEquals(4, this.testSong().addNote(0, 1, "A", 1, 100, 0).getRange());
    assertEquals(3, this.testSong().addNote(0, 2, "A", 5, 100, 0).getRange());
    assertEquals(this.testSong().getRange(), this.testSong().
        addNote(0, 1, "A", 1, 100, 0).
        removeNoteAt(0, "A", 1).getRange());
  }

  /*
  tests highest on scores
   */
  @Test
  public void testExtreme() {
    assertEquals(true, this.testSong().highest().equals(this.testSong().highest()));
    Tone t = this.testSong().highest();
    assertEquals(false, this.testSong().highest().equals(new ToneImp(2, "C#", 4, 100, 0)));
  }

  /*
  tests addNote on scores
   */
  @Test
  public void testAddNote1() {
    MusicRepresentation n = new Score();
    assertEquals(0, n.countNotes());
    MusicRepresentation m = this.testSong();
    assertEquals(4, m.countNotes());
    m.addNote(0, 2, "B", 4, 100, 0);
    m.addNote(1, 2, "B", 4, 100, 0); //Overlapping notes
    assertEquals(6, m.countNotes());
  }

  /*
  tone tests, specifically nextTone
   */
  @Test
  public void testNote() {
    Tone t = new ToneImp(1, NoteEnum.c, 1, 100, 0);
    assertEquals(12, t.getValue());
    assertEquals(t.getValue() + 1, t.nextTone().getValue());
    Tone t2 = new ToneImp(1, NoteEnum.b, 1, 100, 0);
    assertEquals(1, t2.getOctave());
    assertEquals(2, t2.nextTone().getOctave());
    assertEquals(new ToneImp(1, NoteEnum.c, 2, 100, 0), t2.nextTone());
  }

  /*
  tests removeNoteAt on scores
   */
  @Test
  public void testRemoveNoteAt() {
    MusicRepresentation m = this.testSong();
    assertEquals(4, m.countNotes());
    assertEquals(4, m.addNote(0, 2, "B", 4, 100, 0).removeNoteAt(0, "B", 4).countNotes());
    assertEquals(5, m.addNote(0, 2, "B", 4, 100, 0)
        .addNote(1, 3, "B", 4, 100, 0)
        .removeNoteAt(0, "B", 4).countNotes()); //dont sustaining notes
  }

  /*
  tests removeNoteAt exceptions
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveAtExcp() {
    MusicRepresentation m = this.testSong();
    assertEquals(3, m.removeNoteAt(0, "B", 4).countNotes());
  }

  /*
  tests lowest and highest on scores
   */
  @Test
  public void testExtremes() {
    assertEquals(new ToneImp(3, "E", 3, 100, 0), this.testSong().lowest());
    assertEquals(new ToneImp(2, "D#", 4, 100, 0), this.testSong().highest());
  }

  /*
  tests getNotesAtBeat on scores
   */
  @Test
  public void testGetNotesAtBeat() {
    assertEquals(2, this.testSong().getNotesAtBeat(0).size());
  }

  /*
  tests toString on Note
   */
  @Test
  public void testToStringNote0() {
    assertEquals(NoteEnum.a.toString(), "A");
  }

  @Test
  public void testToStringNote1() {
    assertEquals(NoteEnum.aS.toString(), "A#");
  }

  @Test
  public void testToStringNote2() {
    assertEquals(NoteEnum.gS.toString(), "G#");
  }

  @Test
  public void testToStringNote3() {
    assertEquals(NoteEnum.b.toString(), "B");
  }

  /*
  test toString on Tone
   */
  @Test
  public void testToStringTone0() {
    assertEquals(t0.toString(), "A1");
  }

  @Test
  public void testToStringTone1() {
    assertEquals(t2.toString(), "C1");
  }

  @Test
  public void testToStringTone2() {
    assertEquals(t8.toString(), "G#2");
  }

  @Test
  public void testToStringTone3() {
    assertEquals(t10.toString(), "D#10");
  }

  /*
  tests getTempo and setTempo
   */
  @Test
  public void testGetSetTempo() {
    MusicRepresentation m = testSong();
    assertEquals(m.getTempo(), 0);
    m.setTempo(20000);
    assertEquals(m.getTempo(), 20000);
    m.setTempo(20);
    assertEquals(m.getTempo(), 20);
  }
}