package cs3500.music.view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.sound.midi.InvalidMidiDataException;
import javax.swing.*;

import cs3500.music.controller.MouseAndKeyHandler;
import cs3500.music.model.MusicModel;
import cs3500.music.model.Note;
//import cs3500.music.model.NoteImpl;
//import cs3500.music.model.Piece;
// CHANGE: REMOVED UNUSED CODE THAT WE CAN'T USE BECAUSE IMPLEMENTATION LEAK
import cs3500.music.model.NoteEnum;
//Imported for static method to replace their code.

/**
 * A dummy view that simply draws a string
 */
public class ConcreteGuiViewPanel extends JPanel implements ViewInterface {

  boolean paused = false;

  //MusicModel testPiece = new Piece.PieceBuilder().build();
  //Note temp = new NoteImpl(0, 2, 60);
  // CHANGE: REMOVED UNUSED CODE THAT WE CAN'T USE BECAUSE IMPLEMENTATION LEAK
  String console;
  Note totalStart;
  Note totalEnd;
  int endBeat;
  Collection<Collection<Rectangle>> forPrint = new ArrayList<>();
  MusicModel m;
  MouseAndKeyHandler mkHandler = new MouseAndKeyHandler(); //TODO fix this

  public ConcreteGuiViewPanel(MusicModel m) {
    this.m = m;
    JFrame frame = new JFrame();

    frame.addKeyListener(mkHandler);
    frame.addMouseListener(mkHandler);
    generateListOfFuncs();

  }

  public ConcreteGuiViewPanel() {

  }

  private void generateListOfFuncs(){
    HashMap<Integer, Runnable> keyPressed = new HashMap<Integer, Runnable>();
    HashMap<Integer, Runnable> keyHeld = new HashMap<Integer, Runnable>();
    HashMap<Integer, Runnable> keyReleased = new HashMap<Integer, Runnable>();
//        keyPressed.put(KeyEvent.VK_UP, () -> Gui.moveUp());
//        keyPressed.put(KeyEvent.VK_DOWN, () -> Gui.moveDown);
//        keyPressed.put(KeyEvent.VK_LEFT, () -> Gui.moveLeft);
//        keyPressed.put(KeyEvent.VK_RIGHT, () -> Gui.moveRight);
//        keyPressed.put(KeyEvent.VK_HOME, () -> Gui.moveFullLeft);
//        keyPressed.put(KeyEvent.VK_END, () -> Gui.moveFullRight);
    keyPressed.put(KeyEvent.VK_SPACE, () -> {
      paused = !paused;
      System.out.println(paused);
    });
    keyPressed.put(KeyEvent.VK_HOME, () -> {});

    for (Integer i : keyPressed.keySet()){
      mkHandler.addPressed(i, keyPressed.get(i));
    }

    keyHeld = new HashMap<Integer, Runnable>();
    keyHeld.put(KeyEvent.VK_R, () -> {
//                (on mouseclicked)
//                    xy = Gui.getPosnOfMouse;
//                    testPiece.removeNote(Gui.getNoteAtPosn);
//
    });
    keyHeld.put(KeyEvent.VK_A, () -> {
//                (on mouseclicked)
//                xy1 = Gui.getPosnOfMouse;
//                (on mouserelease)
//                xy2 = Gui.getPosnOfMouse;
//                testPiece.addNote(xy1, xy2, pitch, 1, 64);
    });

    for (Integer i : keyHeld.keySet()){
      mkHandler.addHeld(i, keyHeld.get(i));
    }

    keyReleased = new HashMap<Integer, Runnable>();

    for (Integer i : keyReleased.keySet()){
      mkHandler.addReleased(i, keyReleased.get(i));
    }
  }

  @Override
  public void paint(Graphics g){
    super.paintComponent(g);
    this.playPiece(m);
    for (Collection<Rectangle> collection: forPrint) {
      for (Rectangle r : collection) {
        g.drawRect(r.x, r.y, r.l, r.h);
        g.setColor(r.color);
        g.fillRect(r.x, r.y, r.l, r.h);
      }
    }
    for (int i = m.lowestPitch().getPitch(); i <= m.highestPitch().getPitch(); i++) {
      //Note temp = new NoteImpl(0, 0, i);
      //Commented out because we don't have their implementation of note.
      g.setColor(Color.BLACK);
      //g.drawString(temp.getPitchInOctave() + temp.getOctave(), 0,
      //Commented out because we don't have their implementation of note, replaced with the logic
      // we believe they used.
      g.drawString(NoteEnum.ValueToString(i%12)+ i/12, 0,
              10 * (i - m.lowestPitch().getPitch()) + 35);
      g.setColor(Color.WHITE);
      g.drawLine(25, 10 * (i - m.lowestPitch().getPitch()) + 35,
              m.endBeat() * 10 + 35, 10 * (i - m.lowestPitch().getPitch()) + 35);
    }
    for (int i = 0; i <= m.endBeat(); i++) {
      if (i % m.getBpm() == 0) {
        g.setColor(Color.RED);
        g.drawString("" + i, i * 10 + 20, 15);
        g.setColor(Color.WHITE);
        g.drawLine(i * 10 + 25, 25, (i * 10) + 25,
                (m.highestPitch().getPitch() - m.lowestPitch().getPitch() + 1) * 10 + 25);
      }
    }
  }


  @Override
  public void playPiece(MusicModel m) {
    this.totalStart = m.lowestPitch();
    this.totalEnd = m.highestPitch();
    this.endBeat = m.endBeat();
    for (int i = 0; i <= this.endBeat; i++ ) {
      this.playBeat(m, i);
    }
  }

  @Override
  public void playBeat(MusicModel m, int beat) {
    Collection<Note> notesAtBeat = m.notesPlayingAtBeat(beat);
    Collection<Note> notesAtBeatByPitch = Piece.sortNotesByPitch(notesAtBeat);
    Collection<Rectangle> shapeList = new ArrayList<Rectangle>();
    int start = this.totalStart.getPitch();
    for (Note n : notesAtBeatByPitch) {
      while (start <= n.getPitch()) {
        // Note forPitch = new NoteImpl(0, 0, start);
        // Commented out because it's not used and we can't use their NoteImpl
        if (n.getPitch() == start) {
          if (n.getStartBeat() == beat) {
            shapeList.add(new Rectangle((10 * beat) + 25,
                    10 * (start - m.lowestPitch().getPitch()) + 25,
                    9, 9, Color.yellow));
          } else {
            shapeList.add(new Rectangle((10 * beat) + 25,
                    10 * (start - m.lowestPitch().getPitch()) + 25,
                    9, 9, Color.GREEN));
          }
          shapeList.add(new Rectangle((10 * beat) + 25,
                  10 * (start - m.lowestPitch().getPitch()) + 25,
                  9, 9, Color.BLACK));
        } else {
          shapeList.add(new Rectangle((10 * beat) + 25,
                  10 * (start - m.lowestPitch().getPitch()) + 25,
                  9, 9, Color.BLACK));
        }
        start++;
      }
    }
    while (start <= m.highestPitch().getPitch())  {
      shapeList.add(new Rectangle((10 * beat) + 25,
              10 * (start - m.lowestPitch().getPitch()) + 25,
              9, 9, Color.BLACK));
      start++;
    }
    forPrint.add(shapeList);
  }



  @Override
  public void playFromBeat(MusicModel m, int beat) throws InvalidMidiDataException {

  }
}

