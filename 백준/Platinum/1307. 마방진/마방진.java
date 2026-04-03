import java.util.Scanner;

public class Main {
	public static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		print(makeSquare());

		sc.close();
	}

	public static void print(int[][] square) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(square[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] makeSquare() {
		if (n % 2 == 0) {
			if (n % 4 == 0) {
				return makeFourEven();
			} else {
				return makeNotFourEven();
			}
		} else {
			return makeOdd(n);
		}
	}

	private static int[][] makeOdd(int size) {
		int[][] square = new int[size][size];

		int curNum = 1;
		int curR = 0;
		int curC = size / 2;
		square[curR][curC] = curNum;

		for (int i = 2; i <= size * size; i++) {
			int newR = curR - 1;
			int newC = curC - 1;

			if (newR < 0 && newC < 0) {
				newR = curR + 1;
				newC = curC;
			} else if (newR < 0) {
				newR += size;
			} else if (newC < 0) {
				newC += size;
			} else if (square[newR][newC] != 0) {
				newR = curR + 1;
				newC = curC;
			}

			curNum = i;
			curR = newR;
			curC = newC;
			square[curR][curC] = curNum;
		}

		return square;
	}

	private static int[][] makeFourEven() {
		int[][] square = new int[n][n];
		int num = 1;
		int lowerBound = n / 4;
		int upperBound = n / 4 * 3;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				square[i][j] = num++;
			}
		}

		for (int i = lowerBound; i < upperBound; i++) {
			for (int j = 0; j < lowerBound; j++) {
				int tmp = square[i][j];
				square[i][j] = square[n - 1 - i][n - 1 - j];
				square[n - 1 - i][n - 1 - j] = tmp;

				tmp = square[j][i];
				square[j][i] = square[n - 1 - j][n - 1 - i];
				square[n - 1 - j][n - 1 - i] = tmp;
			}
		}

		return square;
	}

	private static int[][] makeNotFourEven() {
		int[][] square = new int[n][n];
		int[][] halfSquare = makeOdd(n / 2);

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				if (j == 0 && i == n / 4) {
					square[i][j] = 0;
				} else if (j < n / 4 && i != n / 4) {
					square[i][j] = 3;
				} else if (j <= n / 4 && i == n / 4) {
					square[i][j] = 3;
				} else {
					square[i][j] = 0;
				}
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				if (j == 0 && i == n * 3 / 4) {
					square[i][j] = 3;
				} else if (j < n / 4 && i != n * 3 / 4) {
					square[i][j] = 0;
				} else if (j <= n / 4 && i == n * 3 / 4) {
					square[i][j] = 0;
				} else {
					square[i][j] = 3;
				}
			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = n / 2; j < n; j++) {
				if (j < n - Math.floor(n / 4) + 1) {
					square[i][j] = 2;
				} else {
					square[i][j] = 1;
				}
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = n / 2; j < n; j++) {
				if (j < n - Math.floor(n / 4) + 1) {
					square[i][j] = 1;
				} else {
					square[i][j] = 2;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				square[i][j] *= n * n / 4;
			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				square[i][j] += halfSquare[i][j];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				square[i][j] += halfSquare[i - n / 2][j];
			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = n / 2; j < n; j++) {
				square[i][j] += halfSquare[i][j - n / 2];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = n / 2; j < n; j++) {
				square[i][j] += halfSquare[i - n / 2][j - n / 2];
			}
		}

		return square;
	}
}
