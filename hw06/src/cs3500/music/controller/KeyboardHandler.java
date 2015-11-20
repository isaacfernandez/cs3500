package cs3500.music.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by isaacf on 11/18/15.
 */
public class KeyboardHandler implements KeyListener {

  private Map<Integer, Runnable> keyTypedEvents;
  private Map<Integer, Runnable> keyPressedEvents;
  private Map<Integer, Runnable> keyReleasedEvents;

  public KeyboardHandler() {
    this.keyTypedEvents = new HashMap<Integer, Runnable>();
    this.keyPressedEvents = new HashMap<Integer, Runnable>();
    this.keyReleasedEvents = new HashMap<Integer, Runnable>();
  }

  /**
   * Invoked when a key has been typed. See the class description for {@link KeyEvent} for a
   * definition of a key typed event.
   */
  @Override
  public void keyTyped(KeyEvent e) {
    this.lookupEvent(keyTypedEvents, e);
  }

  /**
   * Invoked when a key has been pressed. See the class description for {@link KeyEvent} for a
   * definition of a key pressed event.
   */
  @Override
  public void keyPressed(KeyEvent e) {
    this.lookupEvent(keyPressedEvents, e);
  }

  /**
   * Invoked when a key has been released. See the class description for {@link KeyEvent} for a
   * definition of a key released event.
   */
  @Override
  public void keyReleased(KeyEvent e) {
    this.lookupEvent(keyReleasedEvents, e);
  }

  /**
   * Adds a handler to handle KeyTyped Events
   * @param r Runnable, the handler
   *
   */
  public void addTypedHandler(int keycode, Runnable r) {
    this.keyTypedEvents.put(keycode, r);
  }

  /**
   * Adds a handler to handle KeyPressed Events
   * @param keycode see KeyEvents
   * @param r Runnable, the handler
   */
  public void addPressedHandler(int keycode, Runnable r) {
    this.keyPressedEvents.put(keycode, r);
  }

  /**
   * Adds a handler to handle KeyReleased Events
   * @param r Runnable, the handler
   */
  public void addReleasedHandler(int keycode, Runnable r) {
    this.keyReleasedEvents.put(keycode, r);
  }

  private void lookupEvent(Map<Integer, Runnable> runnables, KeyEvent e)  {
    Runnable cb = runnables.get(e.getKeyCode());
    if (cb == null) {
      return;
    } else {
      cb.run();
    }
  }
}
