import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2019 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		if (n + m == 0) return false;

		int[][] p = new int[n][2];
		for (int i=0; i<n; i++) {
			for (int j=0; j<2; j++) {
				p[i][j] = in.nextInt();
			}
		}

		Arrays.sort(p, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				return b[1] - a[1];
			}
		});

		int ans = 0;
		for (int i=0; i<n; i++) {
			int min = Math.min(Math.max(0, m), p[i][0]);
			ans += (p[i][0] - min)*p[i][1];
			m -= min;
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