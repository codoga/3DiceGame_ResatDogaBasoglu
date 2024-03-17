import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetRounds;

        do {
            System.out.print("Enter the Target of Number Rounds Between 1-99 : ");
            targetRounds = scanner.nextInt();
        } while (targetRounds < 1 || targetRounds > 99);

        int[] totalPoints = new int[3];

        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s%n","Round","Player 1","Player 2","Player 3","Total 1","Total 2","Total 3");

        for (int round = 1; round <= targetRounds; round++) {
            int[] diceNumbers = new int[3];

            for (int i = 0; i < 3; i++) {
                diceNumbers[i] = rollDice();
            }

            if (diceNumbers[0] == diceNumbers[1] && diceNumbers[1] == diceNumbers[2]) {
                int points = diceNumbers[0];
                totalPoints[0] += points;
                totalPoints[1] += points;
                totalPoints[2] += points;
            } else if (diceNumbers[0] == diceNumbers[1] || diceNumbers[1] == diceNumbers[2] || diceNumbers[0] == diceNumbers[2]) {
                for (int i = 0; i < 3; i++) {
                    int points = diceNumbers[i];
                    totalPoints[i] += points;
                }
            } else {
                int maxIndex = getMaxIndex(diceNumbers);
                int bonus = diceNumbers[maxIndex] * 2;
                for (int i = 0; i < 3; i++) {
                    if (i == maxIndex) {
                        totalPoints[i] += bonus;
                    } else {
                        totalPoints[i] += diceNumbers[i];
                    }
                }
            }

            System.out.printf("%-10d%-10d%-10d%-10d%-10d%-10d%-10d%n",
                    round, diceNumbers[0], diceNumbers[1], diceNumbers[2],
                    totalPoints[0], totalPoints[1], totalPoints[2]);
        }

        scanner.close();
    }

    private static int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
    private static int getMaxIndex(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}