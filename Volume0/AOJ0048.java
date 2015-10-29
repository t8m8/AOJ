import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0048 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		double w = in.nextDouble();

		if (w <= 48) {
			out.println("light fly");
		} else if (w <= 51) {
			out.println("fly");
		} else if (w <= 54) {
			out.println("bantam");
		} else if (w <= 57) {
			out.println("feather");
		} else if (w <= 60) {
			out.println("light");
		} else if (w <= 64) {
			out.println("light welter");
		} else if (w <= 69) {
			out.println("welter");
		} else if (w <= 75) {
			out.println("light middle");
		} else if (w <= 81) {
			out.println("middle");
		} else if (w <= 91) {
			out.println("light heavy");
		} else {
			out.println("heavy");
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