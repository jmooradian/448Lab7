import java.util.*;
import java.math.*;
import java.io.*;

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
				//This if statement gets the size from the first item if the length of the line is 1 meaning just one number is present.
				if(line.length() == 1)
				{
					int size = Integer.parseInt(line);
					double[][] matrix = new double [size][size];
					//This for loop goes through everything else and parses the inputs to just get the numbers and splits the spaces
					for(int r = 0; r < size; r++){
				        String splitLine[] = bufferedReader.readLine().split(" ");
				        for(int c = 0; c < size; c++){
				        	//Now in the for loop after splitting the spaces off it then puts them in the matrix so that my other functions
				        	//can now use it.
				            matrix[r][c] = Integer.parseInt(splitLine[c]);
				        }
				    }
					//This is where I call all of the other functions if the size is greater than zero. I
					//If it is greater than 0 there will be a matrix that can be used by these functions.
					//Otherwise it will just print "Done!" because there is no matrix to deal with.
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
					
					//bufferedWriter.write(size);
				}
			}
			//Closes Read and Write for file io.
			bufferedReader.close();
			bufferedWriter.close();
		//Catches if the file does not exist.
		}catch(FileNotFoundException e){
			System.out.println("Unable to open file input.txt.");
		//Catches if it cannot read the file.
		}catch(IOException e){
			System.out.println("Couldn't read input.txt");
		}
		
	}
	//Simple print matrix function, needed because when I write to output.txt it doesnt print numbers, just symbols that dont mean anything
	//You can uncomment what I have commented in and see what I mean.
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
	//Used your code just changed the function to take in a size and matrix.
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
	//Used your code, added a matrix and size input so that I wouldnt have to have a global matrix, realized after the fact I could
	//use matrix.length to get size, but didnt want to risk breaking anything by changing it in every function I already made.
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
	//Used your code, with only modifications to the submatrix function as well as how to use the determinant function.
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
