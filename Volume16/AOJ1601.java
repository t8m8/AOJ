import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1601 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static String[] s;
	static int[] m = {5, 7, 5, 7, 7};

	static boolean f(int off) {
		int pos = off;
		int idx = 0, cur = 0;
		while (true) {
			cur += s[pos].length();
			if (m[idx] < cur) return false;
			if (m[idx] == cur) {
				idx++;
				cur = 0;
			}
			if (idx == 5) {
				return true;
			}
			pos++;
		}
	}

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		s = new String[n];

		for (int i=0; i<n; i++) {
			s[i] = in.next();
		}

		for (int i=0; i<n; i++) {
			if (f(i)) {
				out.println((i+1));
				return true;
			}
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