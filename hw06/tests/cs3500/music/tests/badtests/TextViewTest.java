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
public class TextViewTest {
  @Test
  public void regressionTestForText() {
    String filename = "mary.txt";
    String view = "testconsole";
    MusicController mc = null;
    try {
      FileReader fr = new FileReader(new File(filename));
      CompositionBuilder<MusicRepresentation> mbuilder = new MusicRepresentationBuilder();
      mc = new MusicController(MusicReader.parseFile(fr, mbuilder), view);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    String output = mc.start();
    assertEquals(textMaryOutput, output);
  }

  //The expected output as per the website, with octaves fixed (off by 1 on the website)
  String textMaryOutput = "E4  F4  F#4 G4  G#4 A4  A#4 B4  C5  C#5 D5  D#5 E5  F5  F#5 G5  \n" +
      "            X                                   X               \n" +
      "            |                                                   \n" +
      "            |                           X                       \n" +
      "            |                                                   \n" +
      "            |                   X                               \n" +
      "            |                                                   \n" +
      "                                        X                       \n" +
      "                                                                \n" +
      "            X                                   X               \n" +
      "            |                                                   \n" +
      "            |                                   X               \n" +
      "            |                                                   \n" +
      "            |                                   X               \n" +
      "            |                                   |               \n" +
      "                                                                \n" +
      "                                                                \n" +
      "            X                           X                       \n" +
      "            |                                                   \n" +
      "            |                           X                       \n" +
      "            |                                                   \n" +
      "            |                           X                       \n" +
      "            |                           |                       \n" +
      "            |                           |                       \n" +
      "                                                                \n" +
      "            X                                   X               \n" +
      "                                                                \n" +
      "                                                            X   \n" +
      "                                                                \n" +
      "                                                            X   \n" +
      "                                                            |   \n" +
      "                                                            |   \n" +
      "                                                                \n" +
      "            X                                   X               \n" +
      "            |                                                   \n" +
      "            |                           X                       \n" +
      "            |                                                   \n" +
      "            |                   X                               \n" +
      "            |                                                   \n" +
      "            |                           X                       \n" +
      "                                                                \n" +
      "            X                                   X               \n" +
      "            |                                                   \n" +
      "            |                                   X               \n" +
      "            |                                                   \n" +
      "            |                                   X               \n" +
      "            |                                                   \n" +
      "            |                                   X               \n" +
      "                                                                \n" +
      "            X                           X                       \n" +
      "            |                                                   \n" +
      "            |                           X                       \n" +
      "            |                                                   \n" +
      "            |                                   X               \n" +
      "            |                                                   \n" +
      "            |                           X                       \n" +
      "                                                                \n" +
      "X                               X                               \n" +
      "|                               |                               \n" +
      "|                               |                               \n" +
      "|                               |                               \n" +
      "|                               |                               \n" +
      "|                               |                               \n" +
      "|                               |                               \n" +
      "                                                                \n";
}
