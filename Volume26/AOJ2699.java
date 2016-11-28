import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2699 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int d = in.nextInt();
		int e = in.nextInt();
		if (d + e == 0) return false;

		double min = 1<<29;
		for (int i=0; i<=d; i++) {
			int j = d - i;
			min = Math.min(min, Math.abs(e - Math.sqrt(i*i + j*j)));
		}

		out.printf("%.5f\n", min);

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