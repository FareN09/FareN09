import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.OptionalInt;
/*---------------------------------------------------------------*/
public class lb1 {
    public static void main(String[] args) {
        System.out.println("\t Matrix creation (20x20 - max): \n");
        int smin = 0;
        int smax = 50;
        Scanner in = new Scanner(System.in);
        System.out.print("Input rows: ");
        int rows = in.nextInt();
        if(rows>20) {
            System.out.println("Too much");
            System.exit(0);
        }
        System.out.print("Input cols: ");
        int cols = in.nextInt();
        if(cols>20) {
            System.out.println("Too much");
            System.exit(0);
        }
        /*---------------------------------------------------------------*/
        System.out.println("Choose automatically (1) or manually (0)");
        int x = in.nextInt();
        if (x == 1) {
            int[][] matrix = createRandomMatrix(rows,cols,smin, smax);
            for (int[] line : matrix) {
                for (int elem : line) {
                    System.out.print(elem + "\t");
                }
                System.out.println();
            }
            /*---------------------------------------------------------------*/
            /*---------------------------------------------------------------*/
            System.out.println("Max element is: "+ getmax(matrix));
            System.out.println("Min element is: "+ getmin(matrix));
            System.out.println("Average is: "+ avg(matrix));
            System.out.println("Geometric mean is: "+ gvg(matrix));
        }
        /*---------------------------------------------------------------*/
        else if (x == 0) {

            int[][] matrix = new int[rows][cols];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print("Get matrix the element[" + i + "][" + j + "]:");
                    matrix[i][j] = in.nextInt();
                }
            }

            for (int[] line : matrix) {
                for (int elem : line) {
                    System.out.print(elem + "\t");
                }
                System.out.println();
            }



            System.out.println("Max element is: "+ getmax(matrix));
            System.out.println("Min element is: "+ getmin(matrix));
            System.out.println("Average is: "+ avg(matrix));
            System.out.println("Geometric mean is: "+ gvg(matrix));


        }
        else System.out.println("Not acceptable");
        System.exit(0);
        /*---------------------------------------------------------------*/

        /*---------------------------------------------------------------*/

    }
    public static int[][] createRandomMatrix(int rows, int cols, int smin, int smax) {
        return IntStream.range(0, rows)
                .mapToObj(i -> new Random()
                        .ints(cols, smin, smax)
                        .toArray())
                .toArray(int[][]::new);
    }
    /*---------------------------------------------------------------*/
    public static int getmax(int[][] matrix) {
        int m = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > m) m = matrix[i][j];
            }
        }
        return m;
    }
    /*---------------------------------------------------------------*/
    public static int getmin(int[][] matrix) {
        int m = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < m) m = matrix[i][j];
            }
        }
        return m;
    }
    /*---------------------------------------------------------------*/
    public static double avg(int[][] matrix) {
        double m = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                m += matrix[i][j] ;
            }}
        return m/(matrix.length*matrix[0].length);
    }
    /*---------------------------------------------------------------*/
    public static double gvg(int[][] matrix) {
        double m = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                m *= matrix[i][j] ;
            }}
        return Math.pow(m,1.0/(matrix.length*matrix[0].length));
    }
}