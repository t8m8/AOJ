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

	static int[] bellmanFord(int[][][] g, int source) {
		int n = g.length;
		int[] d = new int[n];
		Arrays.fill(d, 1<<30);
		d[source] = 0;

		for (int i=0; i<n; i++) {
			for (int cur=0; cur<n; cur++) {
				for (int[] to : g[cur]) {
					if (d[to[0]] > d[cur] + to[1] && d[cur] != 1<<30) {
						d[to[0]] = d[cur] + to[1];
						if (i == n-1) return null; // negative cycle
					}
				}
			}
		}

		return d;
	}

	static void solve() {
		int v = in.nextInt();
		int e = in.nextInt();
		int r = in.nextInt();
		int[] s = new int[e];
		int[] t = new int[e];
		int[] d = new int[e];
		for (int i=0; i<e; i++) {
			s[i] = in.nextInt();
			t[i] = in.nextInt();
			d[i] = in.nextInt();
		}
		int[][][] g = directedGraph(v, s, t, d);
		int[] ans = bellmanFord(g, r);
		if (ans == null) {
			out.println("NEGATIVE CYCLE");
			return;
		}
		for (int i=0; i<v; i++) {
			out.println(ans[i] == 1<<30 ? "INF" : ans[i]);
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