package package2;
import java.util.Scanner;

public class sudoku_solver 
{
	static boolean solver(int[][] board,int row, int col)
	{
		if(row==board.length)
			return true;
		int nrow=0, ncol=0;
		if(col!=board.length-1)
		{
			nrow=row;
			ncol=col+1;
		}
		else
		{
			nrow=row+1;
			ncol=0;
		}
		if(board[row][col]!=0)
		{
			if(solver(board ,nrow,ncol))
				return true;
		}
		else
		{
			for(int i=1;i<=9;i++)
			{
				if(isSafe(board,row,col,i))
				{
					board[row][col]=i;
					if(solver(board,nrow,ncol))
						return true;
				}
				board[row][col]=0;
			}
		}
		return false;
	}
	static boolean isSafe(int[][] board, int row,int col, int n)
	{
		for(int i=0;i<9;i++)
		{
			if(board[i][col]==n)
				return false;
			if(board[row][i]==n)
				return false;
		}
		int sr=(row/3)*3,sc=(col/3)*3;
		for(int i=sr;i<sr+3;i++)
		{
			for(int j=sc;j<sc+3;j++)
			{
				if(board[i][j]==n)
					return false;
			}
		}
		return true;
	}
	static void print(int[][] board)
	{
		for(int i=0;i<board.length;i++)
		{
			if(i==3||i==6)
			{
				System.out.println("------------------");
			}
			for(int j=0;j<board.length;j++)
			{
				System.out.print(board[i][j]+"|");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int[][] board=new int[9][9];
		System.out.println("Enter your sudoku row wise with spaces between numbers:");
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				board[i][j]=sc.nextInt();
			}
		}
		sc.close();
		if(solver(board, 0, 0))
		{
			System.out.println("Your solution is:");
			print(board);
		}
		else
			System.out.println("Solution not found");
	}
}
/* Use the below Sudoku as an example for scanner class

5 3 0 0 7 0 0 0 0
6 0 0 1 9 5 0 0 0
0 9 8 0 0 0 0 6 0
8 0 0 0 6 0 0 0 3
4 0 0 8 0 3 0 0 1
7 0 0 0 2 0 0 0 6
0 6 0 0 0 0 2 8 0
0 0 0 4 1 9 0 0 5
0 0 0 0 8 0 0 7 9

*/