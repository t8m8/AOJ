import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1192 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int x = in.nextInt();
		int y = in.nextInt();
		int s = in.nextInt();
		if (x + y + s == 0) return false;


		int max = 0;
		for (int i=1; i<s; i++) {
			for (int j=1; j<s; j++) {
				int a = i*(100+x)/100;
				int b = j*(100+x)/100;
				if (a + b != s) continue;
				max = Math.max(max, i*(100+y)/100 +  j*(100+y)/100);
			}
		}

		out.println(max);

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