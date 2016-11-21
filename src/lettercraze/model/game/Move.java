package lettercraze.model.game;

public abstract class Move {
	/**
	 * Modify the move's Game object. This method works under the assumptions
	 * that the caller has already verified the move's validity AND that the
	 * game state has not been modified since the last call to isValid(). In
	 * addition, the state of the game is saved when this method is called so
	 * that it can later be restored if necessary. apply() should not modify
	 * the pastMoves field.
	 */
	abstract void apply(Game g);
	/**
	 * Undoes the effects of the last call to apply().
	 * @param g
	 * @return
	 */
	abstract void restore(Game g);
	/**
	 * Checks to make sure that the move is valid for the given Game. This
	 * should always be called before apply()
	 * @param g
	 * @return
	 */
	abstract boolean isValid(Game g);
}
