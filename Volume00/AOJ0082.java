import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0082 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int[] a = {4,1,4,1,2,1,2,1};
		int[] p = new int[8];
		for (int i=0; i<8; i++) {
			p[i] = in.nextInt();
		}

		int min = Integer.MAX_VALUE;
		int ans = -1;
		for (int i=0; i<8; i++) {
			int cnt = 0;
			for (int j=0, k=i; j<8; j++, k=(k+1)%8) {
				cnt += Math.max(0,p[j] - a[k]);
			}
			int x = 0;
			for (int j=i, k=7; k>=0; j=(j+1)%8, k--) {
				x += Math.pow(10,k)*a[j];
			}
			if (cnt < min) {
				ans = x;
				min = cnt;
			} else if (cnt == min) {
				ans = Math.min(ans, x);
			}
		}

		String s = String.valueOf(ans);
		for (int i=0; i<7; i++) {
			out.print(s.charAt(i)+" ");
		}

		out.println(s.charAt(7));
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