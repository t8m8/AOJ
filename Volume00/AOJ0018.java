import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0018 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		Integer[] a = new Integer[5];
		for (int i=0; i<5; i++) {
			a[i] = in.nextInt();
		}

		Arrays.sort(a, new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});

		for (int i=0; i<4; i++) {
			out.print(a[i]+" ");
		}
		out.println(a[4]);
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