import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0107 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	public static double area(double a, double b, double c) {
		double s = (a + b + c)/2;
		return Math.sqrt(s*(s - a)*(s - b)*(s - c));
	}

	static boolean solve() {
		int x = in.nextInt();
		int y = in.nextInt();
		int z = in.nextInt();
		if (x + y + z == 0) return false;
		int n = in.nextInt();

		if (x < y) {
			int t = x; x = y; y = t;
		}
		if (x < z) {
			int t = x; x = z; z = t;
		}

		while (n-- > 0) {
			int r = in.nextInt()*2;
			out.println(r > Math.sqrt(y*y + z*z) ? "OK" : "NA");
		}

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.currentTimeMillis();

		while(solve());
		out.flush();

		long end = System.currentTimeMillis();
		dump((end-start) + "ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}