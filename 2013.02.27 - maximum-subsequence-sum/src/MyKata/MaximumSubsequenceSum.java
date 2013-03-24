package MyKata;

import java.util.Arrays;

public class MaximumSubsequenceSum {
        
    public static int[] findMaximumSubsequenceSum(int[] s) {
        if (s == null) return null;
        if (s.length == 0) return null;
    
        // example inputs:
        // null
        // []
        // [-1]
        // [-1,-1,-1,-2,-1]
        // [1,4,3,2,5]
        // [1,4,-2,5,2,-100,5]
        // [1,2,3,-100,2]
        //
        // hmmmm... 
        //
        // well, we loop through the array, inspect each element one at at time,
        // maintain a running sum as we go.
        // if that sum ever becomes negative, then... we know that it can't possibly
        // contribute to the final answer...?
                
        int bestKnownSum = Integer.MIN_VALUE;
        int bestKnownStartIndex = 0;  // 0; 0; 0; 0;    0;
        int bestKnownEndIndex = 0;    // 0; 1; 2; 2;    2;
        int runningSum = 0;           // 1; 3; 6; -94;  0;  2;
        int startIndex = 0;           // 0; 0; 0; 0;    4;  4 
        int endIndex = 0;             // 0; 1; 2; 3;    4;  4;
        for(int i=0; i<s.length; i++) {
            runningSum += s[i];
            if (runningSum < 0) {  // then reset our subsequence under consideration
                startIndex = i+1;
                endIndex = i+1;
                runningSum = 0;
            } else {
                endIndex = i;
                if (runningSum >= bestKnownSum) {
                    bestKnownSum = runningSum;
                    bestKnownStartIndex = startIndex;
                    bestKnownEndIndex = endIndex;
                }
            }
   
        }
        
        // { startIndex of maximal-summing subsequence, endIndex, the sum itself }
        return new int[] { bestKnownStartIndex, bestKnownEndIndex, bestKnownSum };
    }
    
    public static void main(String[] args) {        
        System.out.println(Arrays.toString( findMaximumSubsequenceSum(new int[] {1,2,3,4,5}) ));
    }
}
