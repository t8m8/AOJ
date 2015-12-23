import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2018 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		double p = in.nextInt();
		if (n + m + p == 0) return false;

		int[] x = new int[n];
		int cnt = 0;
		double sum = 0;
		for (int i=0; i<n; i++) {
			x[i] = in.nextInt();
			cnt += x[i];
			sum += x[i]*100;
		}

		sum -= sum*(p/100);
		out.println(x[m-1] == 0 ? 0 : (int)(sum/x[m-1]));

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