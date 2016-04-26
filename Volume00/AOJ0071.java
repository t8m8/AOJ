import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0071 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static ArrayDeque<int[]> que = new ArrayDeque<int[]>();

	static void solve() {
		int n = in.nextInt();
		int cnt = 1;
		while (n-- > 0) {
			char[][] table = new char[8][8];
			for (int i=0; i<8; i++) {
				table[i] = in.next().toCharArray();
			}

			que.add(new int[]{in.nextInt()-1,in.nextInt()-1});
			while (!que.isEmpty()) {
				burst(table, que.pollFirst());
			}

			out.println("Data " + (cnt++) + ":");

			for (int i=0; i<8; i++) {
				for (int j=0; j<8; j++) {
					out.print(table[i][j]);
				}
				out.println();
			}
		}
	}

	static void burst(char[][] table, int[] p) {
		int x = p[0], y = p[1];
		int[] dy = {0,1,0,-1};
		int[] dx = {1,0,-1,0};
		table[y][x] = '0';
		for (int k=0; k<4; k++) {
			int tx = x, ty = y;
			for (int i=0; i<3; i++) {
				tx += dx[k];
				ty += dy[k];
				if (tx < 0 || ty < 0 || 7 < tx || 7 < ty) continue;
				if (table[ty][tx] == '1') {
					que.add(new int[]{tx,ty});
				}
			}
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