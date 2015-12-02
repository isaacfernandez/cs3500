We have made few major changes to the previous assignment, but many additions. We added a BeatBar
which renders the red bar where it should be in the view, and created a new GuiView interface
which extends the MusicRepresentationView, and is implemented by any view with a GUI.
We changed how notes are sent, adding a timer to send the stop messages, because we were having
issues with timing of notes.
We added a KeyHandler and a MouseHandler. The KeyHandler can pause, fast-foward, rewind, jump to
start, and jump to end of a piece (j/k is used for start/end because Regan's computer didn't have
home and end keys. Space is used for pausing. Arrow keys are used for fast-fowarding and
rewinding.) Due to a medical issue with Regan and Isaac leaving a place with internet access on
Monday, the MouseHandler doesn't fully work, but it registers clicks. The idea is that we would be
able to change the mode using different keys, and clicks would do different things in different
modes. We also now have a composite GuiMidiViewImpl, which displays and plays the music.