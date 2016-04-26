import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0062 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		String s = in.next();
		int[] a = new int[10];
		for (int i=0; i<10; i++) {
			a[i] = s.charAt(i) - '0';
		}

		int size = 10;
		for (int i=0; i<10; i++) {
			for (int j=0; j<size-1; j++) {
				a[j] = (a[j] + a[j+1])%10;
			}
			size--;
		}

		out.println(a[0]);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(in.hasNext()) solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}