import java.util.*;

import static java.lang.Math.pow;

public class CHESS {
    static int[] queen1 = new int[2];
    static int[] queen2 = {0, 0};

    static void QueenPos(int x1, int y1, int x2, int y2, int kingx, int kingy) {
        queen1[0] = kingx + x1;
        queen1[1] = kingy + y1;
        queen2[0] = kingx + x2;
        queen2[1] = kingy + y2;
    }

    static void getQueenPos(int kingx, int kingy) {
        if (kingx == 2 && kingy == 2) {
            QueenPos(-1, 2, 3, -1, kingx, kingy);
        } else if (kingx == 2 && kingy == 7) {
            QueenPos(-1, -2, 3, 1, kingx, kingy);

        } else if (kingx == 7 && kingy == 2) {
            QueenPos(-2, -1, 1, 3, kingx, kingy);

        } else if (kingx == 7 && kingy == 7) {
            QueenPos(-2, 1, 1, -3, kingx, kingy);
        } else if (kingx > 1 && kingx < 8 && kingy > 1 && kingy < 8) {
            if (kingy == 2 || kingy == 7) {
                QueenPos(-2, -1, 2, 1, kingx, kingy);
            } else {
                QueenPos(-1, -2, 1, 2, kingx, kingy);
            }

        } else if (kingx == 1) {
            QueenPos(2, -1, 2, 1, kingx, kingy);
        } else if (kingy == 1) {
            QueenPos(-1, 2, 1, 2, kingx, kingy);
        } else if (kingx == 8) {
            QueenPos(-2, -1, -2, 1, kingx, kingy);
        } else if (kingy == 8) {
            QueenPos(-1, -2, 1, -2, kingx, kingy);
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        for (int i = 0; i < testCase; i++) {
            int kingX = scan.nextInt();
            int kingY = scan.nextInt();
            getQueenPos(kingX, kingY);

            for (int y = 1; y < 9; y++) {
                for (int x = 1; x < 9; x++) {
                    if (x == kingX && y == kingY) {
                        System.out.print("1 ");
                    } else if (x == queen1[0] && y == queen1[1]) {
                        System.out.print("2 ");
                    } else if (x == queen2[0] && y == queen2[1]) {
                        System.out.print("2 ");
                    } else {
                        System.out.print("0 ");
                    }
                }
                System.out.println();
            }
        }
    }
}
