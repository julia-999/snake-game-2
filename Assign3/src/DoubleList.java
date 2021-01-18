
/**
 * This class represents a doubly linked list of nodes of the class DoubleNode
 * @author Julia Anantchenko
 * @param <T>: the generic type
 */

public class DoubleList<T> {

	/** The first node in the list */
	private DoubleNode<T> head;
	
	/** The last node in the list */
	private DoubleNode<T> rear;
	
	/** the number of nodes in the list */
	private int numDataItems;

	/**
	 * Constructor: creates an empty list with zero nodes
	 */
	public DoubleList() {
		numDataItems = 0;
		head = null;
		rear = null;
	}

	/**
	 * Adds a new node to the list
	 * @param index: where to add it
	 * @param newData: the data of the node
	 * @throws InvalidPositionException
	 */
	public void addData(int index, T newData) throws InvalidPositionException {
		// checks if the position is valid
		if (index < 0 || index > numDataItems)
			throw new InvalidPositionException("Invalid position");
		
		// creates a node using the new data
		DoubleNode<T> temp = new DoubleNode<T>(newData);

		// adding a node if it is added at the front
		if (index == 0) {
			temp.setNext(head);
			if (numDataItems != 0)
				head.setPrev(temp);
			head = temp;
			if (numDataItems == 0) 
				rear = temp;
		}

		// adding a node if it is added at the end
		else if (index == numDataItems) {
			rear.setNext(temp);
			temp.setPrev(rear);
			rear = temp;
		}
		
		// adding a node if it is anywhere in between
		else {
			DoubleNode<T> current = head;
			for (int i = 0; i < index; i++) 
				current = current.getNext();
			temp.setNext(current.getNext());
			current.setNext(temp);
			temp.setPrev(current);
			current.getNext().setPrev(temp);
		}

		// increases the count for the nodes
		numDataItems++;
	}

	/**
	 * Returns the node at specified index
	 * @param index: the index of the node
	 * @return the node
	 * @throws InvalidPositionException
	 */
	public DoubleNode<T> getNode(int index) throws InvalidPositionException {
		
		// checks if the position is valid
		if (index < 0 || index >= numDataItems) 
			throw new InvalidPositionException("Invalid position");

		// goes through the list to find the node
		DoubleNode<T> current = head;
		for (int i = 0; i < index; i++)
			current = current.getNext();

		// returns the node
		return current;
	}

	/**
	 * Removes data at specified index
	 * @param index: the index of the node
	 * @throws InvalidPositionException
	 */
	public void removeData(int index) throws InvalidPositionException {
		
		// checks if the position is valid
		if (index < 0 || index >= numDataItems) 
			throw new InvalidPositionException("Invalid position");

		// sets current to equal the head
		DoubleNode<T> current = head;

		// if the node to be removed is at the front
		if (index == 0) {
			head = current.getNext();
			return;
		}
		
		// if the node is anywhere else in the list
		for (int i = 0; i < index; i++)
			current = current.getNext();
		if (current.getPrev() != null)
			current.getPrev().setNext(current.getNext());
		if (current.getNext() != null)
			current.getNext().setPrev(current.getPrev());
	
		// reduces the node counter
		numDataItems--;
	}

	/**
	 * Returns the data at the specified node
	 * @param index: the index of the node
	 * @return the data
	 * @throws InvalidPositionException
	 */
	public T getData(int index) throws InvalidPositionException {
		return getNode(index).getData();
	}

	/**
	 * Sets data at the specified index
	 * @param index: where to put the data
	 * @param newData: the data
	 * @throws InvalidPositionException
	 */
	public void setData(int index, T newData) throws InvalidPositionException {
		getNode(index).setData(newData);
	}
	
}
