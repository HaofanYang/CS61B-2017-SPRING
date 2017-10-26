public class Doglauncher{
	public static void main(String[] args){
		Dog d = new Dog(8);
		Dog d2 = new Dog(20);
		Dog lagerdog = Dog.maxDog(d,d2);
	}
}