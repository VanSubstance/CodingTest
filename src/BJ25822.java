import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 45:21
// 투 포인터
// 구태여 시간 줄일 방법 찾다가 시간 다버림
// https://www.acmicpc.net/problem/25822

public class BJ25822 {
	static BufferedReader br;
	static StringTokenizer st;
	static float temp;
	static int c, n, map[], maxL, maxV, ttemp, s, e, curL, curC;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		line();
		temp = first();
		c = (int) (temp / 0.99);
		line();
		n = next();
		map = new int[n];
		line();
		for (int i = 0; i < n; i++) {
			ttemp = next();
			map[i] = ttemp;
		}
		maxL = 0;

		s = 0;
		e = 0;
		curL = 0;
		curC = Math.min(c, 2);
		maxV = map[0];
		while (e <= n && s <= e) {
			if (e == n)
				break;
			if (map[e] == 0) {
				// map[e] 가 0이다
				if (curC > 0) {
					// 코인이 남았다
					// 사용
					curC--;
				} else {
					// 코인이 안남았다
					// 맨 앞에서부터 코인 여유 생길때가지 빼주기
					while (map[s] != 0) {
						s++;
						curL--;
					}
					s++;
					curL--;
				}
			}
			curL++;
			e++;
			if (maxL <= curL) {
				maxL = curL;
				for (int i = s; i <= e; i++) {
					if (i == n)
						break;
					maxV = Math.max(maxV,  map[i]);
				}
			}
			continue;
		}

		System.out.println(maxL);
		System.out.println(maxV);
	}

	static void line() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static float first() {
		return Float.parseFloat(st.nextToken());
	}

	static int next() {
		return Integer.parseInt(st.nextToken());
	}
}

/**
 * 
3.12
12
1 1 24 0 0 17 5 0 0 3 5 7

0.99
10
1 0 0 2 0 0 3 0 0 4


 * 
 */
