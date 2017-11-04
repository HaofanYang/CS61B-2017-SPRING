 /** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class SLList {	
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	} 

	/* The first item (if it exists) is at sentinel.next. */
	private IntNode sentinel;
	private int size;
	private IntNode last;

	/** Creates an empty SLList. */
	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
		last = sentinel.next;
	}

	public SLList(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
		last = sentinel.next;
	}

 	/** Adds x to the front of the list. */
 	public void addFirst(int x) {
 		sentinel.next = new IntNode(x, sentinel.next);
 		size = size + 1;
 		if (last == null){
 			last = sentinel.next;
 		}
 	}

 	/** Returns the first item in the list. */
 	public int getFirst() {
 		return sentinel.next.item;
 	}

 	/** Adds x to the end of the list. */
 	public void addLast(int x) {
 		size = size + 1;
 		if (last == null){
 			sentinel.next = new IntNode (x, sentinel.next);
 			last = sentinel.next;
 		}else{
	 		last.next = new IntNode(x, last.next);
	 		last = last.next;
 		} 		
 	}
 	
 	/** Returns the size of the list. */
 	public int size() {
 		return size;
 	}

	public static void main(String[] args) {
 		/* Creates a list of one integer, namely 10 */
 		SLList L = new SLList(3);
 		L.addLast(20);
 		L.addLast(30);
 		System.out.println(L.getFirst());
 	}
}