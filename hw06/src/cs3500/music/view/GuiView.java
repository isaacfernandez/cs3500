package cs3500.music.view;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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

}
