import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1125 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		int w = in.nextInt(), h = in.nextInt();

		int[][] field = new int[w+2][h+2];
		for (int i=0; i<n; i++) {
			field[in.nextInt()][in.nextInt()]++;
		}

		for (int i=1; i<=w; i++) {
			for (int j=1; j<=h; j++) {
				field[i+1][j] += field[i][j];
				field[i][j+1] += field[i][j];
				field[i+1][j+1] -= field[i][j];
			}
		}

		int s = in.nextInt(), t = in.nextInt();
		int max = 0;
		for (int i=s; i<=w; i++) {
			for (int j=t; j<=h; j++) {
				max = Math.max(max, field[i][j] - field[i-s][j] - field[i][j-t] + field[i-s][j-t]);
			}
		}

		out.println(max);

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