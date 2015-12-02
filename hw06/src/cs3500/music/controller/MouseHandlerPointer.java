package cs3500.music.controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

/**
 * A pointer to a mouse input handler for a music piece.
 */
public class MouseHandlerPointer implements MouseInputListener {
  /**
   * The MouseInputListener this points to.
   */
  private MouseInputListener handler;

  /**
   * Constructs a new MouseHandlerPointer.
   */
  public MouseHandlerPointer(MusicController mc) {
    this.handler = new doNothingMouseMode(mc);
  }

  /**
   * Returns the MouseInputListener this points to
   * @return handler
   */
  public MouseInputListener getHandler() {
    return handler;
  }

  /**
   * Sets handler to the given {@code handler}
   * @param handler
   */
  public void setHandler(MouseInputListener handler) {
    this.handler = handler;
  }

  /**
   * Invoked when the mouse button has been clicked (pressed and released) on a component.
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    System.out.println("Pointer registered click");
    this.handler.mouseClicked(e);
  }

  /**
   * Invoked when a mouse button has been pressed on a component.
   */
  @Override
  public void mousePressed(MouseEvent e) {
    System.out.println("Pointer registered pressed");
    this.handler.mousePressed(e);
  }

  /**
   * Invoked when a mouse button has been released on a component.
   */
  @Override
  public void mouseReleased(MouseEvent e) {
    System.out.println("Pointer registered Mouse released");
    this.handler.mouseReleased(e);
  }

  /**
   * Invoked when the mouse enters a component.
   */
  @Override
  public void mouseEntered(MouseEvent e) {
    this.handler.mouseEntered(e);
  }

  /**
   * Invoked when the mouse exits a component.
   */
  @Override
  public void mouseExited(MouseEvent e) {
    this.handler.mouseExited(e);
  }

  /**
   * Invoked when a mouse button is pressed on a component and then dragged.
   * <code>MOUSE_DRAGGED</code> events will continue to be delivered to the component where the drag
   * originated until the mouse button is released (regardless of whether the mouse position is
   * within the bounds of the component).
   */
  @Override
  public void mouseDragged(MouseEvent e) {
    this.handler.mouseDragged(e);
  }

  /**
   * Invoked when the mouse cursor has been moved onto a component but no buttons have been pushed.
   */
  @Override
  public void mouseMoved(MouseEvent e) {
    this.handler.mouseMoved(e);
  }
}
