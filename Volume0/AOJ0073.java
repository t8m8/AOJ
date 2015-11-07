import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0073 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		double x = in.nextInt();
		double h = in.nextInt();
		if (x + h == 0) return false;

		double l = Math.sqrt((x/2)*(x/2) + h*h);
		double s = x*x + x*l/2*4;

		out.println(s);
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