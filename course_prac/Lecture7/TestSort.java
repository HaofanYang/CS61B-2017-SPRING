public class TestSort{
/** test the sort class */ 
	public static void testSort(){
		String[] input = {"apple", "juice", "go", "kingslanding", "idk"};
		Sort.sort(input);
		String[] expect = {"go", "idk", "apple", "juice", "kingslanding" };

		// Test if the actual result is the expected value
		org.junit.Assert.assertArray Equals(expect, input);

	}

	public static void main(String[] args){
		testSort();
	}
}