import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class A {

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

	static int doubleSweep(int[][][] g) {
		int n = g.length;
		int[] d = new int[n];

		bfsDoubleSweep(g,d,0);
		int max = 0;
		int t = 0;
		for (int i=0; i<n; i++) {
			if (d[i] == 1<<29) continue;
			if (max < d[i]) {
				max = d[i];
				t = i;
			}
		}

		bfsDoubleSweep(g,d,t);
		max = 0;
		for (int i=0; i<n; i++) {
			if (d[i] == 1<<29) continue;
			if (max < d[i]) max = d[i];
		}

		return max;
	}

	static void bfsDoubleSweep(int[][][] g, int[] d, int s) {
		Arrays.fill(d, 1<<29);
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		que.add(s);
		d[s] = 0;
		while (!que.isEmpty()) {
			int cur = que.pollFirst();
			for (int[] to : g[cur]) {
				if (d[to[0]] == 1<<29) {
					d[to[0]] = d[cur] + to[1];
					que.add(to[0]);
				}
			}
		}
	}

	static void solve() {
		int n = in.nextInt();
		int[] s = new int[n-1];
		int[] t = new int[n-1];
		int[] w = new int[n-1];
		for (int i=0; i<n-1; i++) {
			s[i] = in.nextInt();
			t[i] = in.nextInt();
			w[i] = in.nextInt();
		}
		int[][][] g = undirectedGraph(n, s, t, w);
		out.println(doubleSweep(g));
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