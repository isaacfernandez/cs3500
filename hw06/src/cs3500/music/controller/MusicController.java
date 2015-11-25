package cs3500.music.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;

import javax.swing.*;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.view.MusicRepresentationView;
import cs3500.music.view.MusicRepresentationViewFactory;
import cs3500.music.view.SafeMusicRepresentation;
import cs3500.music.view.SafeMusicRepresentationDecorator;

/**
 * Representation of a controller for a MusicRepresentation.
 */
public class MusicController {
  public final MusicRepresentationView view;
  private final MusicRepresentation model;
  private final KeyboardHandler handler;
  private final MouseHandlerPointer mhandler;
  private int beat = 0;
  private Timer timer;
  String mode;

  public MusicController(MusicRepresentation model, String mode) {
    this.mode = mode;
    this.model = Objects.requireNonNull(model);

    //make handler

    this.handler = new KeyboardHandler();
    //TODO
    //Add the handlers here
    this.handler.addPressedHandler(KeyEvent.VK_END, new JumpToEnd(this));
    this.handler.addPressedHandler(KeyEvent.VK_K, new JumpToEnd(this));
    this.handler.addPressedHandler(KeyEvent.VK_J, new JumpToBeginning(this));
    this.handler.addPressedHandler(KeyEvent.VK_HOME, new JumpToBeginning(this));
    this.handler.addPressedHandler(KeyEvent.VK_LEFT, new ScrollBackward(this));
    this.handler.addPressedHandler(KeyEvent.VK_RIGHT, new ScrollForward(this));
    //this.handler.addPressedHandler(new Runnable());
    this.view = MusicRepresentationViewFactory.makeView(mode, this.handler);
    this.mhandler = new MouseHandlerPointer();
  }

  //Returns a string for debugging purposes
  public String start() {
    final SafeMusicRepresentation sm = new SafeMusicRepresentationDecorator(this.model);
    timer = new javax.swing.Timer(model.getTempo() / 1000, new ActionListener( ) {
      public void actionPerformed(ActionEvent e) {
        view.displayAtBeat(sm, tickBeat());
      }
    });
    timer.start();
    if (this.mode.contains("test")) {
      return ((StringBuilder) this.view.getLog()).toString();
    } else {
      return "";
    }
  }

  public void mouseMode(MouseMode mr) {
    this.mhandler.setHandler(mr);
  }

  public int tickBeat() {
    return this.beat++;
  }
  public void setBeat(int i) {
    this.beat = i;
  }

  public MusicRepresentation getModel() {
    return this.model;
  }

  public void scroll(int beats) {
    this.setBeat(this.beat + beats);
    if (this.beat < 0) {
      this.beat = 0;
    }
    else if (this.beat > this.model.getLength()) {
      this.beat = this.model.getLength();
    }
  }


}
