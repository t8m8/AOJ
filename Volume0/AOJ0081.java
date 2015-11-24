import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0081 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		String[] s = in.next().split(",");
		Point p = reflect(new Line(Double.parseDouble(s[0]), Double.parseDouble(s[1]), Double.parseDouble(s[2]), Double.parseDouble(s[3])),
			new Point(Double.parseDouble(s[4]), Double.parseDouble(s[5])));
		out.println(p.getX()+" "+p.getY());
	}

	static Point project(Line l, Point p) {
		Point p1 = l.getP1();
		Point p2 = l.getP2();

		Vector base = new Vector(p2,p1);
		double r = Vector.dot(new Vector(p, p1), base) / base.norm();

		return base.scalarMul(r).plus(p1).toPoint();
	}

	static Point reflect(Line l, Point p) {
		return new Vector(project(l,p),p).scalarMul(2.0).plus(p).toPoint();
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(in.hasNext())solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}

class EuclideanSpace{
	public static final double EPS = 1E-10;
	public static boolean epsEquals(double a, double b) { return Math.abs(a-b) < EPS; };
}

class Point extends EuclideanSpace implements Comparable, Cloneable {

	private double x, y;
	public Point(double x, double y) {
		this.x = x; this.y = y;
	}

	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}

	public void set(double x, double y) {
		this.x = x; this.y = y;
	}

	public int compareTo(Object another) {
		Point p = (Point)another;
		if (!epsEquals(this.x,p.x)) return this.x < p.x ? -1 : 1;
		if (!epsEquals(this.y,p.y)) return this.y < p.y ? -1 : 1;
		return 0;
	}

	public boolean equals(Point p) {
		return epsEquals(this.x,p.x) && epsEquals(this.y,p.y);
	}

	public Point clone() {
		return new Point(this.x, this.y);
	}

	public String toString() {
		return "("+x+","+y+")";
	}
}

class Vector extends EuclideanSpace implements Comparable {

	private double x, y;
	public Vector(double x, double y) {
		this.x = x; this.y = y;
	}
	public Vector(Point target, Point source) {
		this.x = target.getX() - source.getX();
		this.y = target.getY() - source.getY();
	}
	public Vector(double tx, double ty, double sx, double sy) {
		this.x = tx - sx;
		this.y = ty - sy;
	}

	public static double dot(Vector a, Vector b) { return a.getX()*b.getX() + a.getY()*b.getY(); }
	public static double cross(Vector a, Vector b) { return a.getX()*b.getY() - a.getY()*b.getX(); }

	public double norm() { return x*x + y*y; }
	public double length() { return Math.sqrt(this.norm()); }

	public Vector plus(Point p) { return new Vector(this.x + p.getX(), this.y + p.getY()); }
	public Vector scalarMul(double c) { return new Vector(c*this.x, c*this.y); }

	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}

	public void set(double x, double y) {
		this.x = x; this.y = y;
	}

	public int compareTo(Object other) {
		Vector p = (Vector)other;
		if (!epsEquals(this.x,p.x)) return this.x < p.x ? -1 : 1;
		if (!epsEquals(this.y,p.y)) return this.y < p.y ? -1 : 1;
		return 0;
	}

	public boolean equals(Vector p) {
		return epsEquals(this.x,p.x) && epsEquals(this.y,p.y);
	}

	public Point toPoint() {
		return new Point(this.x, this.y);
	}

	public String toString() {
		return "("+x+","+y+")";
	}
}

class Line extends EuclideanSpace implements Cloneable {

	private final Point p1, p2;

	public Line(double x1, double y1, double x2, double y2) {
		this.p1 = new Point(x1,y1);
		this.p2 = new Point(x2,y2);
	}
	public Line(Point p1, Point p2) {
		this.p1 = p1.clone();
		this.p2 = p2.clone();
	}

	public double getX1() {
		return p1.getX();
	}
	public double getY1() {
		return p1.getY();
	}
	public double getX2() {
		return p2.getX();
	}
	public double getY2() {
		return p2.getY();
	}

	public Point getP1() {
		return p1.clone();
	}
	public Point getP2() {
		return p2.clone();
	}

	public Line clone() {
		return new Line(this.p1, this.p2);
	}

	public String toString() {
		return "[("+p1.getX()+","+p1.getY()+"),("+p2.getX()+","+p2.getY()+")]";
	}
}