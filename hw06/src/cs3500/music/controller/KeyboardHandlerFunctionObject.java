package cs3500.music.controller;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.view.GuiView;

/**
 * Created by isaacf on 11/18/15.
 */
public abstract class KeyboardHandlerFunctionObject {
  protected final MusicController cb;

  protected KeyboardHandlerFunctionObject(MusicController cb) {
    this.cb = cb;
  }
}


class Scroll extends KeyboardHandlerFunctionObject implements Runnable {

  Scroll(MusicController cb) {
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

  }
}

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
   * @see Thread#run()
   */
  @Override
  public void run() {
    super.cb.setBeat(0);
  }
}

class JumpToEnd extends KeyboardHandlerFunctionObject implements Runnable {

  protected JumpToEnd(MusicController cb) {
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
    super.cb.setBeat(super.cb.getModel().getLength());
  }
}