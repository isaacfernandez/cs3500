package cs3500.music.viewmine;

import java.awt.event.KeyListener;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import cs3500.music.model.Tone;

/**
 * Interface for gui views.
 */
public interface GuiView extends MusicRepresentationView {

  /**
   * KeyListener for GUI view.
   */
  //TODO
  void addKeyListener(KeyListener listener);

  /**
   * MouseListener for GUI view.
   */
  //TODO

  void addMouseListener(MouseListener l);

  void addMouseMotionListener(MouseMotionListener l);

  /**
   * Returns the tone at the location ({@code x}, {@code y}) in the view.
   * Returns null if there is no tone there.
   */
  Tone toneAt(int x, int y);

  /**
   * Returns the beat at the location ({@code x}, {@code y}) in the view.
   * Returns if the x is too far to the left, it returns 0.
   */
  int beatAt(int x, int y);
}
