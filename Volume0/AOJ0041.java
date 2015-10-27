import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0041 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int sum = 0;
		int[] a = new int[4];
		for (int i=0; i<4; i++) {
			a[i] = in.nextInt();
			sum += a[i];
		}
		if (sum == 0) return false;

		Arrays.sort(a);

		do {
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					for (int k=0; k<3; k++) {
						int ans = calc(a[0],a[1],i);
						ans = calc(ans,a[2],j);
						ans = calc(ans,a[3],k);
						if (ans == 10) {
							print(a,i,j,k);
							return true;
						}

						if (10 == calc(calc(a[0],a[1],i), calc(a[2],a[3],k), j)) {
							print2(a,i,j,k);
							return true;
						}
					}
				}
			}
		} while (nextPermutation(a));

		out.println(0);
		return true;
	}

	static boolean nextPermutation(int[] a) {
		int n = a.length, i, j;
		for (i=n-2; i>=0 && a[i]>=a[i+1]; i--);
		if (i == -1) return false;
		for (j=i+1; j<n && a[i]<a[j]; j++);
		int tmp = a[i]; a[i] = a[j-1]; a[j-1] = tmp;
		for (int l=i+1, r=n-1; l<r; l++,r--) {
			tmp = a[l]; a[l] = a[r]; a[r] = tmp;
		}
		return true;
	}

	static int calc(int a, int b, int o) {
		switch(o) {
			case 0: return a + b;
			case 1: return a - b;
			case 2: return a * b;
		}

		return -1;
	}

	static void print(int[] a, int i, int j, int k) {
		out.print("(((");
		out.print(a[0]+" ");
		out.print(i == 0 ? '+' : (i == 1 ? '-' : '*'));
		out.print(" "+a[1]+") ");
		out.print(j == 0 ? '+' : (j == 1 ? '-' : '*'));
		out.print(" "+a[2]+") ");
		out.print(k == 0 ? '+' : (k == 1 ? '-' : '*'));
		out.println(" "+a[3]+") ");
	}

	static void print2(int[] a, int i, int j, int k) {
		out.print("((" + a[0]+" ");
		out.print(i == 0 ? '+' : (i == 1 ? '-' : '*'));
		out.print(" "+a[1]+") ");
		out.print(j == 0 ? '+' : (j == 1 ? '-' : '*'));
		out.print(" ("+a[2]+" ");
		out.print(k == 0 ? '+' : (k == 1 ? '-' : '*'));
		out.println(" "+a[3]+"))");
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