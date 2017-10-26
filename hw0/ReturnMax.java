public class ReturnMax {
   public static int max(int[] m) {
	   	int count = 0;
	   	int maxvalue = 0;
	   	while (count < m.length){
	   		if (m[count] > maxvalue){
	   			maxvalue = m[count];
	   		}count = count + 1;
	   	}
       return maxvalue;
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
      System.out.println(max(numbers));

   }
}