import java.util.*;
import java.math.*;

public class Matrix
{
	
	
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
}
