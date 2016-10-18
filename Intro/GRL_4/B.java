import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class B {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int[] kahn(int[][][] g) {
		int n = g.length, pos = 0;
		int[] res = new int[n];
		int[] in = new int[n];
		for (int cur=0; cur<n; cur++) {
			for (int[] to : g[cur]) {
				in[to[0]]++;
			}
		}

		ArrayDeque<Integer> que = new ArrayDeque<>();
		for (int i=0; i<n; i++) {
			if (in[i] == 0) {
				que.add(i);
			}
		}
		while (!que.isEmpty()) {
			int cur = que.pollFirst();
			res[pos++] = cur;
			for (int[] to : g[cur]) {
				if (--in[to[0]] == 0) {
					que.add(to[0]);
				}
			}
		}

		int max = -1;
		for (int i=0; i<n; i++) {
			max = Math.max(max, in[i]);
		}

		return max == 0 ? res : null;
	}

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

	static void solve() {
		int v = in.nextInt();
		int e = in.nextInt();
		int[] s = new int[e];
		int[] t = new int[e];
		int[] c = new int[e];
		for (int i=0; i<e; i++) {
			s[i] = in.nextInt();
			t[i] = in.nextInt();
			c[i] = 0;
		}
		int[][][] g = directedGraph(v, s, t, c);

		int[] tp = kahn(g);
		for (int i=0; i<v; i++) {
			out.println(tp[i]);
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