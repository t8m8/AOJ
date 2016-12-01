import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1193 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int h = in.nextInt();
		if (h == 0) return false;

		int[][] t = new int[h][5];
		for (int i=0; i<h; i++) {
			for (int j=0; j<5; j++) {
				t[i][j] = in.nextInt();
			}
		}

		int ans = 0;
		while (true) {
			boolean f = false;
			for (int i=0; i<h; i++) {
				for (int j=0; j<3; j++) {
					if (t[i][j] == -1) continue;
					int pos = j;
					while (pos < 5 && t[i][j] == t[i][pos]) pos++;
					if (pos - j >= 3) {
						for (int k=j; k<pos; k++) {
							ans += t[i][k];
							t[i][k] = -1;
						}
						f = true;
					}
				}
			}

			for (int i=h-1; i>0; i--) {
				for (int j=0; j<5; j++) {
					if (t[i][j] > 0) continue;
					int pos = i - 1;
					while (pos > 0 && t[pos][j] < 0) pos--;
					t[i][j] = t[pos][j];
					t[pos][j] = -1;
				}
			}

			if (!f) break;
		}

		out.println(ans);

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		while (solve());
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}