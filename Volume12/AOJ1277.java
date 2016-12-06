import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1277 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int[] ls, bs;

	static int next(int x, int n) {
		if (n < x) x = n - (x - n);
		for (int i=0; i<bs.length; i++) {
			if (x == bs[i]) {
				return 0;
			}
		}

		return x;
	}

	static boolean isStop(int x, int n) {
		if (n < x) x = n - (x - n);
		for (int i=0; i<ls.length; i++) {
			if (x == ls[i]) {
				return true;
			}
		}
		return false;
	}

	static boolean solve() {
		int n = in.nextInt();
		int t = in.nextInt();
		int l = in.nextInt();
		int b = in.nextInt();
		if (n + t + l + b == 0) return false;

		ls = new int[l];
		for (int i=0; i<l; i++) {
			ls[i] = in.nextInt();
		}
		bs = new int[b];
		for (int i=0; i<b; i++) {
			bs[i] = in.nextInt();
		}

		double[][] dp = new double[t+3][n+10];
		dp[0][0] = 1.0;

		for (int k=0; k<t; k++) {
			for (int i=0; i<n; i++) {
				if (dp[k][i] == 0) continue;
				for (int j=1; j<=6; j++) {
					if (isStop(i+j,n)) {
						dp[k+2][next(i+j, n)] += dp[k][i] / 6;
					}
					else {
						dp[k+1][next(i+j, n)] += dp[k][i] / 6;
					}
				}
			}
		}

		// dump(dp);

		double ans = 0;
		for (int i=0; i<=t; i++) {
			ans += dp[i][n];
		}

		out.printf("%.10f\n", ans);

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