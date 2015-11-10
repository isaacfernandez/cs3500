package cs3500.music.model;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File f = new File("test_sound");

        MusicRepresentationView  mv = new MusicRepresentationTextViewer(f);
        mv.display();
    }
}
