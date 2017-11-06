
public class Test{
	public static void main(String[] args){
		ArrayDeque<Integer> a = new ArrayDeque<>();
		int count = 0;
		while (count < 1000){
			a.addFirst(count);
			a.addLast(count);
			count += 1;
		}
		while (count > 500){
			a.removeFirst();
			a.removeLast();
			count -= 1;
		}

		a.printDeque();
		System.out.println(" ");
		System.out.print("nextFirst = ");
		System.out.println(a.nextFirst);
		System.out.print("nextLast = ");
		System.out.println(a.nextLast);
		System.out.print("size = ");
		System.out.println(a.size());
		System.out.print("efficiency= ");
		System.out.println(a.get(498));
	}
}