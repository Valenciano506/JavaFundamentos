package datastructure.list;

/*
 *
 * @author Valenciano
 * 12 feb 2026
 */
public class List<E> {	
	
	//The reference to the last element in the list 
	private Node<E> last;
	//The reference to the first element of the list 
	private Node<E> first;
	
	public Node<E> remove(){
		
		Node<E> temp2;
		Node<E> temp = first;	
		//&& means and
		while(temp != null && temp.next != null) {//While temp and temp.next are not null
			temp2 = temp;
			//Move to the next node
			temp = temp.next;
		}
		return null;
	}
	
	//This method removes a node from the tail of the list
	public void remove(Node<E> node) {
		
	}
	
	public void add(Node<E> node) throws Exception {
		//1. Check the parameter if it is valid
		if(node == null) {
			throw new Exception("You cannot pass a null node to the list.");
		}
		
		//2. Add the node to the tail of the list
		//2.1 Check first if the head element is null, in case of null, it means that the list is empty
		if(first == null) {//If the list is empty
			//The list is empty
			last = node;
			first = node;
		}

		else {
			last.next = node;
			last = node;
		}		
		
	}

	/**
	 * @return the last
	 */
	public Node<E> getLast() {
		return last;
	}

	/**
	 * @return the first
	 */
	public Node<E> getFirst() {
		return first;
	}
	
	//Print all the nodes of the list
	public void printList() {
//		System.out.println(first.getData());
//		System.out.println(first.getNext().getData());
//		System.out.println(first.getNext().getNext().getData());
//		System.out.println(first.getNext().getNext().getNext().getData());
		
		Node<E> temp = first;
		while(temp != null) { //While temp is not null
			//Print the data stored in this node
			System.out.print(temp.getData() + ", ");
			//Move to the next node
			temp = temp.next;
		}
	}

}

class Node<E> {
	
	public Node(E e) {
		data = e;
	}
	//The data stored in a node of the list
	private E data;
	//Each node needs to pint to the next node, we use this variable to do it
	protected Node<E> next;
	/**
	 * @return the data
	 */
	public E getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(E data) {
		this.data = data;
	}
	/**
	 * @return the next
	 */
	public Node<E> getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
}
