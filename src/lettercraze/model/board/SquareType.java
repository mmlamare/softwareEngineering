package lettercraze.model.board;

/**
 * An enumerated list of the three kinds of squares.
 * @author Jack Pugmire
 * @version 1.0
 */
public enum SquareType {
	/**A blocked Square. one that won't be part of the level */
	BLOCKED,
	/**An empty square, one that has a random letter */
	EMPTY,
	/**A letter square, one that has a set level */
	LETTER
}
