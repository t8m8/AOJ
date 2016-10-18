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

	static int dinic(int[][][] g, int source, int sink) {
		int n = g.length;
		int[] cnt = new int[n];

		for (int i=0; i<n; i++)
			for (int[] link : g[i])
				cnt[link[0]]++;

		int[][] rev = new int[n][];
		for (int i=0; i<n; i++) rev[i] = new int[cnt[i]];
		for (int i=n-1; i>=0; i--)
			for (int[] link : g[i])
				rev[link[0]][--cnt[link[0]]] = i;

		int[][] flow = new int[n][n];
		int[] level = new int[n];
		int[] path = new int[n];
		int res = 0;

		while (true) {
			Arrays.fill(level,-1);
			path[0] = source;
			int ptr = 1;
			level[source] = 0;

			for (int i=0; i<ptr; i++) {
				int cur = path[i];

				for (int[] link : g[cur]) {
					int next = link[0], cap = link[1];
					if (level[next] == -1 && cap - flow[cur][next] > 0) {
						path[ptr++] = next;
						level[next] = level[cur] + 1;
					}
				}

				for (int next : rev[cur]) {
					if (level[next] == -1 && -flow[cur][next] > 0) {
						path[ptr++] = next;
						level[next] = level[cur] + 1;
					}
				}
			}

			if (level[sink] == -1) break;
			int f = 0;
			while ((f = dfsDinic(g,level,rev,flow,source,sink,Integer.MAX_VALUE/2)) > 0)
				res += f;
		}

		return res;
	}

	static int dfsDinic(int[][][] g, int[] level, int[][] rev, int[][] flow, int cur, int sink, int min){
		if (cur == sink) return min;

		int left = min;

		for (int[] link : g[cur]) {
			int next = link[0], cap = link[1];
			if (level[next] == level[cur] + 1 && cap-flow[cur][next] > 0) {
				int f = dfsDinic(g,level,rev,flow,next,sink,Math.min(left, cap-flow[cur][next]));
				if (f > 0) {
					flow[cur][next] += f;
					flow[next][cur] -= f;
					left -= f;
					if (left == 0) return min;
				}
			}
		}

		for (int next : rev[cur]) {
			if (level[next] == level[cur] + 1 && -flow[cur][next] > 0) {
				int f = dfsDinic(g,level,rev,flow,next,sink,Math.min(left, -flow[cur][next]));
				if (f > 0) {
					flow[cur][next] += f;
					flow[next][cur] -= f;
					left -= f;
					if (left == 0) return min;
				}
			}
		}

		return min - left;
	}

	static void solve() {
		int a = in.nextInt();
		int b = in.nextInt();
		int v = a + b + 2;
		int e = in.nextInt();
		int[] s = new int[e+a+b];
		int[] t = new int[e+a+b];
		int[] c = new int[e+a+b];
		for (int i=0; i<e; i++) {
			s[i] = in.nextInt();
			t[i] = in.nextInt() + a;
			c[i] = 1;
		}

		int source = a + b;
		int sink = a + b + 1;
		int pos = e;
		for (int i=0; i<a; i++) {
			s[pos] = source;
			t[pos] = i;
			c[pos] = 1;
			pos++;
		}

		for (int j=0; j<b; j++) {
			s[pos] = j+a;
			t[pos] = sink;
			c[pos] = 1;
			pos++;
		}


		int[][][] g = directedGraph(v, s, t, c);

		out.println(dinic(g, source, sink));
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