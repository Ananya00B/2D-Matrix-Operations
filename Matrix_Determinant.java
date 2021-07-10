public class Matrix_Determinant {

	protected static int det(int matrix[][]) {
		int m = matrix.length;
		int n = matrix[0].length;
		int sum = 0;
		
		if(m != n) {
			sum = -3456;
		}else if(m == 1){
			sum += matrix[0][0];
		}else if(m == 2) {
			sum += (matrix[0][0] * matrix[1][1]) - (matrix[1][0] * matrix[0][1]);
		}
		else {
			for (int i = 0; i <	n; i++) {
				int minor[][] = new int[m - 1][n - 1];

				for (int j = 1; j < m; j++) {
					for (int k = 0; k < n; k++) {

						if (k < i) {
							minor[j - 1][k] = matrix[j][k];
						} else if (k > i) {
							minor[j - 1][k - 1] = matrix[j][k];
						}
					}
				}
				sum += Math.pow(-1, i) * matrix[0][i] * det(minor);
			}
		}
		return sum;
	}
	
	private static void determinant(int mat[][]) {
		int value = det(mat);
		if(value == -3456) {
			System.out.println("It's a non-square matrix.");
			System.out.println("Determinant can't be calculated.");
		}else {
			System.out.println("Determinant : " + value);
		}
	}
	
	public static void main(String[] args) {
		Matrix_TwoD mat;
		
		//Default Matrix
        mat = new Matrix_TwoD();
        System.out.println("Default Matrix,");
        System.out.println("Matrix M1 :");
        int m1[][] = mat.get_matrix();
		//Determinant
		determinant(m1);
		
		
		//Matrix with all the elements set as 0 or elements given through input
		System.out.printf("\n%dX%d Matrix,\n", 2, 2);
		mat = new Matrix_TwoD(2, 2);
		System.out.println("Matrix M2 :");
		int m2[][] = mat.get_matrix();
        //Transpose
		System.out.println("\nFor M2,");
      	Matrix_TwoD.transpose(m2);
		//Determinant
		determinant(m2);
		
		
		//Matrix with all the elements set as given number
		System.out.printf("\n%dX%d Matrix with all elements as %d,\n", 4, 3, 3);
		System.out.println("Matrix M3 :");
        mat = new Matrix_TwoD(4, 3, 3);
        int m3[][] = mat.get_matrix();
		//Determinant
		determinant(m3);
		
		
		System.out.printf("\n%dX%d Matrix,\n", 3, 2);
        mat = new Matrix_TwoD(3, 2);
        System.out.println("Matrix M4 :");
		int m4[][] = mat.get_matrix();
		//Transpose
		System.out.println("\nFor M4,");
      	Matrix_TwoD.transpose(m4);
		//Determinant
		determinant(m4);
		
		
		System.out.printf("\n%dX%d Matrix :\n", 3, 3);
		mat = new Matrix_TwoD(3, 3);
		System.out.println("Matrix M5 :");
		int m5[][] = mat.get_matrix();
		//Determinant
		determinant(m5);
		
		
		//Addition
		System.out.println("\nFor M1 and M5,");
		Matrix_TwoD.addition(m1, m5);
		System.out.println("\nFor M1 and M2,");
		Matrix_TwoD.addition(m1, m2);
		
		//Subtraction
		System.out.println("\nFor M5 and M1,");
		Matrix_TwoD.subtraction(m5, m1);
		
		//Multiplication
		System.out.println("\nFor M3 and M4,");
		Matrix_TwoD.multiplication(m3, m4);
	}

}
