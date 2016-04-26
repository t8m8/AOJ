import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0058 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	public static final double EPS = 1E-10;
	public static boolean epsEquals(double a, double b) { return Math.abs(a-b) < EPS; };

	static void solve() {
		out.println(isOrthogonal(
			new Vector(in.nextDouble(),in.nextDouble(),in.nextDouble(),in.nextDouble()),
			new Vector(in.nextDouble(),in.nextDouble(),in.nextDouble(),in.nextDouble())) ? "YES" : "NO");
	}

	static boolean isOrthogonal (Vector a, Vector b) { return epsEquals(Vector.dot(a,b),0.0); }

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(in.hasNext()) solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static class Point implements Comparable, Cloneable {

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

	static class Vector implements Comparable {

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

		public String toString() {
			return "("+x+","+y+")";
		}
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}