import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class B {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int primalDual(int[][][] cost, int[][][] capacity, int source, int sink, int f) {
		int n = cost.length;

		int[][] flow = new int[n][];
		for (int i=0; i<n; i++)
			flow[i] = new int[cost[i].length];

		int[][][] rev = new int[n][][];

		int[] cnt = new int[n];
		for (int i=0; i<n; i++)
			for (int j=0; j<cost[i].length; j++)
				cnt[cost[i][j][0]]++;
		for (int i=0; i<n; i++) rev[i] = new int[cnt[i]][2];
		for (int i=n-1; i>=0; i--) {
			for (int j=0; j<cost[i].length; j++) {
				int ptr = --cnt[cost[i][j][0]];
				rev[cost[i][j][0]][ptr][0] = i;
				rev[cost[i][j][0]][ptr][1] = j;
			}
		}

		int mincost = 0;
		int[] h = new int[n];

		final int[] d = new int[n];
		TreeSet<Integer> que = new TreeSet<Integer>(new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				if (d[a] != d[b]) return  d[a] - d[b];
				return a - b;
			}
		});

		while (f > 0) {
			int[] prev = new int[n];
			int[] myidx = new int[n];
			Arrays.fill(prev,-1); Arrays.fill(d,Integer.MAX_VALUE/2);
			d[source] = 0;
			que.add(source);

			while (!que.isEmpty()) {
				int cur = que.pollFirst();
				for (int i=0; i<cost[cur].length; i++) {
					int to = cost[cur][i][0];
					if (capacity[cur][i][1] - flow[cur][i] > 0) {
						int c = d[cur] + cost[cur][i][1] + h[cur] - h[to];
						if (d[to] > c) {
							que.remove(to);
							d[to] = c;
							prev[to] = cur;
							myidx[to] = i;
							que.add(to);
						}
					}
				}

				for (int i=0; i<rev[cur].length; i++) {
					int to = rev[cur][i][0];
					int ridx = rev[cur][i][1];
					if (flow[to][ridx] > 0) {
						int c = d[cur] - cost[to][ridx][1] + h[cur] - h[to];
						if (d[to] > c) {
							que.remove(to);
							d[to] = c;
							prev[to] = cur;
							myidx[to] = ~ridx;
							que.add(to);
						}
					}
				}
			}

			if (prev[sink] == -1) break;

			int flowlimit = f;
			int sumcost = 0;
			for (int i=sink; i!=source; i=prev[i]) {
				if (myidx[i] >= 0) {
					flowlimit = Math.min(flowlimit, capacity[prev[i]][myidx[i]][1] - flow[prev[i]][myidx[i]]);
					sumcost += cost[prev[i]][myidx[i]][1];
				}else {
					int idx = ~myidx[i];
					flowlimit = Math.min(flowlimit,flow[i][idx]);
					sumcost -= cost[i][idx][1];
				}
			}

			mincost += flowlimit*sumcost;
			for (int i=sink; i!=source; i=prev[i]) {
				if (myidx[i] >= 0) {
					flow[prev[i]][myidx[i]] += flowlimit;
				}else {
					int idx = ~myidx[i];
					flow[i][idx] -= flowlimit;
				}
			}

			f -= flowlimit;
			for (int i=0; i<n; i++) h[i] += d[i];
		}

		return f > 0 ? -1 : mincost;
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
		int f = in.nextInt();
		int[] s = new int[e];
		int[] t = new int[e];
		int[] c = new int[e];
		int[] d = new int[e];
		for (int i=0; i<e; i++) {
			s[i] = in.nextInt();
			t[i] = in.nextInt();
			c[i] = in.nextInt();
			d[i] = in.nextInt();
		}
		int[][][] cost = directedGraph(v, s, t, d);
		int[][][] capacity = directedGraph(v, s, t, c);
		out.println(primalDual(cost, capacity, 0, v-1, f));
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