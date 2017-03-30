import java.util.*;
import java.math.*;

public class Matrix
{
	public static double determinant(int size, double[][] matrix)
	{
		double det = 0;
		if(size == 1)
		{
			det = matrix[0][0];
		}
		else if(size == 2)
		{
			det = matrix[0][0]*matrix[1][1] - matrix[1][0]*matrix[0][1];
		}
		else
		{
			for (int i = 0; i < size; ++i)
			{
				det += Math.pow(-1.0, (double)i) * matrix[0][i] * determinant(size-1,subMatrix(0, i, matrix, size));
			}
        }
        return det;
	}
	
	public static double[][] subMatrix(int r, int c, double[][] matrix, int size)
	{
		double[][] sub = new double [size-1][size-1];
		int row = 0;
		for(int i = 0; i < size; i++)
		{
			if(i == r) continue;
			int col = 0;
			for(int j = 0; j < size; j++)
			{
				if(j == c) continue;
				sub[row][col] = matrix[i][j];
				++col;
			}
			++row;
		}
		return sub;
	}
	
	public static double[][] inverse(double[][] matrix)
	{
		int size = matrix.length;
		double[][] inverseMatrix = new double [size][size];
		double det = determinant(size,matrix);
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				inverseMatrix[i][j] = Math.pow(-1.0, (double)i+j) * determinant(size-1, subMatrix(j, i, matrix, size)) / det;
			}
		}
		
		return inverseMatrix;
	}
}
