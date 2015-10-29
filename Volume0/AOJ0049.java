import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0049 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static int A,B,AB,O;

	static void solve() {
		String[] s = in.next().split(",");
		if (s[1].equals("A")) {
			A++;
		} else if (s[1].equals("B")) {
			B++;
		} else if (s[1].equals("AB")) {
			AB++;
		} else if (s[1].equals("O")) {
			O++;
		}
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(in.hasNext()) solve();

		out.println(A);
		out.println(B);
		out.println(AB);
		out.println(O);

		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}