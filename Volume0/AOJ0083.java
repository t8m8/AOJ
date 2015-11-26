import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0083 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int y = in.nextInt();
		int m = in.nextInt();
		int d = in.nextInt();
		if (y < 1868 || (y == 1868 && m < 9) || (y == 1868 && m == 9 && d < 8)) {
			out.println("pre-meiji");
		} else if (y < 1912 || (y == 1912 && m < 7) || (y == 1912 && m == 7 && d < 30)) {
			out.println("meiji " + (y-1867) + " " + m + " " + d);
		} else if (y < 1926 || (y == 1926 && m < 12) || (y == 1926 && m == 12 && d < 25)) {
			out.println("taisho " + (y-1911) + " " + m + " " + d);
		} else if (y < 1989 || (y == 1989 && m == 1 && d < 8)) {
			out.println("showa " + (y-1925) + " " + m + " " + d);
		} else {
			out.println("heisei " + (y-1988) + " " + m + " " + d);
		}
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