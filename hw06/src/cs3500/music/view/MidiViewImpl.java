package cs3500.music.view;

import java.util.Collection;
import java.util.Map;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;

import cs3500.music.model.MusicModel;
import cs3500.music.model.Note;

public class MidiViewImpl implements ViewInterface {
    private final Synthesizer synth;
    private final Receiver receiver;
    private StringBuilder output;

    private Synthesizer testSynth = null;
    private Receiver testReceiver = null;

    private MidiViewImpl(boolean debug, StringBuilder o) {
        if (debug == true) {
            try {
                testSynth = new MockSynthesizer(o);
                testReceiver = testSynth.getReceiver();
                testSynth.open();
            } catch (MidiUnavailableException e) {
                e.printStackTrace();
            }
            this.synth = testSynth;
            this.receiver = testReceiver;
            this.output = o;
        } else {
            try {
                testSynth = MidiSystem.getSynthesizer();
                testReceiver = testSynth.getReceiver();
                testSynth.open();
            } catch (MidiUnavailableException e) {
                e.printStackTrace();
            }
            this.synth = testSynth;
            this.receiver = testReceiver;
        }
    }

    public static final class MidiViewImplBuilder {
        private boolean debug = false;
        StringBuilder output;

        public MidiViewImpl build() {
            return new MidiViewImpl(debug, output);
        }

        public MidiViewImplBuilder setDebug() {
            this.debug = true;
            return this;
        }

        public MidiViewImplBuilder setNoDebug() {
            this.debug = false;
            return this;
        }

        public MidiViewImplBuilder setStringBuilder(StringBuilder o){
            this.output = o;
            return this;
        }

    }

    /**
     * Helper function to play a given note
     * @param n The note to play
     * @param tempo The tempo in microseconds to play it at
     * @throws InvalidMidiDataException If MIDI throws an invalid data exception
     */
    private void playNote(Note n, int tempo) throws InvalidMidiDataException {
        MidiMessage start = new ShortMessage(ShortMessage.NOTE_ON, n.getInstrument() - 1,
                n.getPitch(), n.getVolume());
        MidiMessage stop = new ShortMessage(ShortMessage.NOTE_OFF, n.getInstrument() - 1,
                n.getPitch(), n.getVolume());
        this.receiver.send(start, (n.getStartBeat() * tempo));
        this.receiver.send(stop, this.synth.getMicrosecondPosition() + (n.getDuration() * tempo));
    }

    /**
     * Plays a piece the entire way through
     * @param m The MusicModel to play
     * @throws InvalidMidiDataException If MIDI throws an invalid data exception
     */
    @Override
    public void playPiece(MusicModel m) throws InvalidMidiDataException {
        Map<Integer, Collection<Note>> allNotes = m.sortedNotes();
        for (Integer i : allNotes.keySet()){
            playBeat(m, i);
        }
        this.receiver.close();
    }

    /**
     * Plays all of the notes starting on a given beat
     * @param m The MusicModel to play
     * @param beat The beat which all of the notes to be played starts
     * @throws InvalidMidiDataException If MIDI throws an invalid data exception
     */
    @Override
    public void playBeat(MusicModel m, int beat) throws InvalidMidiDataException {
        Collection<Note> noteList = m.notesAtBeat(beat);
        for (Note n : noteList){
            playNote(n, m.getTempo());
        }
    }

    /**
     * Plays an entire piece starting from a given note
     * @param m The MusicModel to play
     * @param beat The beat to start on
     * @throws InvalidMidiDataException If MIDI throws an invalid data exception
     */
    @Override
    public void playFromBeat(MusicModel m, int beat) throws InvalidMidiDataException {
        Map<Integer, Collection<Note>> allNotes = m.sortedNotes();
        for (Integer i : allNotes.keySet()){
            if (i > beat){
                playBeat(m, i);
            }
        }
        this.receiver.close();
    }
}
