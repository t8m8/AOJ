import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0201 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int[][] g;
	static int[] p, dp;

	static int[][] directedGraph(int n, ArrayList<Integer> from, ArrayList<Integer> to) {
		int[] cnt = new int[n];
		for (int i : from) cnt[i]++;

		int[][] g = new int[n][];
		for (int i=0; i<n; i++) g[i] = new int[cnt[i]];
		for (int i=0; i<from.size(); i++) {
			int s = from.get(i);
			int t = to.get(i);
			g[s][--cnt[s]] = t;
		}

		return g;
	}

	static int rec(int cur) {
		if (dp[cur] != -1) return dp[cur];
		if (g[cur].length == 0) {
			return dp[cur] = p[cur];
		}
		int sum = 0;
		for (int to : g[cur]) {
			sum += rec(to);
		}
		return dp[cur] = Math.min(p[cur], sum);
	}

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		String[] s = new String[n];
		p = new int[n];

		HashMap<String,Integer> map = new HashMap<>();

		for (int i=0; i<n; i++) {
			s[i] = in.next();
			p[i] = in.nextInt();
			map.put(s[i], i);
		}

		ArrayList<Integer> from = new ArrayList<>();
		ArrayList<Integer> to = new ArrayList<>();
		int m = in.nextInt();

		for (int i=0; i<m; i++) {
			String name = in.next();
			int idx = map.get(name);
			int k = in.nextInt();
			for (int j=0; j<k; j++) {
				from.add(idx);
				to.add(map.get(in.next()));
			}
		}

		g = directedGraph(n, from, to);
		dp = new int[n];
		Arrays.fill(dp, -1);

		out.println(rec(map.get(in.next())));

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