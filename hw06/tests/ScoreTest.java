import org.junit.Test;

import cs3500.hw06.*;

import static org.junit.Assert.*;

/**
 * Created by isaacf on 11/2/15.
 */
public class ScoreTest {

    //addNote(int beat, int duration, String note, int octave);
    public MusicRepresentation testSong() {
        MusicRepresentation mus2 = new Score();
        mus2.addNote(0, 1, "C#", 4);
        mus2.addNote(1, 2, "D#", 4);
        mus2.addNote(2, 3, "E", 3);
        mus2.addNote(0, 1, "C", 4);
        return mus2;
    }

    @Test
    public void testEqualsAndCompare() {
        Tone t = new ToneImp(1, "A", 1);
        Tone te = new ToneImp(1, "A", 1);
        Tone tne = new ToneImp(1, "C", 1);
        Tone tne2 =  new ToneImp(1, "A", 2);
        assertFalse(t.equals(tne));
        assertFalse(t.equals(tne2));
        assertTrue(t.equals(te));
    }

    @Test
    public void testCloneTone() {
        Tone t = new ToneImp(1, "A", 1);
        Tone clone = new ToneImp(t);
        assertEquals(true, t.equals(t));
    }

    @Test
    public void testGetLength() {
        assertEquals(5, this.testSong().getLength());
    }
    @Test
    public void testGetRange() {
        assertEquals(2, this.testSong().getRange());
        assertEquals(4, this.testSong().addNote(0, 1, "A", 1).getRange());
        assertEquals(3, this.testSong().addNote(0, 2, "A", 5).getRange());
        assertEquals(this.testSong().getRange(), this.testSong().
                addNote(0, 1, "A", 1).
                removeNoteAt(0, "A", 1).getRange());
    }

    @Test
    public void testExtreme() {
        assertEquals(true, this.testSong().highest().equals(this.testSong().highest()));
        Tone t = this.testSong().highest();
        assertEquals(false, this.testSong().highest().equals(new ToneImp(2, "C#", 4)));
    }

    @Test
    public void testAddNote1() {
        MusicRepresentation n = new Score();
        assertEquals(0, n.countNotes());
        MusicRepresentation m = this.testSong();
        assertEquals(4, m.countNotes());
        m.addNote(0, 2, "B", 4);
        m.addNote(1, 2, "B", 4); //Overlapping notes
        assertEquals(6, m.countNotes());
    }

    @Test
    public void testNote() {
        Tone t = new ToneImp(1, Note.c, 1);
        assertEquals(13, t.getValue());
        assertEquals(t.getValue() + 1, t.nextTone().getValue());
        Tone t2 = new ToneImp(1, Note.b, 1);
        assertEquals(1, t2.getOctave());
        assertEquals(2, t2.nextTone().getOctave());
        assertEquals(new ToneImp(1, Note.c, 2), t2.nextTone());
    }


    @Test
    public void testRemoveNoteAt() {
        MusicRepresentation m = this.testSong();
        assertEquals(4, m.countNotes());
        assertEquals(4, m.addNote(0, 2, "B", 4).removeNoteAt(0, "B", 4).countNotes());
        assertEquals(5, m.addNote(0, 2, "B", 4)
                .addNote(1, 3, "B", 4)
                .removeNoteAt(0, "B", 4).countNotes()); //dont sustaining notes
    }

    @Test
    public void testExtremes() {
        assertEquals(new ToneImp(3, "E", 3), this.testSong().lowest());
        assertEquals(new ToneImp(2, "D#", 4), this.testSong().highest());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtExcp() {
        MusicRepresentation m = this.testSong();
        assertEquals(3, m.removeNoteAt(0, "B", 4).countNotes());
    }

    @Test
    public void testGetNotesAtBeat() {
        assertEquals(2, this.testSong().getNotesAtBeat(0).size());
    }

}