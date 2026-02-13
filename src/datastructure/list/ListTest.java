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
		
		List<Integer> list = new List<Integer>();
		System.out.println("The first node of the list is: " + list.getFirst());
		System.out.println("The last node of the list is: " + list.getLast());
		//list.add(null);
		list.add(new Node(30));
		list.add(new Node(20));
		list.add(new Node(10));
		list.add(new Node(40));
		list.add(new Node(50));
		list.add(new Node(60));

	}

}
