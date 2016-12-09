import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0209 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int[][] rotate(int[][] a) {
		int n = a.length;
		int[][] res = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				res[i][j] = a[j][n-1-i];
			}
		}
		return res;
	}

	static boolean solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		if (n + m == 0) return false;

		int[][] w = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				w[i][j] = in.nextInt();
			}
		}

		int[][] p = new int[m][m];
		for (int i=0; i<m; i++) {
			for (int j=0; j<m; j++) {
				p[i][j] = in.nextInt();
			}
		}

		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int t=0; t<4; t++) {
					boolean f = true;

					for (int k=0; k<m; k++) {
						for (int l=0; l<m; l++) {
							if (i+k >= n || j+l >= n) {
								f = false;
								break;
							}
							if (p[k][l] == -1) continue;
							if (w[i+k][j+l] != p[k][l]) {
								f = false;
								break;
							}
						}
					}

					if (f) {
						for (int ai=0; ai<m; ai++) {
							for (int aj=0; aj<m; aj++) {
								if (p[ai][aj] != -1) {
									out.println((aj+j+1)+" "+(ai+i+1));
									return true;
								}
							}
						}
					}

					p = rotate(p);
				}
			}
		}

		out.println("NA");

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