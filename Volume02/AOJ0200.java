import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0200 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int[][][] undirectedGraph(int n, int[] v1, int[] v2, int[] cost) {
		int[] cnt = new int[n];
		for (int i : v1) cnt[i]++;
		for (int i : v2) cnt[i]++;

		int[][][] g = new int[n][][];
		for (int i=0; i<n; i++) g[i] = new int[cnt[i]][2];
		for (int i=0; i<v1.length; i++) {
			int s = v1[i];
			int t = v2[i];

			g[s][--cnt[s]][0] = t;
			g[s][cnt[s]][1] = cost[i];

			g[t][--cnt[t]][0] = s;
			g[t][cnt[t]][1] = cost[i];
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

	static boolean solve() {
		int m = in.nextInt();
		int n = in.nextInt();
		if (n + m == 0) return false;

		int[] s = new int[m];
		int[] t = new int[m];
		int[] time = new int[m];
		int[] cost = new int[m];
		for (int i=0; i<m; i++) {
			s[i] = in.nextInt() - 1;
			t[i] = in.nextInt() - 1;
			cost[i] = in.nextInt();
			time[i] = in.nextInt();
		}

		int[][][] gc = undirectedGraph(n, s, t, cost);
		int[][][] gt = undirectedGraph(n, s, t, time);

		int k = in.nextInt();
		while (k-- > 0) {
			int p = in.nextInt() - 1;
			int q = in.nextInt() - 1;
			int r = in.nextInt();
			if (r == 0) {
				int[] d = dijkstra(gc, p);
				out.println(d[q]);
			} else {
				int[] d = dijkstra(gt, p);
				out.println(d[q]);
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