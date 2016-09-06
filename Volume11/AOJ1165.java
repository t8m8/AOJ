import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1165 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		int[][] table = new int[1000][1000];
		for (int i=0; i<1000; i++) {
			Arrays.fill(table[i], -1);
		}

		table[500][500] = 0;

		int[] dx = { -1, 0, 1, 0};
		int[] dy = { 0, -1, 0, 1};

		for (int k=1; k<n; k++) {
			int p = in.nextInt();
			int d = in.nextInt();

			for (int i=0; i<1000; i++) {
				for (int j=0; j<1000; j++) {
					if (table[i][j] == p) {
						table[i+dy[d]][j+dx[d]] = k;
					}
				}
			}
		}

		int yd = -1, yt = -1;
		int xd = -1, xt = -1;

		for (int i=0; i<1000; i++) {
			for (int j=0; j<1000; j++) {
				if (yt == -1 && table[i][j] != -1) {
					yt = i;
				}
				if (table[i][j] != -1) {
					yd = i;
				}
			}
		}

		for (int j=0; j<1000; j++) {
			for (int i=0; i<1000; i++) {
				if (xt == -1 && table[i][j] != -1) {
					xt = j;
				}
				if (table[i][j] != -1) {
					xd = j;
				}
			}
		}

		out.println((xd - xt + 1) + " " + (yd - yt + 1));

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