import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2165 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		int[] a = new int[n+1];
		for (int i=0; i<n; i++) {
			a[i+1] = in.nextInt();
		}

		int[] r = new int[257];
		int[] o = new int[257];

		int ai = -1, aj = -1, ak = -1;
		double h = 1<<10;

		for (int i=0; i<=15; i++) {
			for (int j=0; j<=15; j++) {
				for (int k=0; k<=15; k++) {
					double tmp = 0;
					Arrays.fill(o, 0);
					r[0] = i;

					for (int l=1; l<=n; l++) {
						r[l] = (j*r[l-1]+k) % 256;
						o[(a[l] + r[l]) % 256] += 1;
					}

					for (int l=0; l<256; l++) {
						if (o[l] != 0)
							tmp -= (double)o[l] / n * Math.log((double)o[l] / n);
					}

					if (tmp + 1e-9 < h) {
						h = tmp;
						ai = i;
						aj = j;
						ak = k;
					}
				}
			}
		}

		out.println(ai+" "+aj+" "+ak);

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