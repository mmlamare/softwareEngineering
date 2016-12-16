# README

This is LetterCraze. LetterCraze is the final group project for CS3733. The team name is Ruthenium. Team Members are:
Matthew Lamare
Jacob Fakault
Jack Pugmire
Cameron Maitland
Andrew Lewis


### How do I get set up?

Open the root directory as a workspace in eclipse. To run the main game for the player,
run the main method in lettercraze.MainPlayer. To run the builder, use the main method in
lettercraze.MainBuilder. For code coverage test, right click on the test directory and run it
as a coverage test.

### Game Usage

* black squares are blocked
* to select a word, click on the letters you want in order. All letters must be adjacent.
* clicking on the last selected letter will deselect it
* clicking undo will unselect all currently selected letters, if there are any. Otherwise,
it will undo the previously-submitted word
* to submit a word, press either Space or Enter. Words must be at least 3 characters long
* The current game mode and other useful information is displayed in the top right corner
* if there is an empty space above a blocked square, letters will phase through the blocked
square to fill that space.

### Builder Usage

* To create a new level, simply launch the builder. It will start out initialized
with a blank puzzle level
* the game mode can be changed with radio buttons on the right side of the window
* Levels are saved as files on the disk. The default save location is the game's data
directory, which is a directory named '.lettercraze' in the user's home directory.
* Levels are simply files, so they can be deleted, moved, and renamed using your
operating system's file manager
* clicking on a square in the game board view will toggle whether the square is
empty or blocked
* To set a letter in Theme mode, right click on the targeted square
* The add/delete word controls only work in theme mode
* Clicking the preview button will open a new window with a game view that plays your level