package cs3500.music.controller;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.view.GuiView;

/**
 * Created by isaacf on 11/18/15.
 * Maybe this should be within the controller for direct access to the view?
 */
public abstract class KeyboardHandlerFunctionObject {
  static final int SKIP_FF = 5;
  static final int SKIP_RW = -10;
  protected final MusicController cb;

  protected KeyboardHandlerFunctionObject(MusicController cb) {
    this.cb = cb;
  }
}

//Move playback to the beginning of the piece
class JumpToBeginning extends KeyboardHandlerFunctionObject implements Runnable {

  protected JumpToBeginning(MusicController cb) {
    super(cb);
  }

  /**
   * When an object implementing interface <code>Runnable</code> is used to create a thread,
   * starting the thread causes the object's <code>run</code> method to be called in that separately
   * executing thread. <p> The general contract of the method <code>run</code> is that it may take
   * any action whatsoever.
   *
   * This Method calls the controller that created it to set its beat to 0, ie, jump to start
   * @see Thread#run()
   */
  @Override
  public void run() {
    super.cb.setBeat(0);
  }
}

//Move playback to the end of the piece
class JumpToEnd extends KeyboardHandlerFunctionObject implements Runnable {

  protected JumpToEnd(MusicController cb) {
    super(cb);
  }

  /**
   * When an object implementing interface <code>Runnable</code> is used to create a thread,
   *
   * @see Thread#run()
   */
  @Override
  public void run() {
    super.cb.setBeat(super.cb.getModel().getLength());
  }
}

//Move playback forward by 12 beats
class ScrollForward extends KeyboardHandlerFunctionObject implements Runnable {

  protected ScrollForward(MusicController cb) {
    super(cb);
  }

  /**
   * When an object implementing interface <code>Runnable</code> is used to create a thread,
   * starting the thread causes the object's <code>run</code> method to be called in that separately
   * executing thread. <p> The general contract of the method <code>run</code> is that it may take
   * any action whatsoever.
   *
   * @see Thread#run()
   */
  @Override
  public void run() {
    super.cb.scroll(SKIP_FF);
  }
}

//Move playback backwards by 10 beats
class ScrollBackward extends KeyboardHandlerFunctionObject implements Runnable {

  protected ScrollBackward(MusicController cb) {
    super(cb);
  }

  /**
   * When an object implementing interface <code>Runnable</code> is used to create a thread,
   * starting the thread causes the object's <code>run</code> method to be called in that separately
   * executing thread. <p> The general contract of the method <code>run</code> is that it may take
   * any action whatsoever.
   *
   * @see Thread#run()
   */
  @Override
  public void run() {
    super.cb.scroll(SKIP_RW);
  }
}

//Move playback backwards by 10 beats
class PausePlayback extends KeyboardHandlerFunctionObject implements Runnable {

  protected PausePlayback(MusicController cb) {
    super(cb);
  }

  @Override
  public void run() {
    super.cb.pauseButton();
  }
}

class deleteMode extends KeyboardHandlerFunctionObject implements Runnable {

  protected deleteMode(MusicController cb) {
    super(cb);
  }

  /**
   * When an object implementing interface <code>Runnable</code> is used to create a thread,
   * starting the thread causes the object's <code>run</code> method to be called in that separately
   * executing thread. <p> The general contract of the method <code>run</code> is that it may take
   * any action whatsoever.
   *
   * @see Thread#run()
   */
  @Override
  public void run() {
    System.out.println("D mode engaged");
    super.cb.mouseMode(new deleteMouseMode(super.cb));
  }
}