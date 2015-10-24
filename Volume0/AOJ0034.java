import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0034 {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() throws IOException{
		String str;
		while ((str = br.readLine()) != null) {
			String[] s = str.split(",");
			int[] a = new int[10];
			int sum = 0;
			for (int i=0; i<10; i++) {
				a[i] = Integer.parseInt(s[i]);
				sum += a[i];
			}

			int v1 = Integer.parseInt(s[10]);
			int v2 = Integer.parseInt(s[11]);

			double r = (double)sum*v1/(v1+v2);

			sum = 0;
			for (int i=0; i<10; i++) {
				sum += a[i];
				if (r <= sum) {
					out.println((i+1));
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();

		solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		br.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}