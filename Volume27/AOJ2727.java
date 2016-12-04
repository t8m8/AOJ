import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2727 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean f(String s, String t, String x) {
		boolean f = true;
		int pos = 0;
		int n = s.length(), m = t.length();
		for (int i=0, j=0; i<n || j<m;) {
			if (f) {
				while (i < n) if (s.charAt(i++) == x.charAt(pos)) {
					pos++;
					f = !f;
					break;
				}
				if (f) break;
			} else {
				while (j < m) if (t.charAt(j++) == x.charAt(pos)) {
					pos++;
					f = !f;
					break;
				}
				if (!f) break;
			}
			if (pos == x.length()) return true;
		}

		return false;
	}

	static void solve() {
		String s = in.next();
		String t = in.next();
		out.println(f(s, t, s) || f(t, s, s) ? "Yes" : "No");
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