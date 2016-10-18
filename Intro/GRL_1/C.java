import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class C {

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

	static int[][] floydWarshall(int[][][] g) {
		int n = g.length;
		int[][] d = new int[n][n];

		final int INF = (1<<31)-1;
		for (int i=0; i<n; i++) {
			Arrays.fill(d[i], INF);
			d[i][i] = 0;
		}

		for (int cur=0; cur<n; cur++) {
			for (int[] to : g[cur]) {
				int next = to[0];
				d[cur][next] = Math.min(d[cur][next], to[1]);
			}
		}

		for (int k=0; k<n; k++)
			for (int i=0; i<n; i++) if (d[i][k] != INF)
				for (int j=0; j<n; j++) if (d[k][j] != INF)
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);

		for (int i=0; i<n; i++) {
			if (d[i][i] < 0) {
				return null; // negative cycle
			}
		}

		return d;
	}


	static void solve() {
		int v = in.nextInt();
		int e = in.nextInt();
		int[] s = new int[e];
		int[] t = new int[e];
		int[] d = new int[e];
		for (int i=0; i<e; i++) {
			s[i] = in.nextInt();
			t[i] = in.nextInt();
			d[i] = in.nextInt();
		}
		int[][][] g = directedGraph(v, s, t, d);
		int[][] ans = floydWarshall(g);
		if (ans == null) {
			out.println("NEGATIVE CYCLE");
			return;
		}
		for (int i=0; i<v; i++) {
			for (int j=0; j<v-1; j++) {
				out.print((ans[i][j] == (1<<31)-1 ? "INF" : ans[i][j])+" ");
			}
			out.println(ans[i][v-1] == (1<<31)-1 ? "INF" : ans[i][v-1]);
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