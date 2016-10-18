import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class B {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;


	static int[][][] directedGraph(int n, int[] from, int[] to, int[] cost) {
		int[] cnt = new int[n];
		for (int i : from) cnt[i]++;

		int[][][] g = new int[n][][];
		for (int i=0; i<n; i++) g[i] = new int[cnt[i]][2];
		for (int i=0; i<from.length; i++) {
			int s = from[i];
			int t = to[i];

			g[s][--cnt[s]][0] = t;
			g[s][cnt[s]][1] = cost[i];
		}

		return g;
	}

	static int[][][] revGraph(int[][][] g) {
		int n = g.length;
		int[] cnt = new int[n];
		for (int i=0; i<n; i++) {
			for (int[] to : g[i]) {
				cnt[to[0]]++;
			}
		}
		int[][][] rg = new int[n][][];
		for (int i=0; i<n; i++) rg[i] = new int[cnt[i]][2];
		for (int i=0; i<n; i++) {
			for (int[] to : g[i]) {
				int s = to[0];
				int t = i;
				int c = to[1];

				rg[s][--cnt[s]][0] = t;
				rg[s][cnt[s]][1] = c;
			}
		}

		return rg;
	}


	static void solve() {
		int v = in.nextInt();
		int e = in.nextInt();
		int r = in.nextInt();
		int[] s = new int[e];
		int[] t = new int[e];
		int[] w = new int[e];
		for (int i=0; i<e; i++) {
			s[i] = in.nextInt();
			t[i] = in.nextInt();
			w[i] = in.nextInt();
		}
		int[][][] g = directedGraph(v, s, t, w);
		int[][][] rg = revGraph(g);
		out.println(edmond(g, rg, r));
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