import java.util.*;
import java.math.*;

public class Matrix
{
	public static void main(String[] args)
	{
		try{
			String line;
			
			FileReader fileReader = new FileReader ("input.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileWriter fileWriter = new FileWriter("output.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			while((line = bufferedReader.readLine()) != null){
				if(line.length() == 1)
				{
					int size = Integer.parseInt(line);
					double[][] matrix = new double [size][size];
					for(int r = 0; r < matrix.length; r++){
				        String splitLine[] = bufferedReader.readLine().split(" ");
				        matrix[r] = new double[splitLine.length];
				        for(int c = 0; c < matrix[r].length; c++){
				            matrix[r][c] = Integer.parseInt(splitLine[c]);
				        }
				    }
					if(size != 0)
					{
						System.out.println("M = ");
						printMatrix(matrix);
						System.out.println("det(M) = ");
						System.out.println(determinant(size,matrix));
						System.out.println("Minv = ");
						printMatrix(inverse(matrix));
					}
					else
					{
						System.out.println("Done!");
					}
					
					/*for(int i = 0; i < size; i++)
					{
						for(int j = 0; j < size; j++)
						{
							double index = matrix[i][j];
							int num = (int)index;
							System.out.print(num);
							//bufferedWriter.write("hi");
							//bufferedWriter.write(num);
							//bufferedWriter.write(" ");
						}
						bufferedWriter.newLine();
						System.out.println();
					}*/
					
					bufferedWriter.write(size);
				}
			}
			bufferedReader.close();
			bufferedWriter.close();
		}catch(FileNotFoundException e){
			System.out.println("Unable to open file input.txt.");
		}catch(IOException e){
			System.out.println("Couldn't read input.txt");
		}
		
	}
	
	public static void printMatrix(double[][] matrix)
	{
		int size = matrix.length;
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
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
