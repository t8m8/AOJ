import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0051 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		char[] c = in.next().toCharArray();
		Arrays.sort(c);

		int min = 0, max = 0;
		for (int i=0; i<c.length; i++) {
			min += (c[i]-'0')*Math.pow(10,c.length-i-1);
			max += (c[c.length-1-i]-'0')*Math.pow(10,c.length-i-1);
		}

		out.println((max - min));
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		int n = in.nextInt();
		while(n-- > 0) solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}