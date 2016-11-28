import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1600 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int m = in.nextInt();
		int min = in.nextInt();
		int max = in.nextInt();
		if (m + min + max == 0) return false;
		int[] p = new int[m];
		for (int i=0; i<m; i++) {
			p[i] = in.nextInt();
		}

		Arrays.sort(p);

		int md = 0, ans = 0;
		for (int i=m-max; i<=m-min; i++) {
			if (md < p[i] - p[i-1]) {
				ans = m - i;
				md = p[i] - p[i-1];
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