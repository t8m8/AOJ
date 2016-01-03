import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2311 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static char[][] table;
	static int[] dx = { 0, 1, 1, 1, 0,-1,-1,-1};
	static int[] dy = { 1, 1, 0,-1,-1,-1, 0, 1};

	static int cnt(int turn, int x, int y) {
		int cnt = 0;
		for (int d=0; d<8; d++) {
			int tmp = 0;
			int nx = x, ny = y;
			while (true) {
				nx = nx + dx[d];
				ny = ny + dy[d];
				if (nx < 0 || ny < 0 || 8 <= nx || 8 <= ny) break;
				if ((turn == 0 && table[ny][nx] == 'x') || (turn == 1 && table[ny][nx] == 'o')) tmp++;
				if ((turn != 0 && table[ny][nx] == 'x') || (turn != 1 && table[ny][nx] == 'o')) {
					cnt += tmp;
					break;
				}
				if (table[ny][nx] == '.') break;
			}
		}
		return cnt;
	}

	static boolean _draw(int turn, int d, int x, int y) {
		if (x < 0 || y < 0 || 8 <= x || 8 <= y) return false;
		if (table[y][x] == '.') return false;
		if (turn == 0 && table[y][x] == 'o') return true;
		if (turn == 1 && table[y][x] == 'x') return true;
		boolean f = _draw(turn, d, x+dx[d], y+dy[d]);
		if (f) {
			table[y][x] = turn == 0 ? 'o' : 'x';
		}
		return f;
	}

	static void draw(int turn, int x, int y) {
		table[y][x] = turn == 0 ? 'o' : 'x';
		for (int d=0; d<8; d++) {
			_draw(turn, d, x+dx[d], y+dy[d]);
		}
	}

	static boolean turnA() {
		int max = -1, mi = -1, mj = -1;

		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				if (table[i][j] != '.') continue;
				int cnt = cnt(0, j, i);
				if (max < cnt) {
					max = cnt;
					mi = i;
					mj = j;
				}
			}
		}

		if (max > 0) draw(0, mj, mi);

		return max != -1;
	}

	static boolean turnB() {
		int max = -1, mi = -1, mj = -1;

		for (int i=7; i>=0; i--) {
			for (int j=7; j>=0; j--) {
				if (table[i][j] != '.') continue;
				int cnt = cnt(1, j, i);
				if (max < cnt) {
					max = cnt;
					mi = i;
					mj = j;
				}
			}
		}

		if (max > 0) draw(1, mj, mi);

		return max != -1;
	}

	static void solve() {
		table = new char[8][8];
		for (int i=0; i<8; i++) {
			table[i] = in.next().toCharArray();
		}

		int turn = 0;
		boolean f = true;
		int p = 0;
		while (f && p < 100) {
			if (turn == 0) f = turnA();
			else f = turnB();
			turn = (turn + 1)%2;
			p++;
		}

		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				out.print(table[i][j]);
			}
			out.println();
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