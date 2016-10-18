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

	static int[] kosaraju(int[][][] g, int[][][] rg) {
		int n = g.length;
		boolean[] visited = new boolean[n];
		boolean[] used = new boolean[n];
		int[] ord = new int[n];
		int pos = n-1;

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i=0; i<n; i++) {
			if (visited[i]) continue;
			stack.addLast(i);
			while (!stack.isEmpty()) {
				int cur = stack.peekLast();
				visited[cur] = true;
				boolean pushed = false;
				for (int[] to : g[cur]) {
					int next = to[0];
					if (visited[next]) continue;
					stack.addLast(next);
					pushed = true;
				}
				if (pushed) continue;

				int t = stack.pollLast();
				if (!used[t]) {
					ord[pos--] = t;
					used[t] = true;
				}
			}
		}

		int[] res = new int[n];
		Arrays.fill(res, -1);

		int cmp = 0;
		for (int i : ord) {
			if (res[i] != -1) continue;
			stack.addLast(i);
			while (!stack.isEmpty()) {
				int cur = stack.pollLast();
				res[cur] = cmp;
				for (int[] to : rg[cur]) {
					int next = to[0];
					if (res[next] == -1) stack.addLast(next);
				}
			}
			cmp++;
		}

		return res;
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
		int[][][] rg = revGraph(g);

		int[] cmp = kosaraju(g, rg);

		int q = in.nextInt();
		while (q-- > 0) {
			int a = in.nextInt();
			int b = in.nextInt();
			out.println(cmp[a] == cmp[b] ? 1 : 0);
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