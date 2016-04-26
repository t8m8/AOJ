import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0076 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		if (n == -1) return false;

		double x = 1, y = 0, r = Math.PI;
		for (int i=1; i<n; i++) {
			r -= Math.PI/2;
			x += Math.cos(r);
			y += Math.sin(r);
			r = Math.atan2(y,x) - Math.PI;
		}

		out.println(x);
		out.println(y);

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