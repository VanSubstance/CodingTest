import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이분 탐색
 * 시간 오버
 * https://www.acmicpc.net/problem/16498
 * @author YangGaNorm
 *
 */
public class BJ16498 {
	static BufferedReader br;
	static StringTokenizer st;
	static int a, b, c, res;
	static int aa[], bb[], cc[];

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		line();
		a = next();
		b = next();
		c = next();
		aa = new int[a];
		bb = new int[b];
		cc = new int[c];
		line();
		for (int i = 0; i < a; i++) {
			aa[i] = next();
		}
		line();
		for (int i = 0; i < b; i++) {
			bb[i] = next();
		}
		line();
		for (int i = 0; i < c; i++) {
			cc[i] = next();
		}
		Arrays.sort(aa);
		Arrays.sort(bb);
		Arrays.sort(cc);
		res = Integer.MAX_VALUE;
		int c2, c3;
		for (int c1 : aa) {
			c2 = findNearest(c1, bb);
			c3 = findNearest((c1 + c2) / 2, cc);
			res = Math.min(res, 
					Math.max(
							Math.max(c1, c2), c3) - 
					Math.min(
							Math.min(c1, c2), c3));
		}

		System.out.println(res);
	}
	
	static int findNearest(int target, int arr[]) {
		int s = 0, e = arr.length - 1, m, res = Integer.MAX_VALUE;
		while (s <= e) {
			m = (e - s) / 2 + s;
			if (Math.abs(target - arr[m]) < Math.abs(res - target)) {
				res = arr[m];
			}
			if (s == e) break;
			if (target == arr[m]) return target;
			if (target < arr[m]) {
				e = m - 1;
			} else {
				s = m + 1;
			}
		}
		return res;
	}

	static void line() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static int next() {
		return Integer.parseInt(st.nextToken());
	}
}
