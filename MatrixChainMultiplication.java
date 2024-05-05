import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixChainMultiplication {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Enter the number of matrices: ");
            int n = scanner.nextInt();
        
            int[] p = new int[n + 1];
            System.out.println("Enter the dimensions of matrices: ");
            for (int i = 0; i <= n; i++) {
                p[i] = scanner.nextInt();
            }
            
            int[][] m = new int[n + 1][n + 1];
            int[][] s = new int[n][n + 1];
            
            matrixChainOrder(p, m, s); // Function to compute optimal multiplication
            
            System.out.println("Minimum number of multiplications: " + m[1][n]);
            System.out.println("Optimal parenthesization: ");
            printOptimalParenthesis(s, 1, n); // Function to print optimal parenthesization
            
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers(number) only.");
        } finally {
            scanner.close();
        }
    }
    
    // Function to compute the optimal number of multiplications
    public static void matrixChainOrder(int[] p, int[][] m, int[][] s) {
        int n = p.length - 1;
        
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        
        for (int l = 2; l <= n; l++) 
        {
            for (int i = 1; i <= n - l + 1; i++) 
            {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) 
                {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) 
                    {
                        m[i][j] = q;
                        s[i - 1][j] = k;
                    }
                }
            }
        }
    }
    
    // Function to print optimal parenthesization
    public static void printOptimalParenthesis(int[][] s, int i, int j)
     {
        if (i == j)
         {
            System.out.print("A" + i);
         }
         else
         {
            System.out.print("(");
            printOptimalParenthesis(s, i, s[i - 1][j]);
            printOptimalParenthesis(s, s[i - 1][j] + 1, j);
            System.out.print(")");
        }
    }
}

