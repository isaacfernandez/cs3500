package cs3500.music.controller;

import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import cs3500.music.controller.KeyboardHandlerFunctionObject;
import cs3500.music.controller.MusicController;
import cs3500.music.model.MusicRepresentation;
import cs3500.music.model.Score;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by isaacf on 11/25/15.
 */
public class KeyboardTests {

  @Test
  public void testPauseObject() {
    MusicController mc = new MockMusicController(testSong(), "visualmidi");
    Runnable pause = new PausePlayback(mc);
    boolean start = mc.getPaused();
    pause.run();
    assertEquals(!start, mc.getPaused());
    pause.run();
    assertEquals(start, mc.getPaused());
  }

  @Test
  public void testScrollObjects() {
    MockMusicController mc = new MockMusicController(testSong(), "visualmidi");
    Runnable scrollForward = new ScrollForward(mc);
    Runnable scrollBackward = new ScrollBackward(mc);
    int start = mc.getBeat();
    scrollForward.run();
    assertEquals(start + KeyboardHandlerFunctionObject.SKIP_FF, mc.getBeat());
    scrollForward.run();
    scrollForward.run();
    scrollForward.run();
    assert(mc.getBeat() <= mc.model.getLength());
    scrollBackward.run();
    scrollBackward.run();
    scrollBackward.run();
    assert(start ==  0);
  }

  @Test
  public void testJumps() {
    MockMusicController mc = new MockMusicController(testSong(), "visualmidi");
    Runnable jf = new JumpToEnd(mc);
    Runnable jb = new JumpToBeginning(mc);
    int start = mc.getBeat();
    jb.run();
    assertEquals(0, mc.getBeat());
    jf.run();
    assertEquals(mc.model.getLength(), mc.getBeat());
  }

  @Test
  public void testWiring() {
    final boolean[] firedCB = {false, false, false, false};
    KeyboardHandler kb = new KeyboardHandler();
    kb.addPressedHandler(KeyEvent.VK_A, new Runnable() {
      @Override
      public void run() {
        firedCB[0] = true;
      }
    });
    kb.addPressedHandler(KeyEvent.VK_B, new Runnable() {
      @Override
      public void run() {
        firedCB[1] = true;
      }
    });
    kb.addPressedHandler(KeyEvent.VK_C, new Runnable() {
      @Override
      public void run() {
        firedCB[2] = true;
      }
    });
    kb.addPressedHandler(KeyEvent.VK_D, new Runnable() {
      @Override
      public void run() {
        firedCB[3] = true;
      }
    });
    //Fire A, B, C, and not D
    kb.keyPressed(new KeyEvent(new Component(){}, 0, 0, 0, KeyEvent.VK_A, 'a'));
    kb.keyPressed(new KeyEvent(new Component(){}, 0, 0, 0, KeyEvent.VK_B, 'b'));
    kb.keyPressed(new KeyEvent(new Component(){}, 0, 0, 0, KeyEvent.VK_C, 'c'));
    assert(firedCB[0] && firedCB[1] && firedCB[2] && !firedCB[3] );
  }

  public MusicRepresentation testSong() {
    MusicRepresentation mus2 = new Score();
    mus2.addNote(0, 1, "C#", 4, 100, 0);
    mus2.addNote(1, 2, "D#", 4, 100, 0);
    mus2.addNote(2, 3, "E", 3, 100, 0);
    mus2.addNote(0, 1, "C", 4, 100, 0);
    return mus2;
  }

}

class MockMusicController extends MusicController {

  /**
   * Constructs a new MusicController with model {@code model}, mode {@code mode}, keyboard
   * handlers,
   * and a new view of the mode specified.
   *
   * @param model the piece being represented
   * @param mode  the type of view being created
   */

  public MusicRepresentation model;

  public MockMusicController(MusicRepresentation model, String mode) {
    super(model, mode);
    this.model = model;
  }

  public boolean getPause() {
    return super.getPaused();
  }

  public int getBeat() {
    return super.beat;
  }
}