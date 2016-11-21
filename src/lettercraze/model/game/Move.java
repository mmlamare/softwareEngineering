package lettercraze.model.game;

public abstract class Move {
	Game initialState;

	abstract Game doMove();
	abstract Game undoMove();
	abstract boolean isValid();
}
