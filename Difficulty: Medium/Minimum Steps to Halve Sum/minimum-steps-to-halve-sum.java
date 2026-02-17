import java.util.*;

class Solution {
    public int minOperations(int[] arr) {
        
        PriorityQueue<Double> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());
        
        double sum = 0;
        
        for (int num : arr) {
            sum += num;
            maxHeap.add((double) num);
        }
        
        double target = sum / 2.0;
        int operations = 0;
        
        while (sum > target) {
            double largest = maxHeap.poll();
            double half = largest / 2.0;
            
            sum -= half;
            maxHeap.add(half);
            operations++;
        }
        
        return operations;
    }
}