import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1160 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int w = in.nextInt();
		int h = in.nextInt();
		if (w + h == 0) return false;

		int[][] table = new int[h][w];
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				table[i][j] = in.nextInt();
			}
		}

		boolean[][] visited = new boolean[h][w];
		int[] dx = { 0, 1, 1, 1, 0,-1,-1,-1};
		int[] dy = { 1, 1, 0,-1,-1,-1, 0, 1};
		int cnt = 0;
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				if (visited[i][j] || table[i][j] == 0) continue;

				ArrayDeque<Integer> que = new ArrayDeque<>();
				que.add(i*w+j);
				while (que.size() > 0) {
					int c = que.pollFirst();
					int cy = c/w, cx = c%w;
					for (int k=0; k<8; k++) {
						int ny = cy + dy[k], nx = cx + dx[k];
						if (ny < 0 || nx < 0 || h <= ny || w <= nx) continue;
						if (visited[ny][nx] || table[ny][nx] == 0) continue;
						visited[ny][nx] = true;
						que.add(ny*w+nx);
					}
				}

				cnt++;
			}
		}

		out.println(cnt);

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