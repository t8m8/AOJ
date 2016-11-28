import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2012 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		long e = in.nextInt();
		if (e == 0) return false;

		long min = 1<<30;

		for (long y=0; y*y<=e; y++) {
			for (long z=0; y*y+z*z*z<=e; z++) {
				long x = e - y*y - z*z*z;
				min = Math.min(min, x + y + z);
			}
		}

		out.println(min);

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		while(solve());
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}