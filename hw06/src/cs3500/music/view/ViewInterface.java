package cs3500.music.view;

import javax.sound.midi.InvalidMidiDataException;

import cs3500.music.model.MusicModel;

public interface ViewInterface {
    void playPiece(MusicModel m) throws InvalidMidiDataException;

    void playBeat(MusicModel m, int beat) throws InvalidMidiDataException;

    void playFromBeat(MusicModel m, int beat) throws InvalidMidiDataException;
}
