
/**
 * This class represents the snake that will be used for the game
 * @author Julia Anantchenko
 */

public class SnakeLinked {

	/** The length of the snake */
	private int snakeLength;
	
	/** The doubly linked list of snake positions */
	private DoubleList<Position> snakeBody;

	/**
	 * Constructor, creates a snake at the specified position
	 * @param row: the row of the starting position
	 * @param col: the column of the starting position
	 */
	public SnakeLinked(int row, int col) {
		snakeLength = 1;
		snakeBody = new DoubleList();
		snakeBody.addData(0, new Position(row, col));;
	}

	/**
	 * Gets the length of the snake
	 * @return the length
	 */
	public int getLength() {
		return snakeLength;
	}
	
	/** 
	 * Gets the position at the specified index
	 * @param index: where the position is
	 * @return the position
	 */
	public Position getPosition(int index) {

		// returns position if it is part of the snake
		if (index >= 0 && index < snakeLength)
			return snakeBody.getData(index);

		// returns null otherwise
		return null;
	}

	/**
	 * Checks if there is a snake part in the specified location
	 * @param pos: the position
	 * @return true if part of the snake is there
	 */
	public boolean snakePosition(Position pos) {

		// checks if the position is part of the snake by going through each snake position
		for (int i = 0; i < snakeLength; i++) {
			if (pos.equals(snakeBody.getData(i)))
				return true;
		}

		// returns false if the position is not in the snake
		return false;
	}

	/**
	 * Moves the head to a new position
	 * @param direction: which way the snake is moving
	 * @return the new position of the head
	 */
	public Position newHeadPosition(String direction) {

		// creates a new position for the head to move to
		Position newPos = new Position(snakeBody.getData(0).getRow(), snakeBody.getData(0).getCol());

		// switch statement for the direction, changes coordinates accordingly
		switch (direction) {
		case "right":
			newPos.setCol(newPos.getCol()+1);
			break;
		case "left": 
			newPos.setCol(newPos.getCol()-1);
			break;
		case "up": 
			newPos.setRow(newPos.getRow()-1);
			break;
		case "down": 
			newPos.setRow(newPos.getRow()+1);
			break;
		default:
			System.out.print("direction is wrong");
			break;
		}

		// returns the new position
		return newPos;
	}

	/**
	 * Moves the snake in a direction
	 * @param direction: the way to move
	 */
	public void moveSnakeLinked(String direction) {

		// moves the head in the direction specified
		snakeBody.addData(0, newHeadPosition(direction));
		snakeBody.removeData(snakeLength);
	}

	/**
	 * Shrinks the snake by 1
	 */
	public void shrink() {
		snakeBody.removeData(snakeLength-1);
		snakeLength--;
	}
	
	/**
	 * Moves the snake and increases its length by 1
	 * @param direction: the way to move
	 */
	public void grow(String direction) {

		// increases snake length
		snakeLength++;

		// moves the snake
		snakeBody.addData(0, newHeadPosition(direction));
	}

}
