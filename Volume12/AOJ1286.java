import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1286 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static double[][] dp;

	static double rec(int x, int n, int m) {
		if (dp[x][n] != -1) return dp[x][n];
		if (n == 0) {
			if (x == 0) return dp[x][n] = 1;
			else return dp[x][n] = 0;
		}
		double res = 0;
		for (int i=1; i<=m; i++) {
			if (x - i >= 0)
				res += rec(x - i, n-1, m)/m;
		}
		return dp[x][n] = res;
	}

	static boolean solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		if (n + m + k == 0) return false;

		dp = new double[n*m+1][n+1];
		for (int i=0; i<n*m+1; i++) {
			Arrays.fill(dp[i], -1);
		}

		double ans = 0;
		for (int i=1; i<=n*m; i++) {
			ans += Math.max(1, i-k)*rec(i, n, m);
		}
		out.printf("%.10f\n",ans);

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