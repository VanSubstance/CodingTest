import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// dp
// 31:44

public class BJ16974 {
	static BufferedReader br;
	static StringTokenizer st;
	static long n, x, len[], numP[], numB[], cntL[], res;
	static int temp;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		line();
		n = next();
		x = next();
		numP = new long[51];
		numB = new long[51];
		cntL = new long[51];
		numP[0] = 1;
		numB[0] = 0;
		cntL[0] = 1;
		for (int i = 1; i <= n; i++) {
			cntL[i] = cntL[i -1] * 2 + 3;
			numP[i] = numP[i - 1] * 2 + 1;
			numB[i] = numB[i - 1] * 2 + 2;
		}
		temp = (int)n;
		while (x > 0) {
			// x 바로 이하 temp버거 찾기
			if (x < cntL[temp]) {
				temp--;
				x--;
				continue;
			}
			// x 바로 아래 버거 + 1 더해주기
			res += numP[temp];
			x -= cntL[temp];
			if (x > 0) {
				res += 1L;
				x -= 1L;
			}
			
		}
		
		System.out.println(res);
	}
	static void line() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
	static long next() {
		return Long.parseLong(st.nextToken());
	}
}

/**
 * 0 - P = 
 * 1 - b0p0b = 3 + [0] * 3 = 5
 * 2 - b1p1b = 3 + [1] * 3 = 13
 * 3 - b2p2b = 3 + [2] * 3 = 29
 * 
 * 2 7
 * 2 - bbpppbpbpppbb
 * 
 * 2 7
 * 1 버거 ; x = 6
 * 1 버거 패티: 3개
 * 
 */
