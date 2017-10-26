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
		imgFileName = img;
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
	public static double calcForceExertedByX(Planet X, Planet Y){
		double dx = X.xxPos - Y.xxPos;
		double dy = X.yyPos - Y.yyPos;
		double r = dx;
		GravityForce = GravityConstant * X.mass * Y.mass(Math.pow(dx,2) + Math.pow(dy,2));
		return 
	}
	
}