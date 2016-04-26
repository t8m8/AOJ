import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0558 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static char[][] table;
	static int h,w;

	static void solve() {
		h = in.nextInt();
		w = in.nextInt();
		int n = in.nextInt();
		int ci = -1, cj = -1;
		table = new char[h][w];
		for (int i=0; i<h; i++) {
			table[i] = in.next().toCharArray();
			for (int j=0; j<w; j++) {
				if (table[i][j] == 'S') {
					ci = i;
					cj = j;
				}
			}
		}

		int ans = 0;

		for (int i=1; i<=n; i++) {
			int[] res = bfs(ci,cj,i);
			ci = res[0];
			cj = res[1];
			ans += res[2];
		}

		out.println(ans);
	}

	static int[] bfs(int ci, int cj, int target) {

		boolean[][] visited = new boolean[h][w];
		visited[ci][cj] = true;

		int[] di = {0,1,0,-1};
		int[] dj = {1,0,-1,0};

		ArrayDeque<int[]> que = new ArrayDeque<int[]>();
		que.add(new int[]{ci,cj,0});

		while (!que.isEmpty()) {
			int[] cur = que.pollFirst();
			int i = cur[0];
			int j = cur[1];
			int d = cur[2];

			if (table[i][j] - '0' == target) return new int[]{i,j,d};

			for (int k=0; k<4; k++) {
				int ni = i + di[k];
				int nj = j + dj[k];
				if (ni < 0 || nj < 0 || h <= ni || w <= nj || visited[ni][nj] || table[ni][nj] == 'X') continue;
				que.add(new int[]{ni,nj,d+1});
				visited[ni][nj] = true;
			}
		}

		return null;
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