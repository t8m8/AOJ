import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2331 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		int n = in.nextInt();
		int[] a = new int[100010];
		a[0] = 1;
		for (int i=0; i<n; i++) {
			int s = in.nextInt();
			int t = in.nextInt();
			a[s] += 1;
			a[t+1] -= 1;
		}

		int max = 0;

		for (int i=1; i<a.length; i++) {
			a[i] += a[i-1];
			if (i <= a[i]) max = i;
		}

		out.println(max-1);
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