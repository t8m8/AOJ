import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0093 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static String solve() {

		String ans = "";

		while (true) {
			int a = in.nextInt();
			int b = in.nextInt();
			if (a + b == 0) return ans.substring(0,ans.length()-2);


			boolean f = false;
			for (int y=a; y<=b; y++) {
				if (isLeapYear(y)) {
					ans += y + "\n";
					f = true;
				}
			}

			if (!f) {
				ans += "NA\n";
			}

			ans += "\n";
		}
	}

	public static boolean isLeapYear(int y) {
        return y%400 == 0 || (y%4 == 0 && y%100 != 0);
    }

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		out.println(solve());
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}