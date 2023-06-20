import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소수 판별 = 에라토스테네스의 체
// 시간 오버
// 수학
// https://www.acmicpc.net/problem/11690

public class BJ11690 {
	static BufferedReader br;
	static int n;
	static long res;
	static boolean map[];

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new boolean[n + 1];
		res = 1L;
		long temp;
		for (int i = 2; i <= n; i++) {
			// 배수 지워주기
			if (map[i])
				continue;
			temp = 2;
			while (i * temp <= n) {
				map[i * (int)temp] = true;
				temp++;
			}
		}
		for (int i = 2; i <= n; i += 2) {
			// 배수 지워주기
			if (map[i])
				continue;
			temp = i;
			while (temp <= n) {
				temp *= i;
			}
			if (temp != n) temp /= i;
			res = res * temp % (long) Math.pow(2, 32);
			if (i == 2)
				i -= 1;
		}
		System.out.println(res % (long) Math.pow(2, 32));
	}
}
