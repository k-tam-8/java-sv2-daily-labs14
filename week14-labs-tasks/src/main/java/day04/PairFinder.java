package day04;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PairFinder {

    public int findPairs(int[] arr) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!numberMap.containsKey(arr[i])) {
                numberMap.put(arr[i], 1);
            } else {
                numberMap.put(arr[i], numberMap.get(arr[i]) + 1);
            }
            System.out.println(numberMap);
        }
        int sum = 0;
        for (int i : numberMap.values()) {
            sum += i / 2;
        }
        return sum;
    }
}
