import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0012 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	public static final double EPS = 1E-9;
	public static boolean epsEquals(double a, double b) { return Math.abs(a-b) < EPS; };

	static void solve() {

		Point[] poly = new Point[3];
		for (int i=0; i<3; i++) {
			poly[i] = new Point(in.nextDouble(),in.nextDouble());
		}

		poly = convexSort(poly);
		// trace(poly);

		out.println(contains(poly, new Point(in.nextDouble(),in.nextDouble())) == 2 ? "YES" : "NO");
	}

	static Point[] convexSort(Point[] poly) {

		int n = poly.length;
		double aveX = 0, aveY = 0;

		for (int i=0; i<n; i++) {
			aveX += poly[i].getX();
			aveY += poly[i].getY();
		}
		aveX /= n;
		aveY /= n;

		final double[] rad = new double[n];
		for (int i=0; i<n; i++) {
			rad[i] = Math.atan2(poly[i].getY()-aveY,poly[i].getX()-aveX);
		}

		Integer[] ord = new Integer[n];
		for (int i=0; i<n; i++) {
			ord[i] = i;
		}

		Arrays.sort(ord, new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				return Double.compare(rad[a],rad[b]);
			}
		});

		Point[] res = new Point[n];
		for (int i=0; i<n; i++) {
			res[i] = poly[ord[i]];
		}
		return res;
	}

	static int contains(Point[] poly, Point p) {

		int n = poly.length;
		boolean flag = false;

		for (int i=0; i<n; i++) {
			Vector a = new Vector(poly[i], p);
			Vector b = new Vector(poly[(i+1)%n], p);

			if (Math.abs(Vector.cross(a,b)) < EPS && Vector.dot(a,b) < EPS) return 1;

			if (a.getY() < b.getY()) {
				if (a.getY() < EPS && EPS < b.getY() && Vector.cross(a,b) > EPS) flag = !flag;
			} else {
				if (b.getY() < EPS && EPS < a.getY() && Vector.cross(b,a) > EPS) flag = !flag;
			}
		}

		return flag ? 2 : 0;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(in.hasNext()) solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}

	static class Vector implements Comparable {

		private double x, y;
		public Vector(double x, double y) {
			this.x = x; this.y = y;
		}
		public Vector(Point target, Point source) {
			this.x = target.getX() - source.getX();
			this.y = target.getY() - source.getY();
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
}