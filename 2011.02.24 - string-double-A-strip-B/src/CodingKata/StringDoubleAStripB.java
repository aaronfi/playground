package CodingKata;

// author:  aaronfi@ 2011.02.24
// Coding kata:  write a function that, given a string, doubles all occurrences of 'a' in that string,
// and removes all occurrences of 'b'.  Your function should modify the string in-place.  
// The string will have enough "empty slots" at its end to make room for the final modified string.

public class StringDoubleAStripB {
    
    public static String doIt(String str) {
        char[] arr = str.toCharArray();
        
        // loop through the string, keeping track of the leftmost 'b' we've encountered
        // thus far.  We're going to percolate the 'b's through until they are all
        // at the end of the string.
        int nextB = -1;
        for(int i=0; i < arr.length; i++) {
            if (arr[i] == 'b') {
                if (nextB == -1) nextB = i;
            } else if (nextB != -1) {
                arr[nextB] = arr[i];
                arr[i] = 'b';
                nextB = i;
            }
        }

        // loop through the string, right-to-left.  With our 'b's grouped at the end, along
        // with any existing empty slots, together this will serve as our working area in
        // which to shift over the existing string, doubling 'a's as we find them.
        //
        // Given the invariants in the input to this problem, we're guaranteed to always have
        // enough space in our working area.
        int nextChar = arr.length-1;
        for(int i=arr.length-1; i >= 0; i--) {
            if (arr[i] == 'b') arr[i] = '-';
            if (arr[i] == '-') continue;

            arr[nextChar--] = arr[i];
            if (arr[i] == 'a') {
                arr[nextChar--] = 'a';
            }
        }

        return new String(arr);
    }
}
