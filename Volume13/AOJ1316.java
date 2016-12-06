import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1316 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static int h, w;
	static char[][] t;

	static int[] dx = { 0, 1, 1, 1, 0,-1,-1,-1};
	static int[] dy = { 1, 1, 0,-1,-1,-1, 0, 1};

	static int ny(int y, int dir) {
		int ny = y + dy[dir] + h;
		return ny%h;
	}

	static int nx(int x, int dir) {
		int nx = x + dx[dir] + w;
		return nx%w;
	}

	static String rec(int cy, int cx, int sy, int sx, int dir) {
		if (cy == sy && cx == sx) return "";
		int ny = ny(cy, dir);
		int nx = nx(cx, dir);
		return t[cy][cx] + rec(ny, nx, sy, sx, dir);
	}

	static boolean solve() {
		h = in.nextInt();
		w = in.nextInt();
		if (h + w == 0) return false;

		t = new char[h][w];
		for (int i=0; i<h; i++) {
			t[i] = in.next().toCharArray();
		}
		ArrayList<String> list = new ArrayList<>();

		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				for (int k=0; k<8; k++) {
					String s = t[i][j] + rec(ny(i, k), nx(j, k), i, j, k);
					list.add(s);
				}
			}
		}

		Collections.sort(list);
		String ans = "";
		int max = 0;
		for (int i=0; i<list.size()-1; i++) {
			int n = list.get(i).length();
			int m = list.get(i+1).length();
			int l = Math.min(n, m);
			int x = 0;
			for (int j=0; j<=l; j++) {
				if (j == l || list.get(i).charAt(j) != list.get(i+1).charAt(j)) {
					x = j;
					break;
				}
			}
			if (max <= x) {
				String s = list.get(i).substring(0, x);
				if (max < x || ans.compareTo(s) > 0) {
					ans = s;
				}
				max = x;
			}
		}


		if (max < 2) {
			out.println(0);
		} else {
			out.println(ans);
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