import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest extends Matrix {

	@Test
	public void testDeterminant() {
		double[][] matrix = new double [3][3];
		
		matrix[0][0] = 1;
		matrix[0][1] = 0;
		matrix[0][2] = 0;
		matrix[1][0] = 0;
		matrix[1][1] = 1;
		matrix[1][2] = 0;
		matrix[2][0] = 0;
		matrix[2][1] = 0;
		matrix[2][2] = 1;
		
		assertEquals(1, Matrix.determinant(3, matrix), 0.001);
	}

	@Test
	public void testSubMatrix() {
		double[][] matrix = new double [3][3];
		double[][] subMatrix = new double [2][2];
		
		matrix[0][0] = 1;
		matrix[0][1] = 0;
		matrix[0][2] = 0;
		matrix[1][0] = 0;
		matrix[1][1] = 1;
		matrix[1][2] = 0;
		matrix[2][0] = 0;
		matrix[2][1] = 0;
		matrix[2][2] = 1;
		
		subMatrix[0][0] = 1;
		subMatrix[0][1] = 0;
		subMatrix[1][0] = 0;
		subMatrix[1][1] = 1;
		
		assertArrayEquals(subMatrix, subMatrix(0,0,matrix,3));
	}

	@Test
	public void testInverse() {
		double[][] matrix = new double [3][3];
		double[][] inverse = new double [3][3];
		
		matrix[0][0] = 7;
		matrix[0][1] = 2;
		matrix[0][2] = 1;
		matrix[1][0] = 0;
		matrix[1][1] = 3;
		matrix[1][2] = -1;
		matrix[2][0] = -3;
		matrix[2][1] = 4;
		matrix[2][2] = -2;
		
		inverse[0][0] = -2;
		inverse[0][1] = 8;
		inverse[0][2] = -5;
		inverse[1][0] = 3;
		inverse[1][1] = -11;
		inverse[1][2] = 7;
		inverse[2][0] = 9;
		inverse[2][1] = -34;
		inverse[2][2] = 21;
		
		assertArrayEquals(inverse, inverse(matrix));
	}

}
