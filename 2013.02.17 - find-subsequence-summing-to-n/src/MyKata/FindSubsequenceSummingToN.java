package MyKata;

/*
26. Finding a consecutive number of integers that give sum S. Do it within O(N) query
input:
10 5 1 1 2 6 5
sum: 9
output
5 1 1 2
*/
public class FindSubsequenceSummingToN {

    public static void find(int[] arr, int targetSum) {
        if (arr.length == 0) {
            System.out.println("Empty array passed in.  Returning.");
            return;
        }
        int a=0, b=0, sum=0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            b++;
            if (sum > targetSum) {
                sum -= arr[a];
                a++;
            } else if (sum == targetSum) {
                System.out.print("Subsequence found: ");
                for(int j=a; j<b; j++) {
                    System.out.print(arr[j]);
                    System.out.print(' ');
                }
                System.out.println();
                return;
            }
        }
        System.out.println(String.format("No subsequence summing to %d found", targetSum));
    }
    
    public static void main(String[] args) {
        find(new int[] { 10, 5, 1, 1, 2, 6, 5 }, 9);
        find(new int[] { 10, 5, 1, 1, 2, 6, 5 }, 100);
    }
}
