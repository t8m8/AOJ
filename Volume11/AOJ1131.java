import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1131 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int dfs(int p, int q, int a, int n, int low, int pr) {
		if (p == 0) return 1;
		int res = 0;
		for (int i=low; i*pr<=a; i++) {
			if (i*p > n*q) break;
			if (i*p >= q) {
				res += dfs(i*p - q, i*q, a, n-1, i, pr*i);
			}
		}
		return res;
	}

	static boolean solve() {
		int p = in.nextInt();
		int q = in.nextInt();
		int a = in.nextInt();
		int n = in.nextInt();
		if (p + q + a + n == 0) return false;

		out.println(dfs(p, q, a, n, 1, 1));

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