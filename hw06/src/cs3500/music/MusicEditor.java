package cs3500.music;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.util.CompositionBuilder;
import cs3500.music.util.MusicReader;
import cs3500.music.util.MusicRepresentationBuilder;
import cs3500.music.view.MusicController;

/**
 *
 */

public final class MusicEditor {
  public static void main(String[] args) {
    MusicReader mr = new MusicReader();
    //Who needs validation
    String filename = args[0];
    String view = args[1];
    try {
      FileReader fr = new FileReader(new File(filename));
      CompositionBuilder<MusicRepresentation> mbuilder = new MusicRepresentationBuilder();
      MusicController  mc = new MusicController(MusicReader.parseFile(fr, mbuilder), view);
      //Get it, mc?
      mc.start();
    } catch (IOException e) {
      System.out.println("Error with file");
    }
  }
}
