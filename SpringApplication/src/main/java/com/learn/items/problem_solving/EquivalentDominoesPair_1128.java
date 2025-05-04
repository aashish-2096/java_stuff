package com.learn.items.problem_solving;

import java.util.HashMap;
import java.util.Map;

public class EquivalentDominoesPair_1128 {

    public static int nCr(int n, int r) {
        if (r > n)
            return 0;
        if (r == 0 || r == n)
            return 1;
        return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }

    public int numEquivDominoPairsSlow(int[][] dominoes) {
        int equivalentPair = 0;
        Map<String, Integer> keyString = new HashMap<>();
        int dominoesSize = dominoes.length;
        for (int i = 0; i < dominoesSize; i++) {
            String tempLeft = Integer.toString(dominoes[i][0]);
            String tempRight = Integer.toString(dominoes[i][1]);
            String current = tempLeft + "-" + tempRight;
            String flipped = tempRight + "-" + tempLeft;
            if (keyString.get(current) != null) {
                keyString.put(current, keyString.get(current) + 1);
            } else if (keyString.get(flipped) != null) {
                keyString.put(flipped, keyString.get(flipped) + 1);
            } else {
                keyString.put(current, 1);
            }
        }
        for (String key : keyString.keySet()) {
            Integer value = keyString.get(key);
            if (value > 1) {
                equivalentPair += nCr(value, 2);
            }
        }
        return equivalentPair;
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int pair = 0;
        for (int[] d : dominoes) {
            int a = Math.max(d[0], d[1]);
            int b = Math.min(d[0], d[1]);
            int val = a * 10 + b;
            pair += count[val];
            count[val]++;
        }
        return pair;
    }
}