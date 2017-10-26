public class NBody{
	public static double readRadius(String fileName){
		In in = new In(fileName);
		int i = 0;
		double Radius = 0.0;
		while (i < 2){
			Radius = in.readDouble();
			i = i + 1;
		}
		return Radius;
	}

	public static Planet[] readPlanets(String fileName){
		In in = new In(fileName);
		int numOfPlanets = (int)Math.round(in.readDouble());
		double Radius = in.readDouble();
		Planet[] Planets = new Planet[numOfPlanets];
		int i = 0;
		while (i < Planets.length){
			double xpos = in.readDouble();
			double ypos = in.readDouble();
			double xvel = in.readDouble();
			double yvel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			Planets[i] = new Planet(xpos, ypos, xvel, yvel, mass, img);
			i = i + 1;
		}
		return Planets;
	}
	public static void main(String[] args){
		int lengthOfIP = args.length();
		if (lengthOfIP < 3){
			System.out.println('Please type "Current time", "dt" and "fileName"')
		}
		double T = args[0];
		double dt = args[1];
		String fileName = args[2];
	}
}