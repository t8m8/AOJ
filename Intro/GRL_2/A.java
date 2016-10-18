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

	static int prim(int[][][] g, int r) {
		int n = g.length;
		BitSet visited = new BitSet();
		int[] d = new int[n];
		Arrays.fill(d, 1<<30);
		d[r] = 0;

		TreeSet<int[]> ts = new TreeSet<>(new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				if (a[2] != b[2]) return a[2] - b[2];
				if (a[1] != b[1]) return a[1] - b[1];
				return a[0] - a[0];
			}
		});

		int res = 0;
		ts.add(new int[]{-1, r, 0});

		while (!ts.isEmpty()) {
			int[] tmp = ts.pollFirst();
			int src = tmp[0], dst = tmp[1], cost = tmp[2];
			if (visited.get(dst)) continue;
			visited.set(dst);
			res += cost;
			for (int[] to : g[dst]) {
				if (!visited.get(to[0])) ts.add(new int[]{dst, to[0], to[1]});
			}
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
			c[i] = in.nextInt();
		}
		int[][][] g = undirectedGraph(v, s, t, c);
		out.println(prim(g, 0));
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