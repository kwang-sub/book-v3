package practice.chap06;
import java.util.Scanner;

class Fsort2_06_19 {
	// 도수정렬(배열 요솟값은 min 이상 max이하)
	static void fSort(int[] a, int n, int min, int max) {
		int[] f = new int[max - min + 2]; // 누적도수
		int[] b = new int[n]; // 작업용 목적배열

		for (int i = 0; i < n; i++)
			f[a[i] - min]++; // 1단계
		for (int i = 1; i <= max - min + 1; i++)
			f[i] += f[i - 1]; // 2단계
		for (int i = n - 1; i >= 0; i--)
			b[--f[a[i] - min]] = a[i]; // 3단계
		for (int i = 0; i < n; i++)
			a[i] = b[i]; // 4단계
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("도수정렬 ");
		System.out.print("요솟수：");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			do {
				System.out.print("x[" + i + "]：");
				x[i] = stdIn.nextInt();
			} while (x[i] < 0);
		}

		int max = x[0];
		for (int i = 1; i < nx; i++)
			if (x[i] > max)
				max = x[i];

		int min = x[0];
		for (int i = 1; i < nx; i++)
			if (x[i] < min)
				min = x[i];

		fSort(x, nx, min, max); // 배열 x를 도수정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
}
