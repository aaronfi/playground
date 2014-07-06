package CodingKata;


// Given an array N of integers and a target sum T, find any contiguous subsequence
// in N that sums to T.  O(n) performance.
//
// e.g.
// input:  N: [10 5 1 1 2 6 5], sum: 9
// output: [5 1 1 2]

public class FindSubsequenceSummingToN {

    public static int[] find(int[] arr, int targetSum) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int a=0, b=0, sum=0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            b++;
            if (sum > targetSum) {
                sum -= arr[a];
                a++;
            } else if (sum == targetSum) {
                int[] answer = new int[b-a];
                for(int j=a; j<b; j++) {
                    answer[j-a] = arr[j];
                }
                return answer;
            }
        }
        return null;  // no subsequence found
    }
}
