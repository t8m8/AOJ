import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1295 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int w = in.nextInt();
		int d = in.nextInt();
		if (w + d == 0) return false;

		int[] h1 = new int[w+1];
		int[] h2 = new int[d+1];
		for (int i=0; i<w; i++) {
			h1[i] = in.nextInt();
		}
		for (int i=0; i<d; i++) {
			h2[i] = in.nextInt();
		}
		h1[w] = h2[d] = 1<<30;

		Arrays.sort(h1);
		Arrays.sort(h2);
		int pos1 = 0, pos2 = 0, ans = 0;
		while (pos1 < w || pos2 < d) {
			if (pos1 == w || h1[pos1] > h2[pos2]) {
				ans += h2[pos2];
				pos2++;
			} else if (pos2 == d || h1[pos1] < h2[pos2]) {
				ans += h1[pos1];
				pos1++;
			} else if (h1[pos1] == h2[pos2]) {
				ans += h1[pos1];
				pos1++; pos2++;
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