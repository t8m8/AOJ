import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0207 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int w = in.nextInt();
		int h = in.nextInt();
		if (w + h == 0) return false;

		int sx = in.nextInt() - 1, sy = in.nextInt() - 1;
		int gx = in.nextInt() - 1, gy = in.nextInt() - 1;

		int[][] t = new int[h][w];
		int n = in.nextInt();
		for (int k=0; k<n; k++) {
			int c = in.nextInt();
			int d = in.nextInt();
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			if (d == 0) {
				for (int i=y; i<y+2; i++) {
					for (int j=x; j<x+4; j++) {
						t[i][j] = c;
					}
				}
			} else {
				for (int i=y; i<y+4; i++) {
					for (int j=x; j<x+2; j++) {
						t[i][j] = c;
					}
				}
			}
		}

		if (t[sy][sx] == 0 || t[gy][gx] == 0) {
			out.println("NG");
			return true;
		}

		int[] dx = { 0, 1, 0,-1};
		int[] dy = { 1, 0,-1, 0};

		boolean[][] visited = new boolean[h][w];
		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.add(new int[]{sy, sx});
		visited[sy][sx] = true;

		while (que.size() > 0) {
			int[] tmp = que.pollFirst();
			int y = tmp[0];
			int x = tmp[1];

			if (y == gy && x == gx) {
				break;
			}

			for (int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || nx < 0 || w <= nx || h <= ny) continue;
				if (t[y][x] != t[ny][nx]) continue;
				if (visited[ny][nx]) continue;
				visited[ny][nx] = true;
				que.add(new int[]{ny, nx});
			}
		}

		if (visited[gy][gx]) {
			out.println("OK");
		} else {
			out.println("NG");
		}

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