import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0104 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int h = in.nextInt();
		int w = in.nextInt();
		if (h + w == 0) return false;

		char[][] table = new char[h][w];

		for (int i=0; i<h; i++) {
			table[i] = in.next().toCharArray();
		}

		boolean[][] f = new boolean[h][w];

		int ch = 0, cw = 0;
		while (true) {
			if (f[ch][cw]) {
				out.println("LOOP");
				return true;
			}

			f[ch][cw] = true;

			switch (table[ch][cw]) {
				case '>':
					cw++;
					break;
				case 'v':
					ch++;
					break;
				case '<':
					cw--;
					break;
				case '^':
					ch--;
					break;
				case '.':
					out.println(cw+" "+ch);
					return true;
			}
		}
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