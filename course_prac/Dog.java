public class Dog{
	public int WeightInPounds;

	public Dog(int w){
		WeightInPounds = w;
	}

	public void makenoise(){
		if (WeightInPounds < 10){
			System.out.println("yipyip");
		}else if (WeightInPounds < 20){
			System.out.println("bark");
		}else{
			System.out.println("woof");
		}
	}
	public static Dog maxDog(Dog a, Dog b){
		if (a.WeightInPounds > b.WeightInPounds){
			return a;
		}else{
			return b;
		}
	}
}