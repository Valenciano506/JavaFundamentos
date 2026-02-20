/**
 * 
 */
package datastructure.list;

/*
 *Interface oriented development: we use interfaces to
 *abstract different solutions
 *In an interface, you can declare methods, but without
 *implementations, in other words, without method body,
 *or only with the method signature (firma). As each method
 *could have multiples different implementation in different
 *class.
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
