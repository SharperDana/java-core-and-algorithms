package GameEx_Final;

/**
 * Represents a single node in a singly linked list of geometric shapes.
 * Implements the NodeInterface.
 */
public class Node implements NodeInterface {

	private GeoShape data;
	private NodeInterface next;

	/**
	 * Constructs a Node with the specified geometric shape and next node reference.
	 * 
	 * @param data - the GeoShape stored in this node.
	 * @param next - reference to the next node in the list.
	 */
	public Node(GeoShape data, NodeInterface next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * Constructs a standalone Node with the specified geometric shape and no next node.
	 * 
	 * @param data - the GeoShape stored in this node.
	 */
	public Node(GeoShape data) {
		this(data, null);
	}

	@Override
	public GeoShape getData() {
		return this.data;
	}

	@Override
	public void setData(GeoShape g) {
		this.data = g;
	}

	@Override
	public NodeInterface getNext() {
		return this.next;
	}

	@Override
	public void setNext(NodeInterface next) {
		this.next = next;
	}
}