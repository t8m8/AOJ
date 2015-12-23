import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2000 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		boolean[][] table = new boolean[21][21];
		for (int i=0; i<n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			table[y][x] = true;
		}

		int m = in.nextInt();
		int cy = 10, cx = 10, cnt = 0;
		while (m-- > 0) {
			char d = in.next().charAt(0);
			int s = in.nextInt();

			switch (d) {
				case 'N':
					while (s-- > 0) {
						cy++;
						if (table[cy][cx]) {
							table[cy][cx] = false;
							cnt++;
						}
					}
					break;
				case 'E':
					while (s-- > 0) {
						cx++;
						if (table[cy][cx]) {
							table[cy][cx] = false;
							cnt++;
						}
					}
					break;
				case 'S':
					while (s-- > 0) {
						cy--;
						if (table[cy][cx]) {
							table[cy][cx] = false;
							cnt++;
						}
					}
					break;
				case 'W':
					while (s-- > 0) {
						cx--;
						if (table[cy][cx]) {
							table[cy][cx] = false;
							cnt++;
						}
					}
					break;
			}
		}

		out.println(cnt == n ? "Yes" : "No");

		return true;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(solve());
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}