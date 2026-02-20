package datastructure.list;

/*
 *
 * @author Valenciano
 * 12 feb 2026
 */
public class ListTest {

	public static void main(String[] args) throws Exception {
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(obj1);
		System.out.println(obj2);
		
		LinkedListImpl<Integer> list = new LinkedListImpl<Integer>();
		System.out.println("The first node of the list is: " + list.getFirst());
		System.out.println("The last node of the list is: " + list.getLast());
		//list.add(null);
		list.add(30);
		list.add(20);
		list.add(10);
		list.add(40);
		list.add(50);
		list.add(60);
		
		list.printList();

	}

}
