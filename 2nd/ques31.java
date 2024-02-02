import java.util.Scanner;

public class ques31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0;  j< N - i; j++) {

                System.out.print(matrix[j][j+i] + " ");
            }
            System.out.println();
        }
    }


}
