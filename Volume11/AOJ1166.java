import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1166 {

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

	static int h, w;

	static int n(int i, int j) {
		return i*w+j;
	}

	static boolean solve() {
		w = in.nextInt();
		h = in.nextInt();
		if (w + h == 0) return false;

		int n = w*h;
		ArrayList<Integer> s = new ArrayList<>();
		ArrayList<Integer> t = new ArrayList<>();
		for (int k=0; k<2*h-1; k++) {
			int i = k/2;
			if (k%2 == 0) {
				for (int j=0; j<w-1; j++) {
					int x = in.nextInt();
					if (x == 0) {
						s.add(n(i,j));
						t.add(n(i,(j+1)));
					}
				}
			} else {
				for (int j=0; j<w; j++) {
					int x = in.nextInt();
					if (x == 0) {
						s.add(n(i,j));
						t.add(n((i+1),j));
					}
				}
			}
		}

		int m = s.size();
		int[] ss = new int[m];
		int[] tt = new int[m];
		int[] cc = new int[m];
		for (int i=0; i<m; i++) {
			ss[i] = s.get(i);
			tt[i] = t.get(i);
			cc[i] = 1;
		}

		int[][][] g = undirectedGraph(n, ss, tt, cc);

		int[] d = dijkstra(g, 0);
		dump(d);
		out.println(d[n-1] == 1<<30 ? "0" : (d[n-1]+1));

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