import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0067 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		while (in.hasNext()) {
			char[][] table = new char[12][12];
			for (int i=0; i<12; i++) {
				table[i] = in.next().toCharArray();
			}

			int[] dx = {0,1,0,-1};
			int[] dy = {-1,0,1,0};

			int cnt = 0;
			boolean[][] visited = new boolean[12][12];

			for (int i=0; i<12; i++) {
				for (int j=0; j<12; j++) {
					if (visited[i][j] || table[i][j] == '0') continue;
					cnt++;
					ArrayDeque<int[]> que = new ArrayDeque<int[]>();
					que.add(new int[]{i,j});

					while (!que.isEmpty()) {
						int[] cur = que.pollFirst();
						int y = cur[0];
						int x = cur[1];
						visited[y][x] = true;
						for (int k=0; k<4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							if (nx < 0 || ny < 0 || 12 <= nx || 12 <= ny || table[ny][nx] == '0' || visited[ny][nx]) continue;
							que.add(new int[]{ny,nx});
						}
					}
				}
			}

			out.println(cnt);
			out.flush();
		}
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}