import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0069 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		int m = in.nextInt();
		int t = in.nextInt()-1;
		int d = in.nextInt();

		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = i+1;
		}

		String[] s = new String[d];
		for (int i=0; i<d; i++) {
			s[i] = in.next();
			for (int j=0; j<n-1; j++) {
				if (s[i].charAt(j) == '1') {
					int tmp = a[j]; a[j] = a[j+1]; a[j+1] = tmp;
				}
			}
		}

		if (a[t] == m) {
			out.println("0");
			return true;
		}

		int x = a[t];

		for (int i=0; i<n; i++) {
			a[i] = i+1;
		}

		for (int i=0; i<d; i++) {
			for (int j=0; j<n-1; j++) {
				if (s[i].charAt(j) == '1') {
					int tmp = a[j]; a[j] = a[j+1]; a[j+1] = tmp;
				}
			}

			for (int j=0; j<n-1; j++) {
				if (j != 0 && s[i].charAt(j-1) == '1') continue;
				if (s[i].charAt(j) == '1') continue;
				if (j != n-2 && s[i].charAt(j+1) == '1') continue;

				if ((a[j] == x && a[j+1] == m) || (a[j] == m && a[j+1] == x)) {
					out.println((i+1)+" "+(j+1));
					return true;
				}
			}
		}

		out.println("1");
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