import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0080 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		double q = in.nextInt();
		if (q == -1) return false;
		double x = q/2;
		while (Math.abs(x*x*x-q) >= 0.00001*q) {
			x = x - (x*x*x-q)/(3*x*x);
		}
		out.printf("%.8f\n",x);
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