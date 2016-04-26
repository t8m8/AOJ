import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0108 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int[] next(int[] a) {
		int n = a.length;
		int[] cnt = new int[10000];
		for (int i=0; i<n; i++) {
			cnt[a[i]]++;
		}
		int[] res = new int[n];
		for (int i=0; i<n; i++) {
			res[i] = cnt[a[i]];
		}
		return res;
	}

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}

		int cnt = 0;
		while (true) {
			int[] b = next(a);
			boolean f = true;
			for (int i=0; i<n; i++) {
				if (a[i] != b[i]) f = false;
			}
			if (f) {
				out.println(cnt);
				for (int i=0; i<n-1; i++) {
					out.print(a[i] + " ");
				}
				out.println(a[n-1]);
				break;
			}
			a = b;
			cnt++;
		}

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.currentTimeMillis();

		while(solve());
		out.flush();

		long end = System.currentTimeMillis();
		dump((end-start) + "ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}