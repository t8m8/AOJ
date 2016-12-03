import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1249 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int n, m;
	static int[][][] t;

	static int put(int y, int x, int bw) {
		int h = 0;
		while (t[y][x][h] != 0) h++;
		t[y][x][h] = bw;
		return h;
	}

	static int[] dx = {0, 0, 1, 0, 1, 1, 1,  0,  0, -1,  0,  0,  0, -1, -1,  1, -1, -1,  1, -1, -1, -1,  1, -1,  1,  1};
	static int[] dy = {0, 1, 0, 1, 0, 1, 1,  0, -1,  0, -1, -1,  1,  0,  0,  0, -1,  1, -1, -1, -1,  1, -1,  1, -1,  1};
	static int[] dz = {1, 0, 0, 1, 1, 0, 1, -1,  0,  0, -1,  1, -1, -1,  1, -1,  0,  0,  0, -1,  1, -1, -1,  1,  1, -1};

	static boolean f(int y, int x, int z, int bw, int cnt, int d) {
		if (cnt == m) return true;
		if (t[y][x][z] != bw) return false;
		int ny = y + dy[d];
		int nx = x + dx[d];
		int nz = z + dz[d];
		if (ny < 0 || nx < 0 || nz < 0 || n <= nx || n <= ny || n <= nz) return cnt == m-1;
		return f(ny, nx, nz, bw, cnt+1, d);
	}

	static boolean win(int y, int x, int z, int bw) {
		if (t[y][x][z] != bw) return false;
		for (int d=0; d<26; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			int nz = z + dz[d];
			if (ny < 0 || nx < 0 || nz < 0 || n <= nx || n <= ny || n <= nz) continue;
			if (f(ny, nx, nz, bw, 1, d)) return true;
		}
		return false;
	}

	static boolean solve() {
		n = in.nextInt();
		m = in.nextInt();
		int p = in.nextInt();
		if (n + m + p == 0) return false;

		t = new int[n][n][n];
		int win = -1;

		boolean f = false;
		for (int turn=0; turn<p; turn++) {
			int y = in.nextInt() - 1;
			int x = in.nextInt() - 1;
			int z = put(y, x, turn%2 + 1);
			if (f) continue;
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					for (int k=0; k<n; k++) {
						if (win(i, j, k, turn%2 + 1)) {
							win = turn;
							f = true;
						}
					}
				}
			}
		}

		out.println(win == -1 ? "Draw" : (win%2 == 0 ? "Black "+(win+1) : "White "+(win+1)));

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