package Analize_Numerike_II;

public class SorMethod {

	public static void sorMethod(double[][] A, double[] B, double[] X, double w, int N, double TOL) {
		double Shuma = 0;
		double Shuma1= 0;
		int k = 1;
		double[] x = new double[A.length];
		while (k <= N) {
			for (int i = 0; i < A.length; i++) {
				Shuma = 0;
				for (int j = 0; j < A.length; j++) {
					if (j != i) {
						Shuma += A[i][j] * X[j];
						x[i] = (1 - w) * X[i] + (w * (B[i] - Shuma)) / A[i][i];
					}
				}
				if (distanceBetweenTwoVectorsLinfinit(x, X) < TOL) {
					for (int j = 1; j < A.length; j++) {
						System.out.print(x[j] + "      ");
					}
					System.exit(0);
				}
				System.out.print(x[i] + "      ");

				X[i] = x[i];

				if ((i + 1) % A.length == 0) {
					System.out.println();
				}

			}
			k++;

		}
	}

	public static double distanceBetweenTwoVectorsLinfinit(double[] A, double[] B) {
		double res = Math.abs(A[0] - B[0]);

		for (int i = 0; i < A.length; i++) {

			if (Math.abs(A[i] - B[i]) > Math.abs(res)) {
				res = Math.abs(A[i] - B[i]);
			}
		}
		return res;

	}

	public static double getMaxValue(double[] A) {
		double maxValue = Math.abs(A[0]);
		for (int i = 1; i < A.length; i++) {
			if (Math.abs(A[i]) > Math.abs(maxValue)) {
				maxValue = Math.abs(A[i]);

			}
		}
		return maxValue;
	}

	public static void main(String[] args) {
		double[][] A = { { 4, 3, 0 }, { 3, 4, -1 }, { 0, -1, 4 } };
		double[] B = { 24, 30, -24 };
		double[] X = { 1, 1, 1 };
		sorMethod(A, B, X, 1.25, 7, 0.001);
	}
}

