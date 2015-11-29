import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0094 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		double a = in.nextDouble();
		double b = in.nextDouble();
		double r = 3.305785;

		out.println(a*b/r);
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