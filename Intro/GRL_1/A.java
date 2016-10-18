import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class A {

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

	static int[] dijkstra(int[][][] g, int source) {
		int n = g.length;

		final int[] d = new int[n];
		Arrays.fill(d, 1<<30);
		d[source] = 0;

		TreeSet<Integer> pQ = new TreeSet<Integer>(new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				if (d[a] != d[b]) return d[a] - d[b];
				return a - b;
			}
		});
		pQ.add(source);

		while (!pQ.isEmpty()) {
			int cur = pQ.pollFirst();

			for (int i=0; i<g[cur].length; i++) {
				int next = g[cur][i][0];
				int dist = d[cur] + g[cur][i][1];
				if (dist < d[next]) {
					pQ.remove(next);
					d[next] = dist;
					pQ.add(next);
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
		int[] ans = dijkstra(g, r);
		for (int i=0; i<v; i++) {
			out.println(ans[i] == 1<<30 ? "INF" : ans[i]);
		}
		// dump(ans);
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