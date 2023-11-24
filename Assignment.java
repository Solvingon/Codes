import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students and clubs: ");
        int N = sc.nextInt();
        int[][] costMatrix = new int[N][N];

        System.out.println("Enter the cost matrix:");
        for (int i = 0; i < N; i++) {
            System.out.print("Enter costs for student " + (i + 1) + ": ");
            for (int j = 0; j < N; j++) {
                costMatrix[i][j] = sc.nextInt();
            }
        }

        List<Integer> initialAssignments = new ArrayList<>();
        int currentCost = 0;
        int minCost = bnb(initialAssignments, currentCost, Integer.MAX_VALUE, costMatrix);

        System.out.println("Maximum cost of assignment is: " + minCost);
        sc.close();
    }

    public static int calculateLowerBound(List<Integer> assignments, int[][] costMatrix) {
        int totalCost = 0;
        int N = assignments.size();

        for (int i = 0; i < N; i++) {
            totalCost += costMatrix[i][assignments.get(i)];
        }

        for (int i = 0; i < N; i++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (!assignments.contains(j)) {
                    minCost = Math.min(minCost, costMatrix[i][j]);
                }
            }
            totalCost -= minCost;
        }

        for (int j = 0; j < N; j++) {
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (!assignments.contains(i)) {
                    minCost = Math.min(minCost, costMatrix[i][j]);
                }
            }
            totalCost -= minCost;
        }

        return totalCost;
    }

    public static int bnb(List<Integer> assignments, int currentCost, int minCost, int[][] costMatrix) {
        int N = costMatrix.length;

        if (assignments.size() == N) {
            return currentCost;
        }

        int lowerBound = calculateLowerBound(assignments, costMatrix);

        if (lowerBound >= minCost) {
            return minCost;
        }

        for (int i = 0; i < N; i++) {
            if (!assignments.contains(i)) {
                List<Integer> newAssignments = new ArrayList<>(assignments);
                newAssignments.add(i);
                int newCost = currentCost + costMatrix[assignments.size()][i];
                minCost = Math.min(minCost, bnb(newAssignments, newCost, minCost, costMatrix));
            }
        }

        return minCost;
    }
}
