import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2155 implements Runnable {

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

	static int[][][] g;
	static boolean[] f;

	static void rec(int cur, int time) {
		f[cur] = true;
		for (int[] to : g[cur]) {
			if (to[1] <= time) continue;
			rec(to[0], to[1]);
		}
	}

	static boolean solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		if (n + m == 0) return false;

		int[] s = new int[m];
		int[] t = new int[m];
		int[] c = new int[m];
		for (int i=0; i<m; i++) {
			c[i] = in.nextInt();
			s[i] = in.nextInt() - 1;
			t[i] = in.nextInt() - 1;
		}

		g = directedGraph(n, s, t, c);
		f = new boolean[n];
		rec(0, -1);
		int ans = 0;
		for (int i=0; i<n; i++) {
			if (f[i]) ans++;
		}
		out.println(ans);

		return true;
	}


	public void run() {
		while(solve());

		out.flush();
		in.close();
		out.close();
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		new Thread(null, new AOJ2155(), "", 16 * 1024 * 1024).start();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}