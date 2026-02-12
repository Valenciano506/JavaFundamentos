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
	
	public void add(Node<E> node) {
		
		last.next = node;
		
	}

}

class Node<E> {
	
	//The data stored in a node of the list
	private E e;
	//Each node needs to pint to the next node, we use this variable to do it
	protected Node<E> next;
	
}
