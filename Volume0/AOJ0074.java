import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0074 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int h = in.nextInt();
		int m = in.nextInt();
		int s = in.nextInt();
		if (h + m + s == -3) return false;

		int x = h*3600 + m*60 + s;

		x = 7200 - x;

		out.println(toString(x));
		out.println(toString(x*3));

		return true;
	}

	static String toString(int t) {
		String res = "";
		res += String.valueOf(t/3600).length() == 1 ? "0" + String.valueOf(t/3600) : String.valueOf(t/3600);
		t %= 3600;
		res += ":";
		res += String.valueOf(t/60).length() == 1 ? "0" + String.valueOf(t/60) : String.valueOf(t/60);
		t %= 60;
		res += ":";
		res += String.valueOf(t).length() == 1 ? "0" + String.valueOf(t) : String.valueOf(t);

		return res;
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