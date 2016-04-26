import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0101 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int n = in.nextInt();
		in.nextLine();
		while (n-- > 0) {
			out.println(in.nextLine().replaceAll("Hoshino","Hoshina"));
		}
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}