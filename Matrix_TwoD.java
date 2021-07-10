import java.util.Scanner;

public class Matrix_TwoD extends Matrix_Determinant{

	private static int _m;
	private static int _n;
	private static int _matrix[][] = new int[20][20];

	
	public String scanner() {
		Scanner input = new Scanner(System.in);
		return input.next();
	}
	
	public int rowsize() {
		return _m;
	}
	
	public int colsize() {
		return _n;
	}
	
	Matrix_TwoD(){
		_m = 3;
		_n = 3;
		int[][] arr = new int[_m][_n]; 
		
		for(int i = 0; i < _m; i++) {
			for(int j = 0; j < _n; j++) {
				if(i == j) {
					arr[i][j] = 1;
				}else {
					arr[i][j] = 0;
				}
				
				_matrix[i][j] = arr[i][j];
			}
		}
	}
	
	public int setEntryType() {
		System.out.println("\nDo you wanna give elements for matrix?");
		System.out.println("Choose :\n1 -> Yes\n0 -> No");
		int flag = Integer.parseInt(scanner());
		
		if(!(flag == 0 || flag == 1)){
			setEntryType();
		}
		return flag;
	}
	
	public Matrix_TwoD(int r, int c) {
		_m = r;
		_n = c;
		int[][] arr = new int[_m][_n];
		int flag = setEntryType();
		
		if(flag == 1) {
			for(int i = 0; i < _m; i++) {
				System.out.printf("Enter elements for row %d\n", i);
				for(int j = 0; j < _n; j++) {
					arr[i][j] = Integer.parseInt(scanner());
				
					_matrix[i][j] = arr[i][j];
				}
				System.out.println();
			}
			
		}else {
			for(int i = 0; i < _m; i++) {
				for(int j = 0; j < _n; j++) {
					arr[i][j] = 0;
					
					_matrix[i][j] = arr[i][j];
				}
			}
		}
				
	}

	public Matrix_TwoD(int r, int c, int value) {
		_m = r;
		_n = c;
		int[][] arr = new int[_m][_n]; 
		
		for(int i = 0; i < _m; i++) {
			for(int j = 0; j < _n; j++) {
				arr[i][j] = value;
				
				_matrix[i][j] = arr[i][j];
			}
		}
	}

	public int[][] get_matrix() {
		int[][] mat = new int[_m][_n];
		for(int i = 0; i < _m; i++) {
			for(int j = 0; j < _n; j++) {
				mat[i][j] = _matrix[i][j];
				System.out.print("\t" + mat[i][j]);
			}
			System.out.println();
		}
		return mat;
	}

	public static void addition(int m1[][], int m2[][]){
		if((m1.length == m2.length) && (m1[0].length == m2[0].length)) {
			int add[][] = new int[m1.length][m1[0].length];
			
			System.out.println("Addition :");
			for(int i = 0; i < m1.length; i++) {
				for(int j = 0; j < m1[0].length; j++) {
					add[i][j] = m1[i][j] + m2[i][j];
					System.out.print("\t" + add[i][j]);
				}
				System.out.println();
			}
		}else {
			System.out.println("Theses two matrices aren't of same dimensions.");
			System.out.println("Addition can't be performed.");
		}
		System.out.println();
	}
	
	public static void subtraction(int m1[][], int m2[][]){
		if((m1.length == m2.length) && (m1[0].length == m2[0].length)) {
			int sub[][] = new int[m1.length][m1[0].length];
			
			System.out.println("Subtraction :");
			for(int i = 0; i < m1.length; i++) {
				for(int j = 0; j < m1[0].length; j++) {
					sub[i][j] = m1[i][j] - m2[i][j];
					System.out.print("\t" + sub[i][j]);
				}
				System.out.println();
			}
		}else {
			System.out.println("Theses two matrices aren't of same dimensions");
			System.out.println("Subtraction can't be performed.");
		}
		System.out.println();
	}
	
	public static void multiplication(int m1[][], int m2[][]){
		if(m1[0].length == m2.length) {
			int mul[][] = new int[m1.length][m1[0].length];
			
			for(int i = 0; i < m1.length; i++) {
				for(int j = 0; j < m2[0].length; j++) {
					mul[i][j] = 0;
					for(int k = 0; k < m2.length; k++) {
						mul[i][j] += m1[i][k] * m2[k][j];
					}
				}
			}
			
			System.out.println("Multiplication :");
			for(int r = 0; r < m1.length; r++) {
				for(int c = 0; c < m2[0].length; c++) {
					System.out.print("\t" + mul[r][c]);
				}
				System.out.println();
			}
		}else {
			System.out.println("Column dimension of first matrix and row dimensions of second matrix aren't same.");
			System.out.println("Multiplication can't be performed.");
		}
		System.out.println();
	}

	public static void transpose(int[][] mat) {
		System.out.println("Transpose :");
		for(int i = 0; i < mat[0].length; i++)
    	{
      	    for(int j = 0; j < mat[0].length; j++)
            {
                System.out.print("\t" + mat[j][i]);
            }
            System.out.println();
        }
	}
}
