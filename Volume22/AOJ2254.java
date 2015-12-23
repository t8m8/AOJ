import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2254 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		int[][] t = new int[n][n+1];
		for (int i=0; i<n; i++) {
			for (int j=0; j<=n; j++) {
				t[i][j] = in.nextInt();
			}
		}

		// trace(t);

		int[] dp = new int[1<<n];
		Arrays.fill(dp,Integer.MAX_VALUE/2);
		dp[0] = 0;

		// trace(dp);

		for (int i=0; i<n; i++) {
			for (int j=0; j<1<<n; j++) {
				if (Integer.bitCount(j) != i) continue;
				if (dp[j] == Integer.MAX_VALUE/2) continue;

				for (int k=0; k<n; k++) {
					if ((j>>k&1) == 1) continue;
					int d = t[k][0];
					for (int l=0; l<n; l++) {
						if ((j>>l&1) == 1) {
							d = Math.min(d,t[k][l+1]);
						}
					}
					dp[(j|1<<k)] = Math.min(dp[(j|1<<k)],dp[j] + d);
				}
			}
		}

		// trace(dp);

		out.println(dp[(1<<n)-1]);

		return true;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(solve());
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}