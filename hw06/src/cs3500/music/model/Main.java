package cs3500.music.model;

import java.io.File;

import cs3500.music.view.MusicRepresentationTextViewer;
import cs3500.music.view.MusicRepresentationView;

public class Main {

    public static void main(String[] args) {
        File f = new File("test_sound");

        MusicRepresentationView mv = new MusicRepresentationTextViewer(f);
        mv.display();
    }
}
