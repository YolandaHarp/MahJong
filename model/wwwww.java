package model;

import java.util.Arrays;

public class wwwww {
    private static final int NUM_TILES = 34; // 不包含混牌的种类数
    private static final int TOTAL_TILES = 35; // 包含混牌的种类数

    public static void main(String[] args) {
        int[] hand = {0, 0, 0, 1, 1, 1, 2, 2, 2, 5, 5, 14, 34, 34}; // 示例手牌，包括混牌
        System.out.println(canWin(hand));
    }

    public static boolean canWin(int[] hand) {
        if (hand.length != 14) {
            return false; // 如果手牌不是14张，直接返回false
        }
        int[] tileCount = new int[TOTAL_TILES];
        for (int tile : hand) {
            tileCount[tile]++;
        }
        int numMixed = tileCount[34]; // 记录混牌的数量
        tileCount[34] = 0; // 混牌计数重置为0，以免影响其他判断

        return checkWin(tileCount, numMixed);
    }

    private static boolean checkWin(int[] tileCount, int numMixed) {
        for (int i = 0; i < NUM_TILES; i++) {
            if (tileCount[i] >= 2) { // 尝试将第i张牌作为将牌
                tileCount[i] -= 2;
                if (isWinning(tileCount, numMixed)) {
                    return true;
                }
                tileCount[i] += 2; // 还原将牌计数
            }
        }
        if (numMixed >= 2 && isWinning(tileCount, numMixed - 2)) {
            return true; // 如果有2张或以上的混牌，可以将其当作将牌
        }
        return false;
    }

    private static boolean isWinning(int[] tileCount, int numMixed) {
        // 尝试将所有的牌分组
        return checkSets(tileCount, numMixed);
    }

    private static boolean checkSets(int[] tileCount, int numMixed) {
        for (int i = 0; i < NUM_TILES; i++) {
            while (tileCount[i] >= 3) { // 尝试将第i张牌作为刻子
                tileCount[i] -= 3;
                if (checkSets(tileCount, numMixed)) {
                    return true;
                }
                tileCount[i] += 3;
            }
            if (i < 27 && i % 9 < 7) { // 尝试将第i张牌作为顺子
                while (tileCount[i] > 0 && tileCount[i + 1] > 0 && tileCount[i + 2] > 0) {
                    tileCount[i]--;
                    tileCount[i + 1]--;
                    tileCount[i + 2]--;
                    if (checkSets(tileCount, numMixed)) {
                        return true;
                    }
                    tileCount[i]++;
                    tileCount[i + 1]++;
                    tileCount[i + 2]++;
                }
            }
        }
        return checkMixed(tileCount, numMixed);
    }

    private static boolean checkMixed(int[] tileCount, int numMixed) {
        // 检查剩余的牌是否能被混牌补全
        int remainingTiles = 0;
        for (int count : tileCount) {
            remainingTiles += count;
        }
        return remainingTiles <= numMixed * 3; // 每张混牌可以补全最多3张牌
    }
}
