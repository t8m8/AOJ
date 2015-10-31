import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0055 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		double a = in.nextDouble();
		double ans = 0;
		for (int i=0; i<10; i++) {
			ans += a;
			if (i%2 == 0) a *= 2;
			else a /= 3;
		}

		out.printf("%.8f\n",ans);
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