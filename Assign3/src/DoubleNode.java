
/**
 * This class represents the nodes in in a doubly linked list
 * @author Julia Anantchenko
 * @param <T> the generic type
 */

public class DoubleNode<T> {

	/** The next node in the list */
	private DoubleNode<T> next;
	
	/** The previous node in the list */
	private DoubleNode<T> prev;
	
	/** The data stored in this node */
	private T data;
	
	/**
	 * Constructor, creates an empty node where everything is null
	 */
	public DoubleNode() {
		next = null;
		prev = null;
		data = null;
	}
	
	/**
	 * Constructor, creates a node that stores given data
	 * @param newData: the data that will be stored
	 */
	public DoubleNode(T newData) {
		next = null;
		prev = null;
		data = newData;
	}
	
	/**
	 * Returns the next node
	 * @return the next node
	 */
	public DoubleNode<T> getNext() {
		return next;
	}
	 /**
	  * Returns the previous node
	  * @return the previous node
	  */
	public DoubleNode<T> getPrev() {
		return prev;
	}
	
	/**
	 * Returns the data of the node
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Sets the next node
	 * @param nextNode: the next node
	 */
	public void setNext(DoubleNode<T> nextNode) {
		next = nextNode;
	}
	
	/**
	 * Sets the previous node
	 * @param prevNode: the previous node
	 */
	public void setPrev(DoubleNode<T> prevNode) {
		prev = prevNode;
	}
	
	/**
	 * Sets new data
	 * @param newData: the new data
	 */
	public void setData(T newData) {
		data = newData;
	}
	
}
