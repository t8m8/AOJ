import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2739 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		int t = in.nextInt();
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}
		boolean[] f = new boolean[t*2];
		for (int i=0; i<n; i++) {
			for (int j=a[i]-m; j<a[i]+m; j++) {
				f[j] = true;
			}
		}
		int ans = 0;
		for (int i=0; i<t; i++) {
			if (!f[i]) ans++;
		}
		dump(f);
		out.println(ans);
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