import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1356 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}

		boolean[] g = new boolean[10000];

		for (int i=0; i<10000; i++) {
			if (g[i]) continue;
			int d = 1;
			while (i / (int)Math.pow(10,d) != 0) d++;
			boolean f = false;
			for (int j=0; j<n; j++) {
				int p = 0, dig = 1;
				if (j+d-1 >= n) break;
				for (int k=j+d-1; k>=j; k--) {
					p += dig*a[k];
					dig *= 10;
				}
				g[p] = true;
				if (p == i) {
					f = true;
					break;
				}
			}

			if (!f) {
				out.println(i);
				return;
			}
		}
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		solve();
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}