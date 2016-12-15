package lettercraze.model.game;

/**
 * The abstract Move class
 * @author Ruthenium
 * Version 1.0
 */
public abstract class Move {
	Game initialState;

	/**
	 * Create a new Game by applying the move to the initial game state
	 * @return the Game object after performing the move
	 */
	public abstract Game doMove();
	/**
	 * Get the Game from before the move was done.
	 * @return The game state before the move was done.
	 */
	public abstract Game undoMove();
	/**
	 * Tell if the move is valid for the provided Game
	 * @return T/F
	 */
	public abstract boolean isValid();
	/**
	 * If this returns true, then the move should automagically be undone if
	 * the move before it is undone.
	 * @return T/F
	 */
	public abstract boolean automagicUndo();
}
