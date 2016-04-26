import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0079 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		ArrayList<Point> list = new ArrayList<Point>();
		int n = 0;
		while (in.hasNext()) {
			n++;
			String[] s = in.next().split(",");
			list.add(new Point(Double.parseDouble(s[0]), Double.parseDouble(s[1])));
		}

		Point[] poly = list.toArray(new Point[n]);
		out.println(requireAreaOfPolygon(poly));
	}

	static double requireAreaOfPolygon(Point[] poly) {
    	int n = poly.length;
    	double res = 0;
    	for (int i=0; i<n; i++) {
    		res += (poly[i].getX() - poly[(i+1)%n].getX())*(poly[(i+1)%n].getY() + poly[i].getY());
    	}
    	return Math.abs(res/2);
    }

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		solve();
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