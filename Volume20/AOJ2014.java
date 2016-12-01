import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2014 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int h, w;
	static char[][] t, a, b;
	static int[][] p;

	static int[] dx = { 0, 1, 0,-1};
	static int[] dy = { 1, 0,-1, 0};

	static void rec1(int cy, int cx) {
		a[cy][cx] = 'B';
		for (int i=0; i<4; i++) {
			int ny = cy + dy[i];
			int nx = cx + dx[i];
			if (ny < 0 || nx < 0 || h <= ny || w <= nx) continue;
			if (a[ny][nx] == '.') {
				rec1(ny, nx);
			}
		}
	}

	static void rec2(int cy, int cx) {
		b[cy][cx] = 'W';
		for (int i=0; i<4; i++) {
			int ny = cy + dy[i];
			int nx = cx + dx[i];
			if (ny < 0 || nx < 0 || h <= ny || w <= nx) continue;
			if (b[ny][nx] == '.') {
				rec2(ny, nx);
			}
		}
	}

	static boolean solve() {
		w = in.nextInt();
		h = in.nextInt();
		if (w + h == 0) return false;

		t = new char[h][w];
		a = new char[h][w];
		b = new char[h][w];

		for (int i=0; i<h; i++) {
			t[i] = in.next().toCharArray();
			for (int j=0; j<w; j++) {
				a[i][j] = b[i][j] = t[i][j];
			}
		}

		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				if (t[i][j] == 'B') {
					rec1(i, j);
				} else if (t[i][j] == 'W') {
					rec2(i, j);
				}
			}
		}

		int cntB = 0, cntW = 0;

		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				if (t[i][j] != '.') continue;
				if (a[i][j] == 'B' && b[i][j] == '.') {
					cntB++;
				} else if (a[i][j] == '.' && b[i][j] == 'W') {
					cntW++;
				}
			}
		}

		out.println(cntB+" "+cntW);

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