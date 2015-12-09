Design changes:
	MusicRepresentation (The model interface):
		A lot of refactoring and removal of unnecessary fields and methods.
		The logic for getting the display range was simplified by changing the 
		logic for lowest() and highest() and letting the model wrapper do it.
	SafeMusicRepresentation (Model Wrapper Interface):
		A new addition to safeguard a view from modifying the model it displays.
		It also provides functionality to views with displayNotes(), which 
		abstracts the logic for enumerating all notes [lowest, highest]
	Tone (Pitch(Note enum) + duration + beat ... etc):
		Added more functionality, made Note be 0 indexed again. Documented and 
		more heavily enforced invariants within the code.
	VIEW~
	All views implement MusicRepresentationView, so that they share a type and 
	implement the method display(SafeMusicRepresentation m)
	Views are created through the MusicRepresentationViewFactory, which is
	constructed with a SafeMusicRepresentation, and can then return a view 
	corresponding with the mode that its makeView method is called with.

	MusicRepresentation views also promise a getLog() method, that returns 
	their log mechanism, but errors if not in a test#view# mode.

	Wires and Mechanics:
	The MusicEditor (Main) parses the program arguments. It then creates a 
	MusicController with the help of the CompositionBuilder, and calls its start
	method. Controller then asks the factory to create the appropiate view for 
	the mode given.
	Calling the start() method on the controller then trickles down to call its
	view's .display() method.

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