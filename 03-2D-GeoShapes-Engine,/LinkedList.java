package GameEx_Final;

/**
 * A custom singly linked list implementation for managing geometric shapes (NodeInterface).
 */
public class LinkedList implements LinkedListInterface {

	private NodeInterface head;

	/**
	 * Constructs an empty LinkedList.
	 */
	public LinkedList() {
		this.head = null;
	}

	@Override
	public NodeInterface getHead() {
		return this.head;
	}

	/**
	 * Appends a new node to the end of the linked list.
	 * 
	 * @param p - the node to be added.
	 */
	@Override
	public void add(NodeInterface p) {
		if (p == null) {
			return;
		}
		p.setNext(null); // Ensure the new tail node does not point to another node

		if (this.head == null) {
			this.head = p;
		} else {
			NodeInterface temp = this.head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(p);
		}
	}

	/**
	 * Removes the first occurrence of the specified node from the linked list.
	 * 
	 * @param p - the node to be removed.
	 */
	@Override
	public void remove(NodeInterface p) {
		if (this.head == null || p == null) {
			return;
		}

		if (this.head == p) {
			this.head = this.head.getNext();
			return;
		}

		NodeInterface temp = this.head;
		while (temp.getNext() != null) {
			if (temp.getNext() == p) {
				temp.setNext(temp.getNext().getNext());
				return; // Node removed, no need to continue traversing
			}
			temp = temp.getNext();
		}
	}
}