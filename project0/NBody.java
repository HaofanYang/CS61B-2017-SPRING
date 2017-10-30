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
		int lengthOfIP = args.length;
		if (lengthOfIP < 3){
			System.out.println("Please type 'time limit', 'dt' and 'fileName'");
		}
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String fileName = args[2];
		double Radius = readRadius(fileName);
		double[] audio = StdAudio.read("audio/2001.mid");
		StdAudio.play(audio);
		StdDraw.setScale(Radius, -Radius);
		StdDraw.picture(0,0,"images/starfield.jpg");
		StdDraw.show(2);
		Planet[] planets = readPlanets(fileName);
		int i = 0;
		while (i < planets.length){
			planets[i].draw();
			i = i + 1;
		double t = 0.0;
		while (t <= T){
			double[] xForces = new double[5];
			double[] yForces = new double[5];
			int j = 0;
			while (j < 5){
				xForces[j] = planets[j].calcNetForceExertedByX(planets);
				yForces[j] = planets[j].calcNetForceExertedByY(planets);
				j = j + 1;
			}
			int h = 0;
			while (h < 5){
				planets[h].update(dt, xForces[h], yForces[h]);
				h = h + 1;
			StdDraw.picture(0,0,"images/starfield.jpg");
			}
			for (int k = 0; k < 5; k++){
				planets[k].draw();
			}
			StdDraw.show(10);
			t = t + dt;
		}

		}
	}
}