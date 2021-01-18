
/**
 * This class represents the board for the snake game
 * @author Julia Anantchenko
 */
public class BoardGameLinked {

	/** The length of the board*/
	private int boardLength;
	
	/** The width of the board */
	private int boardWidth;
	
	/** The snake object */
	private SnakeLinked theSnake;
	
	/** The array of doubly linked lists representing the game board */
	private DoubleList<String>[] board;

	/** 
	 * The constructor, uses the file specified to create the game board
	 * @param boardFile: the file to create the board
	 */
	public BoardGameLinked(String boardFile) {
		
		// creates a MyFileReader object to read the contents of boardFile
		MyFileReader file = new MyFileReader(boardFile);

		// assigns values from boardFile to the appropriate variables
		file.readInt();
		file.readInt();
		boardLength = file.readInt();
		boardWidth = file.readInt();

		// creates a Snake object from the specified position and an array for the board
		theSnake = new SnakeLinked(file.readInt(), file.readInt());
		board = new DoubleList[boardWidth];

		// sets all elements of the array and doubly linked list to "empty"
		for (int i = 0; i < boardWidth; i++) {
			board[i] = new DoubleList<String>();
			for (int j = 0; j < boardLength; j++) {
				board[i].addData(j, "empty");

			}
		}

		// sets specified locations to appropriate values
		while (!file.endOfFile()) {
			board[file.readInt()].setData(file.readInt(), file.readString());
		}
	}
	
	/**
	 * Gets the object at the specified position
	 * @param row: which row the object is in
	 * @param col: which column the object is in
	 * @return the object
	 * @throws InvalidPositionException
	 */
	public String getObject(int row, int col) throws InvalidPositionException {
		
		// checks if the position is valid
		if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength)
			throw new InvalidPositionException("Invalid Position");
		
		// returns the data
		return board[row].getData(col);
	}
	
	/**
	 * Sets the object at the specified position
	 * @param row: which row the object is in
	 * @param col: which column the object is in
	 * @param newObject: the new object
	 * @throws InvalidPositionException
	 */
	public void setObject(int row, int col, String newObject) throws InvalidPositionException {
		
		// checks if the position is valid
		if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength)
			throw new InvalidPositionException("Invalid Position");
		
		// sets the data
		board[row].setData(col, newObject);
	}
	
	/**
	 * Gets the snake
	 * @return the snake
	 */
	public SnakeLinked getSnakeLinked() {
		return theSnake;
	}
	
	/**
	 * Sets the snake
	 * @param newSnake: the new snake
	 */
	public void setSnakeLinked(SnakeLinked newSnake) {
		theSnake = newSnake;
	}
	
	/**
	 * Gets the length of the board
	 * @return the length
	 */
	public int getLength() {
		return boardLength;
	}
	
	/**
	 * Gets the width of the board
	 * @return the width
	 */
	public int getWidth() {
		return boardWidth;
	}
}
