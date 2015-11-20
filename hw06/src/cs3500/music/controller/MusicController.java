package cs3500.music.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.*;
import javax.swing.text.ViewFactory;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.view.MusicRepresentationView;
import cs3500.music.view.MusicRepresentationViewFactory;
import cs3500.music.view.SafeMusicRepresentation;
import cs3500.music.view.SafeMusicRepresentationDecorator;

/**
 * Representation of a controller for a MusicRepresentation.
 */
public class MusicController {
  private final MusicRepresentationView view;
  private final MusicRepresentation model;
  private final KeyboardHandler handler;
  private int beat = 0;
  private Timer timer;
  String mode;

  public MusicController(MusicRepresentation model, String mode) {
    this.mode = mode;
    this.model = Objects.requireNonNull(model);
    this.view = MusicRepresentationViewFactory.makeView(mode);
    //make handler
    this.handler = new KeyboardHandler();
    //TODO
    //Add the handlers here
    this.handler.addPressedHandler(new JumpToBeginning(this));
    //this.handler.addPressedHandler(new Runnable());
    
  }

  //Returns a string for debugging purposes
  public String start() {
    final SafeMusicRepresentation sm = new SafeMusicRepresentationDecorator(this.model);
    timer = new javax.swing.Timer(model.getTempo() / 1000, new ActionListener( ) {
      public void actionPerformed(ActionEvent e) {
        view.displayAtBeat(sm, tickBeat());
        System.out.println("Calling the view");
      }
    });
    timer.start();
    if (this.mode.contains("test")) {
      return ((StringBuilder) this.view.getLog()).toString();
    } else {
      return "";
    }
  }

  public int tickBeat() {
    return this.beat++;
  }
  public void setBeat(int i) {
    this.beat = i;
  }

  public SafeMusicRepresentation getModel() {
    return new SafeMusicRepresentationDecorator(this.model);
  }

}
