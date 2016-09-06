import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1130 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int w = in.nextInt();
		int h = in.nextInt();
		if (w + h == 0) return false;

		int sy = -1, sx = -1;

		char[][] table = new char[h][w];
		for (int i=0; i<h; i++) {
			table[i] = in.next().toCharArray();
			for (int j=0; j<w; j++) {
				if (table[i][j] == '@') {
					sy = i; sx = j;
				}
			}
		}

		int[] dx = { 0, 1, 0,-1};
		int[] dy = { 1, 0,-1, 0};

		ArrayDeque<Integer> que = new ArrayDeque<>();
		int cnt = 0;
		que.add(sy*w+sx);

		boolean[][] visited = new boolean[h][w];
		visited[sy][sx] = true;

		while (que.size() > 0) {
			int c = que.pollFirst();
			cnt++;
			int cy = c/w, cx = c%w;
			for (int k=0; k<4; k++) {
				int ny = cy + dy[k], nx = cx + dx[k];
				if (ny < 0 || nx < 0 || h <= ny || w <= nx) continue;
				if (table[ny][nx] == '#' || visited[ny][nx]) continue;
				visited[ny][nx] = true;
				que.add(ny*w+nx);
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