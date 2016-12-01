import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2253 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int[] dx = {0, 1, 1, 0, -1, -1};
	static int[] dy = {1, 1, 0, -1, -1, 0};
	static int offset = 500;

	static boolean solve() {
		int t = in.nextInt();
		int n = in.nextInt();
		if (t + n == 0) return false;

		boolean[][] visited = new boolean[1000][1000];
		for (int i=0; i<n; i++) {
			int x = in.nextInt() + offset;
			int y = in.nextInt() + offset;
			visited[x][y] = true;
		}

		int sx = in.nextInt() + offset;
		int sy = in.nextInt() + offset;

		ArrayDeque<int[]> deq = new ArrayDeque<>();
		int ans = 0;
		deq.add(new int[]{sx, sy, t});
		visited[sx][sy] = true;

		while (!deq.isEmpty()) {
			int[] cur = deq.pollFirst();
			int cx = cur[0], cy = cur[1];
			int ct = cur[2];
			ans++;
			if (ct == 0) continue;

			for (int i=0; i<6; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					deq.add(new int[]{nx, ny, ct-1});
				}
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