public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static double GravityConstant = 6.67 * Math.pow(10,-11);
	public Planet(double xP, double yP, double xV,
				 double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = "images/" + img;
	}
	//* 想一想如果你运行 Planet b = new Planet(a)，你到底希望它做什么？*／
	//*	当然就是把a所有的参数传给b */
	//* 但是这个新Planet还没有名字，但是可以用this来generalize */
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		double dx = p.xxPos - this.xxPos;
		double dy = p.yyPos - this.yyPos;
		return Math.pow((Math.pow(dx,2) + Math.pow(dy,2)),0.5);
	}

	public double calcForceExertedBy(Planet p){
		double r = this.calcDistance(p);
		double r2 = r * r;
		return GravityConstant * this.mass * p.mass / r2;
	}

	public double calcForceExertedByX(Planet p){
		double dx = p.xxPos - this.xxPos;
		double r = this.calcDistance(p);
		double r2 = this.calcDistance(p) * this.calcDistance(p);
		return this.calcForceExertedBy(p) * (dx / r);
	}

	public double calcForceExertedByY(Planet p){
		double dy = p.yyPos - this.yyPos ;
		double r = this.calcDistance(p);
		double r2 = this.calcDistance(p) * this.calcDistance(p);
		return this.calcForceExertedBy(p) * (dy / r);
	}
	public double calcNetForceExertedByX(Planet[] allPlanets){
		int i = 0;
		double NetForce = 0;
		while (i < allPlanets.length){
			if (this.equals(allPlanets[i])){
				i = i + 1;
				continue;
			}
			NetForce = NetForce + this.calcForceExertedByX(allPlanets[i]);
				i = i + 1;
		}
		return NetForce;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		int i = 0;
		double NetForce = 0;
		while (i < allPlanets.length){
			if (this.equals(allPlanets[i])){
				i = i + 1;
				continue;
			}
			NetForce = NetForce + this.calcForceExertedByY(allPlanets[i]);
				i = i + 1;
		}
		return NetForce;
	}

	public void update(double dt, double fX, double fY){
		this.xxVel = this.xxVel + dt * fX / this.mass;
		this.yyVel = this.yyVel + dt * fY / this.mass;
		this.xxPos = this.xxPos + this.xxVel * dt;
		this.yyPos = this.yyPos + this.yyVel * dt;
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
	}
}