import java.util.*;

class Solution {
    public static void sortByLength(String[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(String::length));
    }
}