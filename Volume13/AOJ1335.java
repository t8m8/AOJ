import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1335 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int[][][] dp;

	static boolean solve() {
		int N = in.nextInt();
		int K = in.nextInt();
		int S = in.nextInt();
		if (N + K + S == 0) return false;

		dp = new int[11][30][200];
		dp[0][0][0] = 1;

		for (int i=0; i<10; i++) {
			for (int j=0; j<30; j++) {
				for (int k=0; k<200; k++) {
					for (int l=j+1; l<=N; l++) {
						if (k+l < 200)
							dp[i+1][l][k+l] += dp[i][j][k];
					}
				}
			}
		}

		int ans = 0;
		for (int j=1; j<=N; j++) {
			ans += dp[K][j][S];
		}
		out.println(ans);

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