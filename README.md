# Matrix-Chain-Multiplication

Input:
The program prompts the user to enter the number of matrices and the dimensions of each matrix.
The dimensions of each matrix are stored in an array p[], where p[i] represents the number of rows of matrix i and the number of columns of matrix i-1.

Matrix Chain Multiplication Function:
The matrixChainOrder function computes the optimal number of multiplications needed to multiply a chain of matrices efficiently.
It populates two matrices, m[][] and s[][].
m[i][j] represents the minimum number of scalar multiplications needed to compute the matrix product A[i]A[i+1]...A[j].
s[i][j] stores the index of the matrix that achieved the optimal multiplication at each step.

Printing Optimal Parenthesization:
The printOptimalParenthesis function recursively prints the optimal parenthesization of the matrix chain based on the matrix s[][].

Main Function:
Reads user input for the number of matrices and their dimensions.
Calls the matrixChainOrder function to compute the optimal multiplication.
Prints the minimum number of multiplications required and the optimal parenthesization.

Exception Handling:
Catches InputMismatchException if the user enters non-integer values.
