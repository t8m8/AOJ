import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2199 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int round(int x) {
		if (x < 0) x = 0;
		else if (255 < x) x = 255;
		return x;
	}

	static boolean solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		if (n + m == 0) return false;

		int[] c = new int[m];
		for (int i=0; i<m; i++) {
			c[i] = in.nextInt();
		}

		int[] x = new int[n];
		for (int i=0; i<n; i++) {
			x[i] = in.nextInt();
		}

		int INF = 1<<30;
		int[][] dp = new int[n+1][256];
		for (int i=0; i<=n; i++) {
			Arrays.fill(dp[i], INF);
		}
		dp[0][128] = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<256; j++) {
				if (dp[i][j] == INF) continue;

				for (int k=0; k<m; k++) {
					int y = round(j + c[k]);
					int d = x[i] - y;
					dp[i+1][y] = Math.min(dp[i+1][y], dp[i][j] + d*d);
				}
			}
		}

		int min = INF;
		for (int i=0; i<256; i++) {
			min = Math.min(min, dp[n][i]);
		}

		out.println(min);

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