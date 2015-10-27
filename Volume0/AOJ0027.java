import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0027 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static String[] dow = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

	static boolean solve() {
		int m = in.nextInt();
		int d = in.nextInt();
		if (m + d == 0) return false;

		out.println(dow[calculateDayOfWeek(2004,m,d)]);

		return true;
	}

	public static int calculateDayOfWeek(int y, int m, int d) {
		if (m <= 2) {
			y--; m += 12;
		}
		return (y+y/4-y/100+y/400+(13*m+8)/5+d)%7;
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