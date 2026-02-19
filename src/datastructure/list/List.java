/**
 * 
 */
package datastructure.list;

/*
 *Interface oriented development: we use interfaces to
 *abstract different solutions
 *
 * @author Valenciano
 * 19 feb 2026
 */
public interface List<E> {
	
	
	//Add an element to the tail of the list	
	public void add(E e);
	
	//Elimina un elemento de una posición específica de la lista
	public E remove(int index);
	
	//Elimina el ultimo elemento de la lista
	public E removeFromTail();
	
	//Elimina el primer elemento de la lista
	public E removeFromHead();
	
	//Añade un elemento a una posición específica de la lista
	public void add(E e, int position);

}
