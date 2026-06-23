import java.util.*;

public class Solution {

    // Method to generate Pascal's Triangle
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // First row is always [1]
        triangle.add(Arrays.asList(1));

        // Loop to generate remaining rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prev = triangle.get(i - 1); // previous row

            row.add(1); // first element is always 1

            // Add the middle elements by summing two numbers from above
            for (int j = 1; j < i; j++) {
                int sum = prev.get(j - 1) + prev.get(j);
                row.add(sum);
            }

            row.add(1); // last element is always 1
            triangle.add(row); // add the row to the triangle
        }

        return triangle;
    }

    // Method to print the triangle in a nice format
    public static void printTriangle(List<List<Integer>> triangle) {
        int totalRows = triangle.size();
        for (int i = 0; i < totalRows; i++) {
            // Print spaces to center-align the triangle
            for (int s = 0; s < totalRows - i - 1; s++) {
                System.out.print("  ");
            }

            // Print each number in the row
            for (int num : triangle.get(i)) {
                System.out.print(num + "   ");
            }
            System.out.println(); // new line after each row
        }
    }

    // Main method to test the program
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> pascalTriangle = generate(numRows);
        System.out.println("Pascal's Triangle for " + numRows + " rows:");
        printTriangle(pascalTriangle);
    }
}
