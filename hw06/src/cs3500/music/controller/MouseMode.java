package cs3500.music.controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import cs3500.music.controller.MusicController;
import cs3500.music.model.Tone;
import cs3500.music.view.GuiView;

class MouseMode implements MouseInputListener {
  protected MusicController mc;

  MouseMode(MusicController mc) {
    this.mc = mc;
  }

  /**
   * Invoked when the mouse button has been clicked (pressed and released) on a component.
   */
  @Override
  public void mouseClicked(MouseEvent e) {

  }

  /**
   * Invoked when a mouse button has been pressed on a component.
   */
  @Override
  public void mousePressed(MouseEvent e) {
    System.out.println("Pressed!");
  }

  /**
   * Invoked when a mouse button has been released on a component.
   */
  @Override
  public void mouseReleased(MouseEvent e) {

  }

  /**
   * Invoked when the mouse enters a component.
   */
  @Override
  public void mouseEntered(MouseEvent e) {

  }

  /**
   * Invoked when the mouse exits a component.
   */
  @Override
  public void mouseExited(MouseEvent e) {

  }

  /**
   * Invoked when a mouse button is pressed on a component and then dragged.
   * <code>MOUSE_DRAGGED</code> events will continue to be delivered to the component where the drag
   * originated until the mouse button is released (regardless of whether the mouse position is
   * within the bounds of the component). <p> Due to platform-dependent Drag&amp;Drop
   * implementations, <code>MOUSE_DRAGGED</code> events may not be delivered during a native
   * Drag&amp;Drop operation.
   */
  @Override
  public void mouseDragged(MouseEvent e) {

  }

  /**
   * Invoked when the mouse cursor has been moved onto a component but no buttons have been pushed.
   */
  @Override
  public void mouseMoved(MouseEvent e) {

  }
}

class deleteMouseMode extends MouseMode {

  /**
   * Invoked when the mouse button has been clicked (pressed and released) on a component.
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    GuiView view = (GuiView) super.mc.view;
    /**
    //We need these methods
    Tone t = view.toneAt(e.getX(), e.getY());
    int beat = view.beatAt(e.getY());
    super.mc.getModel().removeNoteAt(t.getX());
     **/
    System.out.println("Did this fire?");

    /*
    Tone t = view.toneAt(e.getX(), e.getY());
    int beat = view.beatAt(e.getX(), e.getY());
    System.out.println(beat); //testing testing 1 2 3
    if (t != null) {
      super.mc.getModel().removeNoteAt(beat, t.getNote().toString(), t.getOctave());
    }
    */
    super.mc.mouseMode(new doNothingMouseMode());
  }


  deleteMouseMode(MusicController mc) {
    super(mc);
  }
}

class doNothingMouseMode extends MouseMode {

  doNothingMouseMode(MusicController mc) {
    super(mc);
  }
  doNothingMouseMode() {
    super(null);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    GuiView view = (GuiView) super.mc.view;
    Tone t = view.toneAt(e.getX(), e.getY());
    int beat = view.beatAt(e.getX(), e.getY());
    System.out.println(beat); //testing testing 1 2 3
  }
}
