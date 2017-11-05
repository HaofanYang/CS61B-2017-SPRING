
public class Test{
	public static void main(String[] args){
		ArrayDeque<String> a = new ArrayDeque<>();
		/*
		System.out.println(a.size());
		System.out.println(a.nextFirst);
		System.out.println(a.nextLast);
		a.addFirst("a");
		System.out.println(a.nextFirst);
		System.out.println(a.nextLast);
		System.out.println(a.size());
		*/
	
		a.addFirst("c");
		a.addLast("b");
		a.addLast("a");
		a.addLast("a");
		a.addLast("a");
		a.addFirst("a");
		a.addLast("fuck you");

		a.printDeque();
		System.out.println(" ");
		System.out.print("nextFirst = ");
		System.out.println(a.nextFirst);
		System.out.print("nextLast = ");
		System.out.println(a.nextLast);
		System.out.print("size = ");
		System.out.println(a.size());

	}
}