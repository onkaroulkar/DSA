package com.onkar;

public class RecursionSudoku {
}
/**
 * Algorithm:
 * first create a recursion function called helper().
 * pass the function arguments like board,row index, column index.
 * write a code to decide a next recursive row and column.
 * check weather the number is present at next level or not.
 * if present then call the next level cell.
 * if not present then check the number is safe to place if safe then place the number and call the next level cell
 * if next level cell returns the true then return true as all number placed at right position.if not then remove the number and place the another number;
 *
 * Base condition:
 * if(row == board.lenght return true).
 *
 * Safety check:
 * check weather the same number is not present in the row and column.
 * Also check the duplicate no are not present in the same grid.
 *
 * how to check grid:
 * (row/3)*3;
 * (col/3)*3;
 * 0- first grid
 * 1- second grid
 * 2- third grid
 *
 */

