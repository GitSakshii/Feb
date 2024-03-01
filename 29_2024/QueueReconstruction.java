import java.util.*;

public class QueueReconstruction {
    public static int[] reconstructQueue(int[] heights, int[] inFronts) {
        int n = heights.length;
        int[][] people = new int[n][2]; // [height, inFronts]

        for (int i = 0; i < n; i++) {
            people[i][0] = heights[i];
            people[i][1] = inFronts[i];
        }

        // Sort people by height descending, and if height is same, by inFronts ascending
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1]; // Sort by inFronts ascending if height is same
                } else {
                    return b[0] - a[0]; // Sort by height descending
                }
            }
        });

        List<int[]> result = new ArrayList<>();

        for (int[] person : people) {
            result.add(person[1], person); // Insert person at index equals to his inFronts
        }

        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = result.get(i)[0];
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] heights = new int[n];
        int[] inFronts = new int[n];

        int[] actualOrder = reconstructQueue(heights, inFronts);

        System.out.println("Actual Order:");
        for (int height : actualOrder) {
            System.out.print(height + " ");
        }
    }
}
