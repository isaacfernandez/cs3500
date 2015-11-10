package cs3500.music.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * Created by isaacf on 11/2/15.
 */
public class MusicRepresentationTextViewer implements MusicRepresentationView {
    private final MusicRepresentation music;

    public static void main(String[] args) {
        File f = new File("test_sound");
        MusicRepresentationTextViewer mp = new MusicRepresentationTextViewer(f);
    }

    MusicRepresentationTextViewer(File f) {
        //Probably unnecessary once we use Lerner's builder method
        this.music = new Score();
        try {
            String s;
            if (f.exists()) {
                FileReader fileReader =
                        new FileReader(f);
                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);
                int oct;
                int duration;
                int beat;
                String pitch;
                while((s = bufferedReader.readLine()) != null) {
                    //0 1 A 3 .... beat duration Pitch octave
                    String note[] = s.split(" ");
                    beat = Integer.parseInt(note[0]);
                    duration = Integer.parseInt(note[1]);
                    pitch = note[2];
                    oct = Integer.parseInt(note[3]);
                    this.music.addNote(beat, duration, pitch, oct);
                }
            } else {
                System.out.println("File doesn't exist");
                return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    /**
     * Creates a representation of the data
     * idk what the view is suppose to take?
     */
    @Override
    public void display() {
        //Figure out how wide we'll need to display
        Tone lowest = music.lowest();
        Tone highest = music.highest();
        int hi = highest.getValue();
        int lo = lowest.getValue();
        int length = music.getLength();
        int[] sustainedNotes = new int[1 + hi - lo];

        //print a header

        System.out.print("  "); //Spaces for the line numbers ( 03:, 13:, etc)
        Tone header = lowest;
        do {
            //Should split into a 'nextTone' method
            System.out.printf("%-4S", header);
            header = header.nextTone();
        } while (highest.compare(header) >= 0);
        System.out.println();

        for (int i = 0; i < sustainedNotes.length; i++) {
            sustainedNotes[i] = 0;
        }

        for (int i = 0; i < length; i++) {
            System.out.print( String.format("%-2d", i));
            String s = this.getFormattedString(music.getNotesAtBeat(i), sustainedNotes, lo, hi);
            System.out.print(s);
            System.out.println();
        }
    }

    /**
     * Given a list of notes and sustaining notes, rearranges them into a staff
     * SIDEEFFECTS: Mutates sustainedNotes s.t.  any new notes to be sustained are incremented,
     * and notes previous being sustained decreased in value
     */
    private String getFormattedString(List<Tone> notes,
                                      int[] sustained,
                                      int lowEnd, int hiEnd) {
        String[] marks = new String[ 1 + hiEnd - lowEnd];

        for (Tone t: notes) {
            int index = (t.getValue()) - lowEnd;
            marks[index] = "X   "; //Note.NoteToString(t.note);
            if (t.getDuration() > 1) {
                sustained[index] = t.getDuration() - 1; //Account for the current playing note, 1 tick
            }
        }
        //INVARIANT: A note held down never overlaps another note at the same tone
        for (int i = 0; i < sustained.length; i++) {
            if (sustained[i] > 0) {
                if (! (marks[i] != null && marks[i].equals("X   "))) {
                    marks[i] = "S   ";
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
}
