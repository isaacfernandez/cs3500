package cs3500.music.view;

public interface GuiViewInterface extends ViewInterface {
    /* Add things that make sense for Keyboard and Mouse Inputs
       Swing has setKeyHandler and setMouseHandler methods.
       Swing also has removeKeyHandler and removeMouseHandler methods. */

    /* PlayPiece() should change to allow pausing.
        We have a "keyPressed" event for space bar.
            It switches whether the piece should be paused or not.
        Have a boolean in newGuiView that checks whether the piece should be paused or not.
        If so, don't throw any more "playBeat" until the flag is false again
     */
}
