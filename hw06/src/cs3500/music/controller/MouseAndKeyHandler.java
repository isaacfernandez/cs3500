package cs3500.music.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.MouseInputListener;

/**
 * Created by isaacf on 12/3/15.
 */
public class MouseAndKeyHandler extends MouseHandlerPointer implements KeyListener  {
  /**
   * Adapts our handlers to hw09's partner impl.
   */
  private KeyboardHandler kb;



  public MouseAndKeyHandler(MusicController mc) {
    super(mc);
    kb = new KeyboardHandler();
  }

  //Delegators
  public void addPressed(int keyEvent, Runnable r) {
    kb.addPressedHandler(keyEvent, r);
  }
  public void addHeld(int keyEvent, Runnable r) {
    kb.addTypedHandler(keyEvent, r);
  }
  public void addReleased(int keyEvent, Runnable r) {
    kb.addReleasedHandler(keyEvent, r);
  }

  /**
   * Invoked when a key has been typed. See the class description for {@link KeyEvent} for a
   * definition of a key typed event.
   */
  @Override
  public void keyTyped(KeyEvent e) {

  }

  /**
   * Invoked when a key has been pressed. See the class description for {@link KeyEvent} for a
   * definition of a key pressed event.
   */
  @Override
  public void keyPressed(KeyEvent e) {

  }

  /**
   * Invoked when a key has been released. See the class description for {@link KeyEvent} for a
   * definition of a key released event.
   */
  @Override
  public void keyReleased(KeyEvent e) {

  }
}
