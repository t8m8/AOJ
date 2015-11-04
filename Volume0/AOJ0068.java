import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0068 extends EuclideanSpace {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static int[] requireConvexHull(final Point[] ps) {
		int n = ps.length;
		if (n < 3) return null;
		Integer[] idx = new Integer[n];
		for (int i=0; i<n; i++) idx[i] = i;
		Arrays.sort(idx,new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				return ps[a].compareTo(ps[b]);
			}
		});

		int[] res = new int[n*2];
		int ptr = 0;
		//lower hull
		for (int i=0; i<n; i++) {
			if (ptr > 0
				&& epsEquals(ps[res[ptr-1]].getX(), ps[idx[i]].getX())
				&& epsEquals(ps[res[ptr-1]].getY(), ps[idx[i]].getY())) continue;
			while (ptr > 1
				&& -Line2D.relativeCCW(ps[res[ptr-2]].getX(), ps[res[ptr-2]].getY(),
					ps[idx[i]].getX(), ps[idx[i]].getY(),
					ps[res[ptr-1]].getX(), ps[res[ptr-1]].getY()) > 0) ptr--;
			res[ptr++] = idx[i];
		}

		int end = ptr;
		//upper hull
		for (int i=n-2; i>=0; i--) {
			if (epsEquals(ps[res[ptr-1]].getX(), ps[idx[i]].getX())
				&& epsEquals(ps[res[ptr-1]].getY(), ps[idx[i]].getY())) continue;
			while (ptr > end
				&& -Line2D.relativeCCW(ps[res[ptr-2]].getX(), ps[res[ptr-2]].getY(),
					ps[idx[i]].getX(), ps[idx[i]].getY(),
					ps[res[ptr-1]].getX(), ps[res[ptr-1]].getY()) > 0) ptr--;
			res[ptr++] = idx[i];
		}

		return Arrays.copyOf(res,ptr-1);
	}

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		Point[] ps = new Point[n];
		for (int i=0; i<n; i++) {
			String[] s = in.next().split(",");
			ps[i] = new Point(Double.parseDouble(s[0]), Double.parseDouble(s[1]));
		}

		int[] res = requireConvexHull(ps);
		out.println(n-res.length);

		return true;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(solve());
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
