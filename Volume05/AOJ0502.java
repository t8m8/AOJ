import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0502 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		Dice d = new Dice();
		int sum = 1;
		for (int i=0; i<n; i++) {
			String s = in.next();
			if ("North".equals(s)) {
				d.rotate(1);
			} else if ("East".equals(s)) {
				d.rotate(0);
			} else if ("West".equals(s)) {
				d.rotate(2);
			} else if ("South".equals(s)) {
				d.rotate(3);
			} else if ("Right".equals(s)) {
				d.rotate(4);
			} else if ("Left".equals(s)) {
				d.rotate(5);
			}

			sum += d.face[Dice.TOP];
		}
		out.println(sum);

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.currentTimeMillis();

		while(solve());
		out.flush();

		long end = System.currentTimeMillis();
		dump((end-start) + "ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}

class Dice implements Cloneable{

	public static final int TOP = 0;
	public static final int BOTTOM = 1;
	public static final int FRONT = 2;
	public static final int BACK = 3;
	public static final int LEFT = 4;
	public static final int RIGHT = 5;

	public static final int[][] roll = {
		{TOP,LEFT,BOTTOM,RIGHT},//+x
		{TOP,FRONT,BOTTOM,BACK},//+y
		{TOP,RIGHT,BOTTOM,LEFT},//-x
		{TOP,BACK,BOTTOM,FRONT},//-y

		{FRONT,RIGHT,BACK,LEFT},//cw
		{FRONT,LEFT,BACK,RIGHT},//ccw
	};

	public static final int[] dx = {1,0,-1,0};
	public static final int[] dy = {0,1,0,-1};

	final int[] face;

	public Dice() {
		this.face = new int[6];
		this.face[TOP] = 1; this.face[BOTTOM] = 6; this.face[FRONT] = 2;
		this.face[BACK] = 5; this.face[LEFT] = 4; this.face[RIGHT] = 3;
	}
	public Dice(int[] nums) {
		this.face = nums.clone();
	}

	public void rotate(int dir) {
		int temp = face[roll[dir][0]];
		for (int i=0; i<3; i++) {
			face[roll[dir][i]] = face[roll[dir][i+1]];
		}
		face[roll[dir][3]] = temp;
	}

	static void swap(Dice d1, Dice d2) {
		for (int i=0; i<6; i++) {
			int temp = d1.face[i];
			d1.face[i] = d2.face[i];
			d2.face[i] = temp;
		}
	}

	public boolean equals(Dice d) {
		return  this.face[TOP] == d.face[TOP] && this.face[BOTTOM] == d.face[BOTTOM]
			&& this.face[FRONT] == d.face[FRONT] && this.face[BACK] == d.face[BACK]
			&& this.face[LEFT] == d.face[LEFT] && this.face[RIGHT] == d.face[RIGHT];
	}

	public String toString() {
		return Arrays.toString(face);
	}

	@Override
	public Dice clone() {
		return new Dice(this.face);
	}
}