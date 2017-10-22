public class draw_triangle{
	public static int maxi(int[] m){
		int a = m[0];
		int count = 0;
		while (count < m.length){
			if (m[count] > a){
				a = m[count];
			}
			count = count + 1;
		}
		return a;
	}
   public static void main(String[] args)
   {
      int[] list = new int[]{1,3,4,5,6,2,434,5,6,7};
      int max_of_list = maxi(list);
      System.out.println(max_of_list);
   }
}