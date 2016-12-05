import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1126 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static char[][] t;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};

	static String[][] dp;
	static int h, w;

	static String rec(int cy, int cx) {
		if (dp[cy][cx].length() > 0) return dp[cy][cx];
		String max = "";
		for (int k=0; k<2; k++) {
			int ny = cy + dy[k];
			int nx = cx + dx[k];
			if (h <= ny || w <= nx) continue;
			if ('0' <= t[ny][nx] && t[ny][nx] <= '9') {
				String tmp = rec(ny, nx);
				if (tmp.length() > max.length()) max = tmp;
				else if (tmp.length() == max.length() && tmp.compareTo(max) > 0) max = tmp;
			}
		}
		if (max.equals("")) return dp[cy][cx] = String.valueOf(t[cy][cx]);
		return dp[cy][cx] = t[cy][cx] + max;
	}

	static boolean solve() {
		w = in.nextInt();
		h = in.nextInt();
		if (w + h == 0) return false;

		t = new char[h][w];
		for (int i=0; i<h; i++) {
			t[i] = in.next().toCharArray();
		}

		dp = new String[h][w];
		for (int i=0; i<h; i++) {
			Arrays.fill(dp[i], "");
		}

		String ans = "";
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				if ('0' <= t[i][j] && t[i][j] <= '9') {
					String tmp = rec(i, j);
					int pos = 0;
					while (pos < tmp.length() && tmp.charAt(pos) == '0') pos++;
					tmp = tmp.substring(pos, tmp.length());
					if (tmp.length() > ans.length()) ans = tmp;
					else if (tmp.length() == ans.length() && tmp.compareTo(ans) > 0) ans = tmp;
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