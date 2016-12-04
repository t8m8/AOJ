import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2619 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int[][] directedGraph(int n, int[] from, int[] to) {
		int[] cnt = new int[n];
		for (int i : from) cnt[i]++;

		int[][] g = new int[n][];
		for (int i=0; i<n; i++) g[i] = new int[cnt[i]];
		for (int i=0; i<from.length; i++) {
			int s = from[i];
			int t = to[i];
			g[s][--cnt[s]] = t;
		}

		return g;
	}

	static int[][] g;
	static String[] s;

	static void rec(int cur, int d) {
		for (int i=0; i<d; i++) out.print(".");
		out.println(s[cur]);
		for (int i=g[cur].length-1; i>=0; i--) {
			rec(g[cur][i], d+1);
		}
	}

	static void solve() {
		int n = in.nextInt();

		s = new String[n];
		int[] a = new int[n-1];
		int[] b = new int[n-1];
		for (int i=0; i<n; i++) {
			int k = in.nextInt() - 1;
			s[i] = in.next();
			if (k == -1) continue;
			a[i-1] = k;
			b[i-1] = i;
		}

		g = directedGraph(n, a, b);
		rec(0, 0);
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