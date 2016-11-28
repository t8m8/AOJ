import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2007 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;
	static boolean f = true;
	static int[] v = {10, 50, 100, 500};

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		int[] c = new int[4];
		int all = 0;
		for (int i=0; i<4; i++) {
			c[i] = in.nextInt();
			all += v[i]*c[i];
		}

		int r = all - n;
		int[] cnt = new int[4];
		for (int i=3; i>=0; i--) {
			cnt[i] = r/v[i];
			r = r%v[i];
		}


		if (!f) out.println();
		for (int i=0; i<4; i++) {
			if (c[i] - cnt[i] > 0) {
				out.println(v[i]+" "+(c[i] - cnt[i]));
			}
		}

		f = false;
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