package CodingKata;

// Author: aaronfi@ 2011.04.24
//
// Problem:  Given an array of integers, find the longest subsequence that is 
// monotonic, i.e. whose values are non-decreasing.  See http://en.wikipedia.org/wiki/Longest_increasing_subsequence
// 
// Remember that a subsequence may be non-contiguous, in contrast to a substring.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestIncreasingSubsequence {
    
    public static class NumRange {
        public Integer low;
        public Integer high;
        
        public NumRange(Integer low, Integer high) {
            this.low = low;
            this.high = high;
        }
    }
    
    public static int[] findIt(int[] arr) {
        // step 1:  transform (condense and/or possibly expand) our input int array
        // into a NumRange array.
        
        List<NumRange> numRanges = new ArrayList<NumRange>();
        
        NumRange prev = null;
        for(int i=0; i<arr.length; i++) {
            if (prev == null) {
                prev = new NumRange(arr[i], arr[i]);
                numRanges.add(prev);
            } else {
                if (prev.high == arr[i] - 1 || prev.high == arr[i]) {
                    prev.high = arr[i];
                } else {
                    prev = new NumRange(arr[i], arr[i]);
                    numRanges.add(prev);
                }
            }
        }
        
        // step 2:  sort the NumRanges by their "low" end-point 
        Collections.sort(numRanges, new Comparator<NumRange>() {
                public int compare(NumRange r1, NumRange r2) {
                    return r1.low - r2.low;
                }
            });

        
        // step 3:  merge consecutive NumRanges into larger ones.
        List<NumRange> consolidatedNumRange = new ArrayList<NumRange>();
        prev = null;

        for(NumRange curr : numRanges) {
            if (prev == null) {
                prev = new NumRange(curr.low, curr.high);
                consolidatedNumRange.add(prev);
            } else {
                if (prev.high == curr.low - 1 || prev.high == curr.low) {
                    prev.high = curr.high;
                } else {
                    prev = new NumRange(curr.low, curr.high);
                    consolidatedNumRange.add(prev);
                }
            }
        }
        
        // step 4:  sort by NumRange length
        Collections.sort(consolidatedNumRange, new Comparator<NumRange>() {
                public int compare(NumRange r1, NumRange r2) {
                    return (r2.high - r2.low) - (r1.high - r1.low);
                }
            });
        
        NumRange finalRange = consolidatedNumRange.get(0);
        int[] results = new int[finalRange.high - finalRange.low + 1];
        for(int i=0; i<results.length; i++) results[i] = finalRange.low + i;
        return results;
    }
}
