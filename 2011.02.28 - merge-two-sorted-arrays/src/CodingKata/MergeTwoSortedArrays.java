package CodingKata;

// author: aaronfi@ 2011.02.28
	// write a method that, given two already sorted arrays,
	// merges them into one large, sorted array.

public class MergeTwoSortedArrays {
	public static int[] merge(int A[], int B[]) { 	
 	   	int c = A.length + B.length;
  	   	int C[] = new int[c];
  	   	
		int a=A.length-1, b=B.length-1;
  	   	c--;
  	   	while(a >= 0 && b >= 0 && c >= 0) {
            C[c--] = A[a] >= B[b] ? A[a--] : B[b--];  	   		
  	   	}

  	   	// copy over the remaining portion of the longer array
  	   	int t[] = (a >= 0) ? A : B;
  	   	for(int i=c; i>=0; i--) {
  	   		C[i] = t[i];
  	   	}

//     	for(int i=0; i < C.length; i++) System.out.print(C[i] + ",");
  	   	return C;
	}
}
