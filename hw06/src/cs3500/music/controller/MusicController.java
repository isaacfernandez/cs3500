package cs3500.music.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Objects;
import java.util.Map;

import javax.swing.*;

import cs3500.music.model.MusicRepresentation;
import cs3500.music.view.MusicRepresentationView;
import cs3500.music.view.MusicRepresentationViewFactory;
import cs3500.music.view.SafeMusicRepresentation;
import cs3500.music.view.SafeMusicRepresentationDecorator;
import cs3500.music.model.Skip;

/**
 * Representation of a controller for a MusicRepresentation.
 */
  public class MusicController {

  /**
   * The view for this controller.
   * INVARIANT:
   *      -- must be non-null
   */
  protected final MusicRepresentationView view;

  /**
   * The model for this controller.
   * INVARIANT:
   *      -- must be non-null
   */
  private final MusicRepresentation model;

  /**
   * The KeyboardHandler (which is a KeyListener) that this controller is using.
   * INVARIANT:
   *      -- must be non-null
   */
  private final KeyboardHandler handler;


  private final MouseHandlerPointer mhandler;

  /**
   * The beat the music piece is on.
   * INVARIANT:
   *      -- beat >= 0
   */
  protected int beat = 0;

  /**
   * Timer for this controller.
   */
  private Timer timer;

  /**
   * The type of view this controller is using.
   */
  String mode;

  /**
   * True when the song is pause.
   */
  private boolean paused;

  /**
   * This are the one-off repeats, or as we like to call them, repeats
   */
  private final Map<Integer, Skip> repeats;

  /**
   * These are the permanent repeats used for alternate endings
   */
  private final Map<Integer, Skip> altskips = new HashMap<>();

  /**
   * Constructs a new MusicController with model {@code model}, mode {@code mode},
   * keyboard handlers, and a new view of the mode specified.
   *
   * @param model the piece being represented
   * @param mode the type of view being created
   */
  public MusicController(MusicRepresentation model, String mode) {
    this.paused = false;
    this.mode = mode;
    this.model = Objects.requireNonNull(model);
    this.repeats = this.model.getRepeats();

    //make handler
    this.mhandler = new MouseHandlerPointer(this);
    this.handler = new KeyboardHandler();
    //TODO
    //Add the handlers here
    this.handler.addPressedHandler(KeyEvent.VK_END, new JumpToEnd(this));
    this.handler.addPressedHandler(KeyEvent.VK_K, new JumpToEnd(this));
    this.handler.addPressedHandler(KeyEvent.VK_J, new JumpToBeginning(this));
    this.handler.addPressedHandler(KeyEvent.VK_HOME, new JumpToBeginning(this));
    this.handler.addPressedHandler(KeyEvent.VK_LEFT, new ScrollBackward(this));
    this.handler.addPressedHandler(KeyEvent.VK_RIGHT, new ScrollForward(this));
    this.handler.addPressedHandler(KeyEvent.VK_D, new deleteMode(this));
    this.handler.addPressedHandler(KeyEvent.VK_SPACE, new PausePlayback(this));
    //this.handler.addPressedHandler(new Runnable());
    this.view = MusicRepresentationViewFactory.makeView(mode,
        this.handler,
        this.mhandler);
  }


  /**
   * Starts playing the music piece.
   * Returns a String for debugging purposes.
   *
   * @return a string for debugging purposes
   */
  public String start() {
    final SafeMusicRepresentation sm = new SafeMusicRepresentationDecorator(this.model);
    timer = new javax.swing.Timer(model.getTempo() / 1000, new ActionListener( ) {
      public void actionPerformed(ActionEvent e) {
        if (paused) {
          return;
        }
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

  /**
   * Sets the mouse mode.
   *
   * @param mr mouse mode
   */
  public void mouseMode(MouseMode mr) {
    System.out.println("Setting new mouse mode");
    this.mhandler.setHandler(mr);
  }

  /**
   * Increments the {@code beat} of the piece by one, unless the piece is at its end (in which case
   * it keeps the {@code beat} the same). Returns the new {@code beat}.
   *
   * @return the new beat
   */

  public int tickBeat() {
    int newBeat = this.beat;
    if (this.repeats.containsKey(this.beat)) {
      newBeat = this.repeats.get(this.beat).getSkipTo();

      Skip altSection = this.repeats.get(this.beat).getThen();
      if (altSection != null) {
        int altSectionBegin = this.repeats.get(this.beat).getSkipThen(); //awful varnames sorry
        this.altskips.put(altSectionBegin, altSection);
        System.out.println("Permskip added");
      }
      this.repeats.remove(this.beat);
      //return newBeat;
      this.setBeat(newBeat);

    } else if (this.altskips.containsKey(this.beat)) {
      newBeat = this.altskips.get(this.beat).getSkipTo();
      this.setBeat(newBeat);
    } if (this.model.getLength() > this.beat) {
      return this.beat++;
    }
    return this.beat;
  }

  /**
   * Set the {@code beat} to the given int {@code i}. If {@code i} is greater than the length of
   * the song, {@code beat} is set to the length of the song. Sets beat to 0 if trying to set beat
   * to negative.
   *
   * @param i new beat of song
   */
  public void setBeat(int i) {
    if (i < 0) {
      this.beat = 0;
    } else if (i > this.model.getLength()) {
      this.beat = this.model.getLength();
    } else {
      this.beat = i;
    }
  }

  /**
   * Sets the {@code beat} of the song ahead (or, behind, if negative) by {@code beats} number of
   * beats.
   *
   * @param beats number of beats to change beat by
   */
  public void scroll(int beats) {
    this.setBeat(this.beat + beats);
    if (this.beat < 0) {
      this.beat = 0;
    }
    else if (this.beat > this.model.getLength()) {
      this.beat = this.model.getLength();
    }
  }

  /**
   * Hits the pause button. If we're paused, unpause and vice versa.
   */
  public void pauseButton() {
    this.paused = !this.paused;
  }

  /**
   * Returns the music representation of this controller.
   *
   * @return the model
   */
  public MusicRepresentation getModel() {
    return this.model;
  }

  /**
   * Returns true when this controller is paused. For testing.
   * @return is it paused?
   */
  protected boolean getPaused() {
    return this.paused;
  }
}
