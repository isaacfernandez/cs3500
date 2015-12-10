package cs3500.music.tests.badtests;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.util.CompositionBuilder;
import cs3500.music.util.MusicReader;
import cs3500.music.util.MusicRepresentationBuilder;
import cs3500.music.controller.MusicController;

import static org.junit.Assert.assertEquals;

/**
 * Created by isaacf on 11/12/15.
 */
public class MidiViewTest {


  @Test
  public void regressionTestForMidi() {
    String filename = "mary.txt";
    String view = "testmidi";
    MusicController mc = null;
    try {
      FileReader fr = new FileReader(new File(filename));
      CompositionBuilder<MusicRepresentation> mbuilder = new MusicRepresentationBuilder();
      mc = new MusicController(MusicReader.parseFile(fr, mbuilder), view);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    String output = mc.start();
    assertEquals(midiMaryOutPut, output);
  }

  String midiMaryOutPut ="note:64 vol:72 Time: -1\n" +
      "note:64 vol:72 Time: 20\n" +
      "note:55 vol:70 Time: -1\n" +
      "note:55 vol:70 Time: 120\n" +
      "note:62 vol:72 Time: -1\n" +
      "note:62 vol:72 Time: 60\n" +
      "note:60 vol:71 Time: -1\n" +
      "note:60 vol:71 Time: 100\n" +
      "note:62 vol:79 Time: -1\n" +
      "note:62 vol:79 Time: 140\n" +
      "note:55 vol:79 Time: -1\n" +
      "note:55 vol:79 Time: 280\n" +
      "note:64 vol:85 Time: -1\n" +
      "note:64 vol:85 Time: 180\n" +
      "note:64 vol:78 Time: -1\n" +
      "note:64 vol:78 Time: 220\n" +
      "note:64 vol:74 Time: -1\n" +
      "note:64 vol:74 Time: 280\n" +
      "note:55 vol:77 Time: -1\n" +
      "note:55 vol:77 Time: 460\n" +
      "note:62 vol:75 Time: -1\n" +
      "note:62 vol:75 Time: 340\n" +
      "note:62 vol:77 Time: -1\n" +
      "note:62 vol:77 Time: 380\n" +
      "note:62 vol:75 Time: -1\n" +
      "note:62 vol:75 Time: 460\n" +
      "note:55 vol:79 Time: -1\n" +
      "note:55 vol:79 Time: 500\n" +
      "note:64 vol:82 Time: -1\n" +
      "note:64 vol:82 Time: 500\n" +
      "note:67 vol:84 Time: -1\n" +
      "note:67 vol:84 Time: 540\n" +
      "note:67 vol:75 Time: -1\n" +
      "note:67 vol:75 Time: 620\n" +
      "note:55 vol:78 Time: -1\n" +
      "note:55 vol:78 Time: 780\n" +
      "note:64 vol:73 Time: -1\n" +
      "note:64 vol:73 Time: 660\n" +
      "note:62 vol:69 Time: -1\n" +
      "note:62 vol:69 Time: 700\n" +
      "note:60 vol:71 Time: -1\n" +
      "note:60 vol:71 Time: 740\n" +
      "note:62 vol:80 Time: -1\n" +
      "note:62 vol:80 Time: 780\n" +
      "note:55 vol:79 Time: -1\n" +
      "note:55 vol:79 Time: 940\n" +
      "note:64 vol:84 Time: -1\n" +
      "note:64 vol:84 Time: 820\n" +
      "note:64 vol:76 Time: -1\n" +
      "note:64 vol:76 Time: 860\n" +
      "note:64 vol:74 Time: -1\n" +
      "note:64 vol:74 Time: 900\n" +
      "note:64 vol:77 Time: -1\n" +
      "note:64 vol:77 Time: 940\n" +
      "note:55 vol:78 Time: -1\n" +
      "note:55 vol:78 Time: 1100\n" +
      "note:62 vol:75 Time: -1\n" +
      "note:62 vol:75 Time: 980\n" +
      "note:62 vol:74 Time: -1\n" +
      "note:62 vol:74 Time: 1020\n" +
      "note:64 vol:81 Time: -1\n" +
      "note:64 vol:81 Time: 1060\n" +
      "note:62 vol:70 Time: -1\n" +
      "note:62 vol:70 Time: 1100\n" +
      "note:52 vol:72 Time: -1\n" +
      "note:52 vol:72 Time: 1260\n" +
      "note:60 vol:73 Time: -1\n" +
      "note:60 vol:73 Time: 1260\n";
}
