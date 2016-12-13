package lettercraze.model.game;

/**
 * The abstract Move class
 * @author Jack Pugmire
 * Version 1.0
 */
public abstract class Move {
	Game initialState;

	abstract Game doMove();
	abstract Game undoMove();
	abstract boolean isValid();
}
