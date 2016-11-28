import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2738 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		int n = in.nextInt();
		int p = 0;
		for (int i=0; i<n; i++) {
			String s = in.next();
			if ("A".equals(s)) {
				p++;
			} else {
				p--;
			}

			if (p < 0) {
				out.println("NO");
				return;
			}
		}

		if (p == 0) {
			out.println("YES");
		} else {
			out.println("NO");
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