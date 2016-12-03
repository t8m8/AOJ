import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2340 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		int q = in.nextInt();
		StringBuilder s = new StringBuilder();
		long l = 0, r = 0;
		while (q-- > 0) {
			long pos = in.nextLong();
			char c = in.next().charAt(0);
			int n = in.nextInt();
			if (c == '(') {
				l += n;
			} else {
				r += n;
			}
			out.println(l == r ? "Yes" : "No");
		}
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		solve();
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}