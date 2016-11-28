import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2399 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		boolean[][] f = new boolean[n][n];

		for (int i=0; i<n; i++) {
			int m = in.nextInt();
			for (int j=0; j<m; j++) {
				f[i][in.nextInt()-1] = true;
			}
		}

		int k = in.nextInt();
		int[] l = new int[k];
		for (int i=0; i<k; i++) {
			l[i] = in.nextInt() - 1;
		}
		Arrays.sort(l);

		int ans = -1;
		for (int i=0; i<n; i++) {
			boolean ff = true;
			for (int j=0; j<k; j++) {
				ff = ff && f[i][l[j]];
			}
			if (ff) {
				if (ans != -1) {
					out.println("-1");
					return true;
				}
				ans = i + 1;
			}
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