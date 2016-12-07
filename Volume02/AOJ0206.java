import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0206 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int l = in.nextInt();
		if (l == 0) return false;

		int x = 0;
		boolean f = false;

		for (int i=0; i<12; i++) {
			int m = in.nextInt();
			int n = in.nextInt();
			x += (m - n);
			if (!f && x >= l) {
				out.println((i+1));
				f = true;
			}
		}

		if (!f) {
			out.println("NA");
		}

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